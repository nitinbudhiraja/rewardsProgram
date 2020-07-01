package com.assignment.rewards.beans;

public class RewardPoint {
    private Long points;
    private Integer month;

    public RewardPoint() {
    }

    public RewardPoint(Long points, Integer month) {
        this.points = points;
        this.month = month;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
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
