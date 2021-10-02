package com.jahanshir.sm.resturant;

import java.util.Scanner;

public class Restaurant {
    public static Lunch[] lunches = new Lunch[100];
    public static Dinner[] dinners = new Dinner[100];
    public static Beverages[] beverages = new Beverages[100];
    public static Customer[] customers = new Customer[100];
    public static int indexLunches = 0, indexDinners = 0, indexBeverages = 0, indexCustomers = 0;
    public static Manager manager = new Manager();

    public int selectUser() {
        System.out.println("***** Welcome To This Restaurant *****");
        System.out.println("Please Select a user type :\n 1. Log in as manager \n 2. Log in as customer \n 3.Exit");
        Scanner userScanner = new Scanner(System.in);
        String userSelect = userScanner.next();
        if (CheckValidation.checkInt(userSelect)) {
            if (Integer.parseInt(userSelect) == Person.MANAGER.getId()) {
                return Person.MANAGER.getId();
            } else if (Integer.parseInt(userSelect) == Person.CUSTOMER.getId()) {
                return Person.CUSTOMER.getId();
            } else if (Integer.parseInt(userSelect) == 3) {
                return 3;
            } else {
                return -1;
            }
        } else {
            return -1;
        }

    }

    public int selectFromManagerMenu() {
        System.out.println("***** Manager Menu *****");
        System.out.println("1.Add To Lunch Menu \n 2.Add To Dinner Menu \n 3.Customer Info \n 4. Back To Main Menu");
        Scanner menuSelectScanner = new Scanner(System.in);
        String menuSelect = menuSelectScanner.next();
        if (CheckValidation.checkInt(menuSelect)) {
            switch (Integer.parseInt(menuSelect)) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                default:
                    return -1;
            }
        } else {
            return -1;
        }
    }

    public int selectFromCustomerMenu() {
        System.out.println("***** Customer Menu *****");
        System.out.println(" 1.Add New Order \n 2.Show Detail Order \n 3.Cancel An Order \n 4. Back To Main Menu");
        Scanner menuSelectScanner = new Scanner(System.in);
        String menuSelect = menuSelectScanner.next();
        if (CheckValidation.checkInt(menuSelect)) {
            switch (Integer.parseInt(menuSelect)) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                default:
                    return -1;
            }
        } else {
            return -1;
        }

    }

    public static int searchLunch(int id) {
        for (int i = 0; i < indexLunches; i++) {
            if (lunches[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int searchDinner(int id) {
        for (int i = 0; i < indexDinners; i++) {
            if (dinners[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int searchBeverages(int id) {
        for (int i = 0; i < indexBeverages; i++) {
            if (beverages[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int searchCustomer(String firstName, String lastName) {
        for (int i = 0; i < indexCustomers; i++) {
            if (customers[i].getFirstName().equals(firstName) && customers[i].getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }

    public static void printLunchMenu() {
        for (int i = 0; i < indexLunches; i++) {
            System.out.println(lunches[i].toString());
        }

    }

    public static void printDinnerMenu() {
        for (int i = 0; i < indexDinners; i++) {
            System.out.println(dinners[i].toString());
        }

    }

    public static void printBeveragesMenu() {
        for (int i = 0; i < indexBeverages; i++) {
            System.out.println(beverages[i].toString());
        }

    }
}

