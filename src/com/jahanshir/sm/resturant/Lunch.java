package com.jahanshir.sm.resturant;

public class Lunch extends Edible {
    public Lunch(int id, String name, int price, int count) {
        super(id, name, price, count);
    }

    @Override
    public Double calculateCost() {
        double cost = getPrice() + getPrice() * Menu.LUNCH.getTaxation();
        return cost;
    }

    @Override
    public String toString() {
        return getId() + "  "
                + getName() + "  "
                + getPrice() + "  "
                + getCount();
    }

}
