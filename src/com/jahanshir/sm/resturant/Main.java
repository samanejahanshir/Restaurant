package com.jahanshir.sm.resturant;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner inputScanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        int menuSelect;
        int indexCustomer = -1;

        boolean checkCustomer = false;
        while (true) {
            int userSelect = restaurant.selectUser();
            if (userSelect == 1) {
                while (true) {
                    menuSelect = restaurant.selectFromManagerMenu();
                    if (menuSelect != -1 && menuSelect != 4) {
                        switch (menuSelect) {
                            case 1:
                                Restaurant.manager.selectLunchOrBeverages();
                                break;
                            case 2:
                                Restaurant.manager.selectDinnerOrBeverages();
                                break;
                            case 3:
                                Restaurant.manager.printCustomerInfo();
                                break;
                        }

                    } else if (menuSelect == 4) {
                        break;
                    } else {
                        System.out.println("you enter invalid number!! please try again...");
                        continue;
                    }
                }

            } else if (userSelect == 2) {
                indexCustomer = Customer.addNewCustomer();
                if (indexCustomer != -1) {
                    System.out.println("you add to list successfully");
                    checkCustomer = true;
                } else {
                    System.out.println("there was a problem to add you in list ");

                }

            }
            while (checkCustomer) {
                menuSelect = restaurant.selectFromCustomerMenu();
                if (menuSelect != -1 && menuSelect != 4) {
                    switch (menuSelect) {
                        case 1:
                            Restaurant.customers[indexCustomer].addNewOrder();
                            break;
                        case 2:
                            Restaurant.customers[indexCustomer].printDetailOrder();
                            break;
                        case 3:
                            System.out.println("enter id of order");
                            String inputId = inputScanner.next();
                            if (CheckValidation.checkInt(inputId)) {
                                boolean checkCancel = Restaurant.customers[indexCustomer].cancelOrder(Integer.parseInt(inputId));
                                if (checkCancel) {
                                    System.out.println("canceling done");
                                } else {
                                    System.out.println("canceling not done");

                                }
                            } else {
                                System.out.println("order with this id not found !");

                            }
                            break;
                    }
                } else if (menuSelect == 4) {
                    break;
                } else {
                    System.out.println("you enter invalid number!! please try again...");
                    continue;
                }


            }
            if (userSelect == 3) {
                break;
            } else {
                checkCustomer = false;
                System.out.println("you enter invalid number!! please try again...");
            }

        }
    }
}
