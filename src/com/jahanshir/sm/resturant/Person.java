package com.jahanshir.sm.resturant;

public enum Person {
    CUSTOMER(2),
    MANAGER(1);
private int id;
    Person(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
