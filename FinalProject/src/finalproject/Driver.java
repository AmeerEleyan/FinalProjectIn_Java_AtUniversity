/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject; // package name

import java.util.InputMismatchException;
import java.util.Scanner;

// define a driver class
public class Driver {

    public static void main(String[] args) {
        System.out.println("\n\t\t\tPalestinian Vehicle Agency...");
        // Which choice
        int choice;
        // read from user
        Scanner inputDevice = new Scanner(System.in);
        // print menu
        Utility.menu();
        while (true) {
            try {
                // read choice from user
                choice = inputDevice.nextInt();
                while (choice != 10) {
                    switch (choice) {
                        // read from file
                        case 1:
                            Utility.readDataFromFile();
                            break;
                        // Set petroleum price
                        case 2:
                            Utility.setPetroleumPrice();
                            break;
                        // sort vehicles based on user request
                        case 3:
                        case 4:
                        case 5:
                            Utility.sortVehicles(choice);
                            break;
                        // Cloning vehicles
                        case 6:
                            Utility.cloneVehicle();
                            break;
                        // turn condition on for all vehicles
                        case 7:
                            Utility.turnConditionsOnForAllVehicles();
                            break;
                        // turn condition off for all vehicles
                        case 8:
                            Utility.turnConditionsOffForAllVehicles();
                            break;
                        // write data in file
                        case 9:
                            Utility.writeDataInFile();
                            break;
                        // Not in the list
                        default:
                            System.out.println("The option is not in the list. Try again");
                    }
                    Utility.menu(); // print menu
                    choice = inputDevice.nextInt();
                }
                break;
            } catch (InputMismatchException ex) {
                inputDevice.nextLine();// to skip enter key
                System.out.println("Tyr again! Input choice must be integer value...");
                Utility.menu();
            }
        }
        inputDevice.close();
        System.out.println("\nThank you for using Palestinian Vehicle Agency...\n");

    }
}
