package com.jahanshir.sm.resturant;

public class Dinner extends Edible {
    public Dinner(int id, String name, int price, int count) {
        super(id, name, price, count);
    }

    @Override
    public Double calculateCost() {
        double cost = getPrice() + getPrice() * Menu.DINNER.getTaxation();
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
