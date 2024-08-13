package javaapplication3;

import java.util.Scanner;
import java.util.ArrayList;

public class NewMain1 {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        String alaptops[] = {"LENOVO i5 12gen", "ACER i5 12gen", "SAMSUNG i9 12gen", "CHERRY i5 12gen"};
        int pricealaptops[] = {5000, 6000, 7000, 9000};
        boolean laptopsOUT[] = {true, true, true, true};
        int cash1;
        
        

        while (true) {
            System.out.println("----------------------------LAPTOP SALES--------------------------");
            System.out.println("1. SHOW AVAILABLE LAPTOP");
            System.out.println("2. SHOW SOLD OUT LAPTOP");
            System.out.println("3. ADD LAPTOP TO SHOP");
            System.out.println("4. REMOVE LAPTOP TO SHOP");
            System.out.println("5. EXIT SYSTEM");

            System.out.print("Enter your choice: ");
            while (!x.hasNextInt()) {
                System.out.println("Invalid input, please enter numbers only!");
                x.next();
                System.out.print("Enter your choice: ");
            }
            int choice = x.nextInt();

            if (choice == 1) {
                for (int i = 0; i < alaptops.length; i++) {
                    if (laptopsOUT[i]) {
                        System.out.println((i + 1) + " > " + alaptops[i]);
                    }
                }

                System.out.print("Show prices of laptop: ");
                while (!x.hasNextInt()) {
                    System.out.println("Invalid input, please enter numbers only!");
                    x.next();
                    System.out.print("Show prices of laptop: ");
                }
                int prices = x.nextInt();

                if (prices > 0 && prices <= alaptops.length && laptopsOUT[prices - 1]) {
                    System.out.println("LAPTOP > " + alaptops[prices - 1]);
                    System.out.println("PRICE > " + pricealaptops[prices - 1]);
                } else {
                    System.out.println("Invalid choice or laptop is sold out.");
                    continue;
                }

                x.nextLine();  // consume newline

                System.out.println("-----------------------------------------");
                System.out.println("You want to buy this laptop?? YES/NO");
                String inputu = x.nextLine();

                if (inputu.equalsIgnoreCase("YES")) {
                    System.out.print("Enter a amount of your cash > ");
                    while (!x.hasNextInt()) {
                        System.out.println("Invalid input, can put numbers only!");
                        x.next();
                        System.out.print("Enter a amount of your cash > ");
                    }
                    int cash = x.nextInt();

                    if (cash >= pricealaptops[prices - 1]) {
                        int total = cash - pricealaptops[prices - 1];
                        System.out.println("---------YOU SOLD THE LAPTOP-------------");
                        System.out.println("LAPTOP > " + alaptops[prices - 1]);
                        System.out.println("PRICE > " + pricealaptops[prices - 1]);
                        System.out.println("YOUR CASH > " + cash);
                        System.out.println("EXCHANGE > " + total);
                        laptopsOUT[prices - 1] = false;
                    } else {
                        while (cash < pricealaptops[prices - 1]) {
                            System.out.println("Insufficient Cash!");
                            System.out.print("Enter a amount of your cash > ");

                            while (!x.hasNextInt()) {
                                System.out.println("Invalid Input, just numbers only!");
                                x.next();
                                System.out.print("Enter a amount of your cash > ");
                            }
                            cash1 = x.nextInt();

                            if (cash1 >= pricealaptops[prices - 1]) {
                                int total = cash1 - pricealaptops[prices - 1];
                                System.out.println("---------YOU SOLD THE LAPTOP-------------");
                                System.out.println("LAPTOP > " + alaptops[prices - 1]);
                                System.out.println("PRICE > " + pricealaptops[prices - 1]);
                                System.out.println("YOUR CASH > " + cash1);
                                System.out.println("EXCHANGE > " + total);
                                laptopsOUT[prices - 1] = false;
                                break;
                            }
                        }
                    }
                }

            } else if (choice == 2) {
                System.out.println("----------SOLD OUT LAPTOPS------------");
                boolean soldout = false;
                for (int i = 0; i < alaptops.length; i++) {
                    if (!laptopsOUT[i]) {
                        System.out.println((i + 1) + " > " + alaptops[i] + " SOLD OUT");
                        soldout = true;
                    }
                }
                if (!soldout) {
                    System.out.println("No laptops sold out");
                }

            } else if (choice == 3) {
                System.out.println("ADDING ITEM TO SHOP...");
                x.nextLine();
                while (true) {

                    System.out.print("Enter a name of laptop and specs: ");
                    String name1 = x.nextLine();
                    System.out.print("Enter a price of a laptop: ");
                    while (!x.hasNextDouble()) {
                        System.out.println("Invalid input, please enter numbers only!");
                        x.next();
                        System.out.print("Enter a price of a laptop: ");
                    }
                    double price1 = x.nextDouble();

                    String[] newlaptops = new String[alaptops.length + 1];
                    int[] newspecs = new int[pricealaptops.length + 1];
                    boolean[] newlaptopsx = new boolean[laptopsOUT.length + 1];

                    for (int i = 0; i < alaptops.length; i++) {
                        newlaptops[i] = alaptops[i];
                        newspecs[i] = pricealaptops[i];
                        newlaptopsx[i] = laptopsOUT[i];
                    }
                    newlaptops[alaptops.length] = name1;
                    newspecs[pricealaptops.length] = (int) price1;
                    newlaptopsx[laptopsOUT.length] = true;

                    alaptops = newlaptops;
                    pricealaptops = newspecs;
                    laptopsOUT = newlaptopsx;

                    System.out.println("Laptop added successfully!");
                    x.nextLine();

                    System.out.println("Do you want to add a laptop again?? YES/NO");
                    String again = x.nextLine();
                    if (again.equalsIgnoreCase("yes")) {
                        continue;
                    } else {
                        break;
                    }
                }

            } else if (choice == 4) {
                System.out.println("REMOVING LAPTOPS OR NOT AVAILABLE!");
                x.nextLine();
                for (int i = 0; i < alaptops.length; i++){
                    System.out.println((i + 1) + " > " + alaptops[i]);
                }
                System.out.print("Enter the number of the laptop you want to remove (1 to " + alaptops.length + "): ");
                while (!x.hasNextInt()) {
                    System.out.println("Invalid input, please enter numbers only!");
                    x.next();
                    System.out.print("Enter the number of the laptop you want to remove (1 to " + alaptops.length + "): ");
                }
                int rlaptop = x.nextInt();

                if (rlaptop > 0 && rlaptop <= alaptops.length) {
                    String[] newLaptops = new String[alaptops.length - 1];
                    int[] newPrices = new int[pricealaptops.length - 1];
                    boolean[] newLaptopsOUT = new boolean[laptopsOUT.length - 1];
                    int index = 0;

                    for (int i = 0; i < alaptops.length; i++) {
                        if (i != rlaptop - 1) {
                            newLaptops[index] = alaptops[i];
                            newPrices[index] = pricealaptops[i];
                            newLaptopsOUT[index] = laptopsOUT[i];
                            index++;
                        }
                    }

                    alaptops = newLaptops;
                    pricealaptops = newPrices;
                    laptopsOUT = newLaptopsOUT;

                    System.out.println("Laptop removed successfully!");
                } else {
                    System.out.println("Invalid laptop number. Please enter a valid number.");
                }
            } else if (choice == 5) {
                System.out.println("Exiting system...");
                x.close();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

                                        
                        
                    
               