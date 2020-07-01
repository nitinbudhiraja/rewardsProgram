package com.assignment.rewards.services;

import com.assignment.rewards.domain.Transaction;
import com.assignment.rewards.beans.RewardPoint;
import com.assignment.rewards.beans.Reward;

import com.assignment.rewards.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.assignment.rewards.utils.RewardUtils.*;

@Service
public class RewardService {

    @Value("${rewards.data.month.range}")
    private Integer monthRange;

    @Autowired
    private TransactionRepository transactionRepository;

    public Collection<Reward> getRewards(){
        List<Transaction> transactionList = new ArrayList<>();

        //Get the data for last ${rewards.data.month.range} months
        transactionRepository
                .findAllByTransactionDateBetween(LocalDate.now().minusMonths(monthRange), LocalDate.now())
                .forEach(transactionList::add);

        Map<Long, Reward> customerRewardPointsMap = new HashMap<>();

        //Iterate over the transaction data
        transactionList.forEach(transaction -> {
            //Check if we already have this customer data in results
            if(customerRewardPointsMap.containsKey(transaction.getCustomerId())){
                Reward customerRewardPoints = customerRewardPointsMap.get(transaction.getCustomerId());

                //Get existing monthly reward points for the customer
                List<RewardPoint> monthlyRewardPointsEarned = customerRewardPoints.getMonthlyRewardPoints();

                //To track if we already have rewards point data for the month
                boolean isMonthEntryFound = false;
                for(RewardPoint monthlyRewardPoint : monthlyRewardPointsEarned){
                    if(monthlyRewardPoint.getMonth() == transaction.getTransactionDate().getMonthValue()){
                        updateCustomerMonthlyRewards(transaction, customerRewardPoints, monthlyRewardPoint);
                        isMonthEntryFound = true;
                        break;
                    }
                }

                //If customer doesn't have transaction data for given month, then add customer reward data for the month
                if(!isMonthEntryFound){
                    addCustomerMonthlyRewards(transaction, customerRewardPoints, monthlyRewardPointsEarned);
                }
            }else {
                addCustomerRewards(customerRewardPointsMap, transaction);
            }
        });
        return customerRewardPointsMap.values();
    }

    /**
     * Method to update customer monthly reward points of a month for which we already have rewards points
     * @param transaction transaction data
     * @param customerRewardPoints customer's existing reward points
     * @param monthlyRewardPoint customer's monthly reward points
     */
    private void updateCustomerMonthlyRewards(Transaction transaction, Reward customerRewardPoints, RewardPoint monthlyRewardPoint) {
        Long earnedPoints = monthlyRewardPoint.getPoints() + calculateReward(transaction.getAmount());
        Long totalEarnedPoints = customerRewardPoints.getTotalRewardPoints() + calculateReward(transaction.getAmount());
        customerRewardPoints.setTotalRewardPoints(totalEarnedPoints);
        monthlyRewardPoint.setPoints(earnedPoints);
    }

    /**
     * Method to add rewards for customer for which we don't already have reward points
     * @param customerRewardPointsMap customer's existing reward points
     * @param transaction transaction data
     */
    private void addCustomerRewards(Map<Long, Reward> customerRewardPointsMap, Transaction transaction) {
        Reward customerReward = new Reward();
        customerReward.setCustomerId(transaction.getCustomerId());
        List<RewardPoint> rewardPointsEarned = new ArrayList<>();
        RewardPoint rewardPoint = new RewardPoint(calculateReward(transaction.getAmount()), transaction.getTransactionDate().getMonthValue());
        rewardPointsEarned.add(rewardPoint);
        customerReward.setMonthlyRewardPoints(rewardPointsEarned);
        customerReward.setTotalRewardPoints(calculateReward(transaction.getAmount()));
        customerRewardPointsMap.put(transaction.getCustomerId(), customerReward);
    }

    /**
     * Method to add customer monthly reward points of a month for which we don't already have rewards points
     * @param transaction transaction data
     * @param customerRewardPoints customer's existing reward points
     * @param monthlyRewardPointsEarned customer's monthly reward points
     */
    private void addCustomerMonthlyRewards(Transaction transaction, Reward customerRewardPoints, List<RewardPoint> monthlyRewardPointsEarned) {
        RewardPoint rewardPoint = new RewardPoint(calculateReward(transaction.getAmount()), transaction.getTransactionDate().getMonthValue());
        monthlyRewardPointsEarned.add(rewardPoint);
        customerRewardPoints.setTotalRewardPoints(customerRewardPoints.getTotalRewardPoints() + calculateReward(transaction.getAmount()));
    }
}
