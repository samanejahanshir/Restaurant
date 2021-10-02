package com.jahanshir.sm.resturant;

import java.util.Scanner;

public class Customer {
    private String firstName;
    private String lastName;
    private int gender;
    private long mobileNumber;
    public Order[] order = new Order[10];
    public int indexOrder = 0;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Customer(String firstName, String lastName, int gender, long mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        String gender = "";
        if (this.gender == Gender.FEMALE.getGender()) {
            gender = "Female";
        } else if (this.gender == Gender.MALE.getGender()) {
            gender = "Male";
        }
        return firstName + "  "
                + lastName + "  "
                + gender + "  "
                + mobileNumber;

    }

    public static int checkCustomer(String firstName, String lastName) {
        for (int i = 0; i < Restaurant.indexCustomers; i++) {
            if (Restaurant.customers[i].getFirstName().equals(firstName) &&
                    Restaurant.customers[i].getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }

    public static int addNewCustomer() {
        System.out.println("Enter -first name- , -last name- , -0 for male or 1 for female- , mobile number");
        Scanner inputNewCustomer = new Scanner(System.in);
        String firstName = inputNewCustomer.next();
        String lastName = inputNewCustomer.next();
        String gender = inputNewCustomer.next();
        String mobileNumber = inputNewCustomer.next();
        if (CheckValidation.checkString(firstName) && CheckValidation.checkString(lastName) && Integer.parseInt(gender) == 0 || Integer.parseInt(gender) == 1 && CheckValidation.checkInt(mobileNumber)) {
            Restaurant.customers[Restaurant.indexCustomers++] = new Customer(firstName, lastName, Integer.parseInt(gender), Long.parseLong(mobileNumber));
            return Restaurant.indexCustomers - 1;
        }
        return -1;

    }

    public void printDetailOrder() {
        double cost = 0, totalCost = 0;

        for (int i = 0; i < indexOrder; i++) {
            System.out.println("***** Lunch *****");
            if (order[i].indexLunches >= 0) {
                System.out.println(" id of order : " + order[i].getId());
                for (int j = 0; j < order[i].indexLunches; j++) {
                    cost += order[i].lunches[j].calculateCost();
                    System.out.print(order[i].lunches[j].toString() + "  tax: " + Menu.LUNCH.getTaxation() + "  condition: " + order[i].getCondition());
                }
                System.out.println(" cost lunch : " + cost);
                totalCost += cost;
            }
            System.out.println("***** Dinner *****");
            if (order[i].indexDinners >= 0) {
                cost = 0;
                System.out.println(" id of order : " + order[i].getId());
                for (int j = 0; j < order[i].indexDinners; j++) {
                    cost += order[i].dinners[j].calculateCost();
                    System.out.println(order[i].dinners[i].toString() + "  tax:" + Menu.DINNER.getTaxation() + "  condition :" + order[i].getCondition());
                }
                System.out.println(" cost dinner : " + cost);
                totalCost += cost;

            }
            System.out.println("***** Beverages *****");
            if (order[i].indexBeverages >= 0) {
                cost = 0;
                System.out.println(" id of order : " + order[i].getId());
                for (int j = 0; j < order[i].indexBeverages; j++) {
                    cost += order[i].beverages[j].calculateCost();
                    System.out.println(order[i].beverages[j].toString() + "  condition : " + order[i].getCondition());
                }
                System.out.println(" cost Beverages: " + cost);
                totalCost += cost;

            }
            System.out.println(" Total cost order : " + totalCost);

        }
    }

    public boolean addNewOrder() {
        boolean addLunch = false, addDinner = false, addBeverage = false;
        System.out.println("1.Lunch \n 2.Dinner");
        Scanner inputNumScanner = new Scanner(System.in);
        String selectNum = inputNumScanner.next();
        if (CheckValidation.checkInt(selectNum) && Integer.parseInt(selectNum) == 1) {
            Restaurant.printLunchMenu();
            Restaurant.printBeveragesMenu();
            System.out.println("enter id of lunch");
            String selectLunch = inputNumScanner.next();
            System.out.println("enter id of Beverages");
            String selectBeverages = inputNumScanner.next();
            if (CheckValidation.checkInt(selectLunch)) {
                int indexLunch = Restaurant.searchLunch(Integer.parseInt(selectLunch));
                if (indexLunch != -1 && Restaurant.lunches[indexLunch].getCount() > 0) {
                    this.order[indexOrder] = new Order();
                    this.order[indexOrder].setId(indexOrder + 1);
                    this.order[indexOrder].lunches[order[indexOrder].indexLunches] = Restaurant.lunches[indexLunch];
                    this.order[indexOrder].setCondition(true);
                    order[indexOrder].indexLunches++;
                    addLunch = true;
                    Restaurant.lunches[indexLunch].setCount(Restaurant.lunches[indexLunch].getCount() - 1);
                } else {
                    System.out.println("this lunch not exist ");
                }
            }
            if (CheckValidation.checkInt(selectBeverages)) {
                int indexBeverage = Restaurant.searchBeverages(Integer.parseInt(selectBeverages));
                if (indexBeverage != -1 && Restaurant.beverages[indexBeverage].getCount() > 0) {
                    this.order[indexOrder].setId(indexOrder + 1);
                    this.order[indexOrder].beverages[order[indexOrder].indexBeverages] = Restaurant.beverages[indexBeverage];
                    order[indexOrder].indexBeverages++;
                    addBeverage = true;
                    Restaurant.beverages[indexBeverage].setCount(Restaurant.beverages[indexBeverage].getCount() - 1);
                } else {
                    System.out.println("this lunch not exist ");
                }
            }
            indexOrder++;
            return addBeverage && addLunch;
        } else if (CheckValidation.checkInt(selectNum) && Integer.parseInt(selectNum) == 2) {
            Restaurant.printDinnerMenu();
            Restaurant.printBeveragesMenu();
            System.out.println("enter id of dinner");
            String selectDinner = inputNumScanner.next();
            System.out.println("enter id of Beverages");
            String selectBeverages = inputNumScanner.next();
            if (CheckValidation.checkInt(selectDinner)) {
                int indexDinner = Restaurant.searchDinner(Integer.parseInt(selectDinner));
                if (indexDinner != -1 && Restaurant.dinners[indexDinner].getCount() > 0) {
                    this.order[indexOrder] = new Order();
                    this.order[indexOrder].setId(indexOrder + 1);
                    this.order[indexOrder].dinners[order[indexOrder].indexDinners] = Restaurant.dinners[indexDinner];
                    order[indexOrder].indexDinners++;
                    addDinner = true;
                    Restaurant.dinners[indexDinner].setCount(Restaurant.dinners[indexDinner].getCount() - 1);
                } else {
                    System.out.println("this lunch not exist ");
                }
            }
            if (CheckValidation.checkInt(selectBeverages)) {
                int indexBeverage = Restaurant.searchBeverages(Integer.parseInt(selectBeverages));
                if (indexBeverage != -1 && Restaurant.beverages[indexBeverage].getCount() > 0) {
                    this.order[indexOrder].setId(indexOrder + 1);
                    this.order[indexOrder].beverages[order[indexOrder].indexBeverages] = Restaurant.beverages[indexBeverage];
                    order[indexOrder].indexBeverages++;
                    addBeverage = true;
                    Restaurant.beverages[indexBeverage].setCount(Restaurant.beverages[indexBeverage].getCount() - 1);
                } else {
                    System.out.println("this lunch not exist ");
                }
            }
            indexOrder++;
            return (addBeverage && addDinner);
        }

        return false;
    }

    public boolean cancelOrder(int index) {
        if (order[index - 1] != null) {
            this.order[index - 1].setCondition(false);
            return true;
        }
        return false;
    }
}