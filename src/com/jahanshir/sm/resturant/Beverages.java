package com.jahanshir.sm.resturant;

public class Beverages extends Edible {
    public Beverages(int id, String name, int price, int count) {
        super(id, name, price, count);
    }

    @Override
    public Double calculateCost() {
        return (double) getPrice();
    }

    @Override
    public String toString() {
        return getId() + "  "
                + getName() + "  "
                + getPrice() + "  "
                + getCount();
    }
}
