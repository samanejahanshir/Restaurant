package com.jahanshir.sm.resturant;

public enum Gender {
    MALE(0),
    FEMALE(1);
    private int gender;

    Gender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }
}
