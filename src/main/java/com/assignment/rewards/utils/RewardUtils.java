package com.assignment.rewards.utils;

public class RewardUtils {

    private static final Long FIRST_AMOUNT_FILTER = 50l;
    private static final Long SECOND_AMOUNT_FILTER = 100l;

    public static Long calculateReward(Long transactionAmount){
        Long rewardEarned = 0l;
        if(transactionAmount > FIRST_AMOUNT_FILTER && transactionAmount <=SECOND_AMOUNT_FILTER){
            rewardEarned += transactionAmount-FIRST_AMOUNT_FILTER;
        }else if(transactionAmount > SECOND_AMOUNT_FILTER){
            rewardEarned += (2*(transactionAmount-SECOND_AMOUNT_FILTER)) + FIRST_AMOUNT_FILTER;
        }
        return rewardEarned;
    }
}
