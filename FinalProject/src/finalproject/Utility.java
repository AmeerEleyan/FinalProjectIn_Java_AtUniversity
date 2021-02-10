/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Define a class utility */
public final class Utility {
    /**
     * Attributes. array list to store vehicles in it is
     */
    private static ArrayList<Vehicles> vehiclesArrayList = new ArrayList<>();
    private static Scanner input;

    /* To prevent user to create obj form this class */
    private Utility() {

    }

    /* Create a menu that allow user to select from them as the following: */
    public static void menu() {
        System.out.println("\n1. Read the data about objects from the file “inputdata.txt”");
        System.out.println("2. Set prices of petroleum.");
        System.out.println("3. Print sorted order Vehicles in an ascending order based on costFor100Km.");
        System.out.println("4. Print sorted order Vehicles in an ascending order based on owner name.");
        System.out.println("5. Print sorted order Vehicles in an descending order based on vehicle brand.");
        System.out.println("6. Clone Vehicle without owner.");
        System.out.println("7. Turn air-condition on");
        System.out.println("8. Turn air-condition off");
        System.out.println("9. Write Output on the “output.txt” file after sort them.");
        System.out.println("10. Exit from System");
        System.out.print("Select on of them: ");
    }

    /* Reading data from file and store it in ArrayList */
    public static void readDataFromFile() {
        /* constructor of File class having file as argument */
        File dataFile = new File("inputdata.txt");
        try {
            /* file to be scanned */
            input = new Scanner(dataFile);

            /* If no data in file */
            if (dataFile.length() == 0) {
                System.out.println("No data in file");
            } else {
                vehiclesArrayList = new ArrayList<>(); // crating instance of arrayList

                StringBuilder stringBuilder; // instance of string builder to store line of data

                String[] wordsInLine; // array to store words after split

                Car car; // instance of car

                MiniVan miniVan; // instance of miniVan

                Truck truck; // instance of truck

                Owner ownerOfVehicles; // instance of owner

                System.out.println("\nUploading Data File ...\n");

                /* returns true if and only if scanner has another token */
                while (input.hasNext()) {
                    /* reading the data line from inputdata.txt and store in stringBuilder */
                    stringBuilder = new StringBuilder(input.nextLine());

                    /* Splitting the line based on the comma */
                    wordsInLine = stringBuilder.toString().split(",");

                    /* Removing whitespace characters trimmed on both sides in wordsInLine array */
                    trimString(wordsInLine);

                    /* The vehicle is a car */
                    if (wordsInLine[0].equalsIgnoreCase("Car")) {
                        try {
                            /* creating an instance of the owner */
                            ownerOfVehicles = new Owner();

                            /* setting the owner name */
                            ownerOfVehicles.setName(wordsInLine[4]);

                            /* Creating an instance of car based the data in the line */
                            car = new Car(wordsInLine[1], wordsInLine[2], wordsInLine[3], wordsInLine[5],
                                    Double.parseDouble(wordsInLine[6]), Double.parseDouble(wordsInLine[7]), ownerOfVehicles,
                                    Integer.parseInt(wordsInLine[8]), false);

                            /* adding this instance to the ArrayList */
                            vehiclesArrayList.add(car);

                        } /* Exception at creating the instance or data mismatch */
                        catch (Exception ex) {
                            System.out.println("Error reading vehicle attributes from file!" + ex.getMessage());
                        }

                    } /* The vehicle is a MiniVan */
                    else if (wordsInLine[0].equalsIgnoreCase("MiniVan")) {
                        try {
                            /* creating an instance of the owner */
                            ownerOfVehicles = new Owner();

                            /* setting the owner name */
                            ownerOfVehicles.setName(wordsInLine[4]);
                            /* Creating an instance of minivan based the data in the line */

                            miniVan = new MiniVan(wordsInLine[1], wordsInLine[2], wordsInLine[3], wordsInLine[5],
                                    Double.parseDouble(wordsInLine[6]), Double.parseDouble(wordsInLine[7]), ownerOfVehicles,
                                    Integer.parseInt(wordsInLine[8]), false, Boolean.parseBoolean(wordsInLine[9]));
                            /* adding this instance to the ArrayList */
                            vehiclesArrayList.add(miniVan);

                        } /* Exception at creating the instance or data mismatch */
                        catch (Exception ex) {
                            System.out.println("Error reading vehicle attributes from file!" + ex.getMessage());
                        }

                    } /* The vehicle is a Truck */
                    else if (wordsInLine[0].equalsIgnoreCase("Truck")) {
                        try {
                            /* creating an instance of the owner */
                            ownerOfVehicles = new Owner();

                            /* setting the owner name */
                            ownerOfVehicles.setName(wordsInLine[4]);
                            /* Creating an instance of truck based the data in the line */

                            truck = new Truck(wordsInLine[1], wordsInLine[2], wordsInLine[3], wordsInLine[5],
                                    Double.parseDouble(wordsInLine[6]), Double.parseDouble(wordsInLine[7]), ownerOfVehicles,
                                    Integer.parseInt(wordsInLine[8]), Integer.parseInt(wordsInLine[9]), false);
                            /* adding this instance to the ArrayList */
                            vehiclesArrayList.add(truck);

                        }/* Exception at creating the instance or data mismatch */
                        catch (Exception ex) {
                            System.out.println("Error reading vehicle attributes from file!" + ex.getMessage());
                        }
                    } // Input error
                    else {
                        System.out.println("There was an error reading the file or car is not to the Palestinian Vehicle Agency");
                    }
                }
                input.close(); // close scanner
                System.out.println("\nData File uploaded");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Print vehicles info
     */
    public static void printData() {
        /* There are no vehicles in arrayList */
        if (vehiclesArrayList.size() != 0) {
            System.out.print("\n");
            /* number of vehicle */
            int numberOfObj = 1;
            /* for each to print data */
            for (Vehicles vehicles : vehiclesArrayList) {
                System.out.println(numberOfObj + ". " + vehicles.toString());
                numberOfObj++; /* increment number of vehicle */
                /* Delay in print */
                try {Thread.sleep(250); } catch (InterruptedException ex) {System.out.println(ex.getMessage());}
            }
        } else {
            System.out.println("There are no data in the file!");
        }
    }

    public static void setPetroleumPrice() {

        /* instance of scanner to read from user */
        input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the price of Gasoline in-unit Nis/litre(double value): ");
                PetroleumType.setGasolinePrice(input.nextDouble()); /* set a new price for gasoline */
                break;
            } catch (InputMismatchException e) {
                System.out.println("Try again. (" + "Incorrect input: an double is required)");
                input.nextLine(); // to skip enter key
            }
        }
        while (true) {
            try {
                System.out.print("Enter the price of Diesel in-unit Nis/litre(double value): ");
                PetroleumType.setDieselPrice(input.nextDouble()); /* set a new price for diesel */
                break;
            } catch (InputMismatchException e) {
                System.out.println("Try again. (" + "Incorrect input: an double is required)");
                input.nextLine(); /* to skip enter key */
            }
        }
        input.close();
        System.out.println("\nDone. A new price has been set for both Gasoline and Diesel...");
    }

    /** Sort vehicles by user request */
    public static void sortVehicles(int x) {
        /* there are no vehicles */
        if (vehiclesArrayList.size() == 0) {
            System.out.println("There are no data to sort it");
        } else {
            Vehicles.setWhichSort(x); // sort vehicles
            Collections.sort(vehiclesArrayList);
            printData();
        }
    }

    /** Cloning new vehicle from old vehicle and it to arrayList*/
    public static void cloneVehicle() {
        /* There are no vehicles in arrayList */
        if (Utility.vehiclesArrayList.size() == 0) {
            System.out.println("There are no vehicles to cloning");
        } else {
            /* Which vehicle */
            int n;
            input = new Scanner(System.in);
            while (true) {
                try {
                    printData(); /* print arrayList */
                    System.out.print("Enter the number of vehicles for cloning and add to list: ");
                    n = input.nextInt(); /* read which vehicle from user */
                    vehiclesArrayList.add((Vehicles) (vehiclesArrayList.get(n - 1)).clone()); /* add new vehicle to arrayList */
                    break;
                } catch (InputMismatchException ex) {
                    input.nextLine(); /* skip enter key */
                    System.out.println("Tyr again! Input choice must be integer value...");
                }catch (IndexOutOfBoundsException ex){
                    input.nextLine();/* skip enter key */
                    System.out.println("Try again! This vehicles does not exist");
                }catch (CloneNotSupportedException ex){
                    System.out.println(ex.getMessage());
                }
            }
            input.close();
            System.out.println("\nDone.");
        }
    }

    /** Turn condition on for all vehicles */
    public static void turnConditionsOnForAllVehicles() {
        /* There are no vehicles in arrayList */
        if (Utility.vehiclesArrayList.size() == 0) {
            System.out.println("There are no vehicles to turn on their air conditioners");
        } else {
            for (Vehicles vehicles : vehiclesArrayList) {
                vehicles.setAirConditionOn(); /* set condition on for this vehicle */
            }
            System.out.println("\nDone");
        }
    }

    /** Turn condition on for all vehicles */
    public static void turnConditionsOffForAllVehicles() {
        /* There are no vehicles in arrayList */
        if (Utility.vehiclesArrayList.size() == 0) {
            System.out.println("There are no vehicles to turn off their air conditioners");
        } else {
            for (Vehicles vehicles : vehiclesArrayList) {
                vehicles.setAirConditionOFF(); /* set condition off for this vehicle */
            }
            System.out.println("\nDone");
        }
    }

    /** Writing data from arrayList to file */
    public static void writeDataInFile() {
        /* There are no vehicles in arrayList */
        if (Utility.vehiclesArrayList.size() == 0) {
            System.out.println("There is are data to print it in file output.txt ");
        } else {
            File file;
            PrintWriter printData;
            try {
                /* constructor of File class having file as argument */
                file = new File("output.txt");
                /* file to writing data */
                printData = new PrintWriter(file);
                System.out.println("\nUpdating Data File ...\n");

                /* Print arrayList to the file */
                for (Vehicles vehicles : vehiclesArrayList) {
                    printData.println(vehicles.toString());
                }
                printData.close(); // close file
                System.out.println("Data File update");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /* Returns a new string with whitespace characters trimmed on both sides */
    private static void trimString(String[] strings) {
        for (int i = 0; i < strings.length; ++i) {
            strings[i] = strings[i].trim();
        }
    }
}
