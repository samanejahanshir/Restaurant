package com.jahanshir.sm.resturant;

import java.util.Scanner;

public class Manager {
    public void selectLunchOrBeverages() {
        System.out.println("1.Add Beverages \n 2.Add Lunch");
        Scanner inputNumScanner = new Scanner(System.in);
        String inputNumber = inputNumScanner.next();
        if (CheckValidation.checkInt(inputNumber)) {
            if (Integer.parseInt(inputNumber) == 1) {
                if (addBeverages()) {
                    System.out.println("add beverages successfully . ");

                } else {
                    System.out.println("Not add this beverages . ");

                }
            } else if (Integer.parseInt(inputNumber) == 2) {
                if (addLunch()) {
                    System.out.println("add Lunch successfully . ");
                } else {
                    System.out.println("Not add this lunch . ");

                }
            } else {
                System.out.println(" enter 1 or 2 ! ");

            }

        } else {
            System.out.println(" enter valid number please ! ");
        }
    }

    public void selectDinnerOrBeverages() {
        System.out.println("1.Add Beverages \n 2.Add Dinner");
        Scanner inputNumScanner = new Scanner(System.in);
        String inputNumber = inputNumScanner.next();
        if (CheckValidation.checkInt(inputNumber)) {
            if (Integer.parseInt(inputNumber) == 1) {
                if (addBeverages()) {
                    System.out.println("add beverage successfully . ");
                } else {
                    System.out.println("Not add this Beverages . ");

                }
            } else if (Integer.parseInt(inputNumber) == 2) {
                if (addDinner()) {
                    System.out.println("add dinner successfully . ");
                } else {
                    System.out.println("Not add this dinner . ");

                }
            } else {
                System.out.println(" enter 1 or 2 ! ");

            }

        } else {
            System.out.println(" enter valid number please ! ");
        }

    }

    public boolean addBeverages() {
        System.out.println("enter -name- , -price- , -count- of this ");
        Scanner inputBeverages = new Scanner(System.in);
        String name = inputBeverages.next();
        String price = inputBeverages.next();
        String count = inputBeverages.next();
        if (CheckValidation.checkString(name) && CheckValidation.checkInt(price) && CheckValidation.checkInt(count)) {
            Restaurant.beverages[Restaurant.indexBeverages] = new Beverages(Restaurant.indexBeverages + 100, name, Integer.parseInt(price), Integer.parseInt(count));
            Restaurant.indexBeverages++;
            return true;
        }
        return false;
    }

    public void printCustomerInfo() {
        System.out.println(" ***** Customer Info ***** ");

        if (Restaurant.indexCustomers < 1) {
            System.out.println(" There Aren't Any Customer To Show ! ");
        } else {
            System.out.println("FName  LName  gender  mobileNumber");

            for (int i = 0; i < Restaurant.indexCustomers; i++) {
                System.out.println(Restaurant.customers[i].toString());

            }
        }
    }

    public boolean addLunch() {
        System.out.println("enter -name- , -price- , -count- of this ");
        Scanner inputLunch = new Scanner(System.in);
        String name = inputLunch.next();
        String price = inputLunch.next();
        String count = inputLunch.next();
        if (CheckValidation.checkString(name) && CheckValidation.checkInt(price) && CheckValidation.checkInt(count)) {
            Restaurant.lunches[Restaurant.indexLunches] = new Lunch(Restaurant.indexLunches + 200, name, Integer.parseInt(price), Integer.parseInt(count));
            Restaurant.indexLunches++;
            return true;
        }
        return false;
    }

    public boolean addDinner() {
        System.out.println("enter -name- , -price- , -count- of this ");
        Scanner inputDinner = new Scanner(System.in);
        String name = inputDinner.next();
        String price = inputDinner.next();
        String count = inputDinner.next();
        if (CheckValidation.checkString(name) && CheckValidation.checkInt(price) && CheckValidation.checkInt(count)) {
            Restaurant.dinners[Restaurant.indexDinners] = new Dinner(300 + Restaurant.indexDinners, name, Integer.parseInt(price), Integer.parseInt(count));
            Restaurant.indexDinners++;
            return true;
        }
        return false;
    }
}
