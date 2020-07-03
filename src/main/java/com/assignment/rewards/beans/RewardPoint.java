package com.assignment.rewards.beans;

public class RewardPoint {
    private Long points;
    private String month;

    public RewardPoint() {
    }

    public RewardPoint(Long points, String month) {
        this.points = points;
        this.month = month;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "RewardPoint{" +
                "amount=" + points +
                ", month=" + month +
                '}';
    }
}
