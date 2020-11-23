package com.example.securitytrainingapp.ui.profile;

public class Reward {
    String name;
    int pointsNeeded;
    boolean redeemed;

    public Reward(String name, int pointsNeeded) {
        this.name = name;
        this.pointsNeeded = pointsNeeded;
        this.redeemed = false;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPointsNeeded() { return pointsNeeded; }

    public void setPointsNeeded(int pointsNeeded) { this.pointsNeeded = pointsNeeded; }

    public void redeem() { this.redeemed = true; }

    public boolean isRedeemed() { return this.redeemed; }
}
