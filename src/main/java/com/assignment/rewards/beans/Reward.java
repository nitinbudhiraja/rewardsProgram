package com.assignment.rewards.beans;

import java.util.ArrayList;
import java.util.List;


public class Reward {
    private Long customerId;
    private Long totalRewardPoints;
    private List<RewardPoint> monthlyRewardPoints = new ArrayList<>();

    public Reward() {
    }

    public Reward(Long customerId, Long totalRewardPoints, List<RewardPoint> monthlyRewardPoints) {
        this.customerId = customerId;
        this.totalRewardPoints = totalRewardPoints;
        this.monthlyRewardPoints = monthlyRewardPoints;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(Long totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    public List<RewardPoint> getMonthlyRewardPoints() {
        return monthlyRewardPoints;
    }

    public void setMonthlyRewardPoints(List<RewardPoint> monthlyRewardPoints) {
        this.monthlyRewardPoints = monthlyRewardPoints;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "customerId=" + customerId +
                ", totalRewards=" + totalRewardPoints +
                ", pointsEarned=" + monthlyRewardPoints +
                '}';
    }
}
