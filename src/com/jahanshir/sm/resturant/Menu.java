package com.jahanshir.sm.resturant;

public enum Menu {
    LUNCH(0.10),
    DINNER(0.15);
    private double taxation;

    Menu(double tax) {
        this.taxation = tax;
    }

    public double getTaxation() {
        return taxation;
    }
}
