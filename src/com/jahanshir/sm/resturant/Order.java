package com.jahanshir.sm.resturant;

import java.util.Scanner;

public class Order {

    private boolean Condition = false;
    private int id;
    Lunch[] lunches = new Lunch[10];
    Dinner[] dinners = new Dinner[10];
    Beverages[] beverages = new Beverages[10];
    public int indexLunches = 0, indexDinners = 0, indexBeverages = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getCondition() {
        return Condition;
    }

    public void setCondition(boolean condition) {
        Condition = condition;
    }

    public Lunch[] getLunches() {
        return lunches;
    }

    public void setLunches(Lunch[] lunches) {
        this.lunches = lunches;
    }

    public Dinner[] getDinners() {
        return dinners;
    }

    public void setDinners(Dinner[] dinners) {
        this.dinners = dinners;
    }

    public Beverages[] getBeverages() {
        return beverages;
    }

    public void setBeverages(Beverages[] beverages) {
        this.beverages = beverages;
    }


}
