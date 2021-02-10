/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject; //  the package name for project

// Define the Vehicles class with two constructors and implement two interfaces
public abstract class Vehicles implements Cloneable, Comparable<Vehicles> {

    /**
     * Attributes
     */
    protected String
            // model name of vehicle
            modelName,
            // model number of vehicle
            modelNo,
            // brand name of vehicle
            brand,
            // engine type of vehicle
            engineType;

    protected double
            // tank size of vehicle
            tankSize,
            // fuel consumption of vehicle
            fuelConsumption;
    public Owner
            // owner of vehicle
            owner = new Owner();

    // Number of vehicles
    public static int numberOfVehicles = 0;
    // type of sort by user request
    private static int whichSort = 3;

    /**
     * Construct a vehicles with a default data filed
     */
    public Vehicles() {
        this("Camley", "E100", "Toyota", "Gasoline", 70.0D, 15.15D, new Owner());
        Vehicles.numberOfVehicles++; // increment number of vehicles one
    }

    /**
     * Construct a vehicles with a specified data filed
     */
    public Vehicles(String modelName, String modelNo, String brand, String engineType,
                    double tankSize, double fuelConsumption, Owner owner) {
        this.setModelName(modelName);
        this.setModelNo(modelNo);
        this.setBrand(brand);
        this.setEngineType(engineType);
        this.setTankSize(tankSize);
        this.setFuelConsumption(fuelConsumption);
        this.setOwner(owner);
        Vehicles.numberOfVehicles++;
    }

    /**
     * Return the number of vehicles
     */
    public static int getNumberOfVehicles() {
        return Vehicles.numberOfVehicles;
    }

    /**
     * Return the model name of this vehicles
     */
    public String getModelName() {
        return this.modelName;
    }

    /**
     * Return the model number of this vehicles
     */
    public String getModelNo() {
        return this.modelNo;
    }

    /**
     * Return the brand name of this vehicles
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Return the engine type name of this vehicles
     */
    public String getEngineType() {
        return this.engineType;
    }

    /**
     * Return the tank size of this vehicles
     */
    public double getTankSize() {
        return this.tankSize;
    }

    /**
     * Return the fuel consumption of this vehicles
     */
    public double getFuelConsumption() {
        // vehicle is a car
        if (this instanceof Car) {
            //Fuel consumption of the Car increased by 20% when air-condition of the Car is ON.
            if (((Car) this).getAirConditionOn_OFF()) {
                return ((this.fuelConsumption * 0.1D + this.fuelConsumption));
            } else {
                return this.fuelConsumption;
            }
        }// vehicle is a minivan
        else if (this instanceof MiniVan) {
            //Fuel consumption of the Minivan increased by 20% when air-condition of the MiniVan is ON.
            if (((MiniVan) this).getAirConditionOn_OFF()) {
                return ((this.fuelConsumption * 0.2D + this.fuelConsumption));
            } else {
                return this.fuelConsumption;
            }

        }// vehicle is a truck
        else {
            //Fuel consumption of the Truck increased by 20% when air-condition of the Truck is ON.
            if (((Truck) this).getAirConditionOn_OFF()) {
                return ((this.fuelConsumption * 0.2D + this.fuelConsumption));
            } else {
                return this.fuelConsumption;
            }

        }
    }

    /**
     * Return the owner of this vehicles
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Return the owner info of this vehicles
     */
    public String getOwnerInfo() {
        return this.owner.toString();
    }

    /**
     * Set a new model name for this vehicles
     */
    public void setModelName(String modelName) {
        // Check the model name if does not have any digit(just letters)
        if (!modelName.matches(".*\\d.*")) this.modelName = modelName;
        else System.out.println("Error entering the model name in vehicle " + this.modelNo);
    }

    /**
     * Set a new model number for this vehicles
     */
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
        //else System.out.println("Error entering the model number in vehicle " + this.modelName);
    }

    /**
     * Set a new brand name for this vehicles
     */
    public void setBrand(String brand) {
        // Check the brand if does not have any digit(just letters)
        if (!brand.matches(".*\\d.*")) this.brand = brand;
        else
            System.out.println("Error entering the brand name in vehicle " + this.modelName + "(" + this.modelNo + ")");
    }

    /**
     * Set a new engine type for this vehicles
     */
    public void setEngineType(String engineType) {
        // remove whitespace characters trimmed on both sides
        engineType = engineType.trim();
        // engine type must be gasoline or diesel
        if (engineType.equalsIgnoreCase("gasoline") || engineType.equalsIgnoreCase("diesel") ||
                engineType.equalsIgnoreCase("hybrid")) {
            // Check the vehicles if it is a car and uses engine type of Gasoline
            if (this instanceof Car) {
                if (engineType.equalsIgnoreCase("Gasoline")) {
                    this.engineType = engineType;
                } else {
                    System.out.println("The Car " + this.modelName + "(" + this.modelNo + ")" + ", uses only Gasoline engine..." + ", So the engine type will be set as Gasoline");
                    this.engineType = "Gasoline"; // set engine type gasoline
                }
            }
            // Check the vehicles if it is a Truck and uses engine type of Diesel
            else if (this instanceof Truck) {
                if (engineType.equalsIgnoreCase("Diesel")) this.engineType = engineType;
                else {
                    System.out.println("The Truck " + this.modelName + "(" + this.modelNo + ")" + ", uses only Diesel engine..." + ", So the engine type will be set as Diesel");
                    this.engineType = "Diesel"; // set engine type diesel
                }
            } else {
                // Check the vehicles if it is a MiniVan and uses engine type one of them(diesel or gasoline)  or both
                if (engineType.equalsIgnoreCase("Gasoline") || engineType.equalsIgnoreCase("Diesel")
                        || this.getEngineType().equalsIgnoreCase("hybrid")) {
                    this.engineType = engineType; // set engine type gasoline or gasoline
                } else {
                    System.out.println("The MiniVan " + this.modelName + "(" + this.modelNo + ")" + ", uses engine of Diesel or Gasoline" + ", So he will assume the engine type is Diesel");
                    this.engineType = "Diesel"; // suppose engine type gasoline
                }
            }
        } else System.out.println("Error entering the engine type for " + this.modelName + "(" + this.modelNo + ")");

    }


    /**
     * Set a new tank size for this vehicles
     */
    public void setTankSize(double tankSize) {
        // Check the value if it is negative
        if (tankSize >= 0) this.tankSize = tankSize;
        else
            System.out.println("Error entering the tank size in vehicle " + this.modelName + "(" + this.modelNo + ")");
    }

    /**
     * Set a new fuel consumption for this vehicles
     */
    public void setFuelConsumption(double fuelConsumption) {
        // Check the value if it is negative
        if (fuelConsumption > 0) this.fuelConsumption = fuelConsumption;
        else
            System.out.println("Error entering the fuel consumption in vehicle " + this.modelName + "(" + this.modelNo + ")");
    }

    /**
     * Set a new Owner for this vehicles
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{ Model name: " + this.modelName +
                ", Model No: " + this.modelNo + ", Brand: " + this.brand +
                ", Engine Type: " + this.engineType + ", Owner: " + ((this.getOwner() == null) ? "There is no owner(Null)" : this.getOwner().getName()) + ", Tank Size: " + this.tankSize + " liters" +
                ", Fuel Consumption: " + String.format("%.2f", this.getFuelConsumption()) + " Km/liter" +
                ", Movable distance: " + String.format("%.2f", this.movableDistance()) + " Km" + ", Cost for 100Km: " + String.format("%.2f", this.costFor100Km()) + " NIS";
    }

    /**
     * Calculating cost for running 100Kms with the engine type and the petroleum type
     */
    public abstract double costFor100Km();

    public abstract double costFor100Km(PetroleumType petroleumType);

    /**
     * Getting information of movable distance of a vehicle when the tank of the vehicle is filled fully
     */
    public double movableDistance() {
        if (this.tankSize != 0) {
            return (this.getFuelConsumption() * this.tankSize);
        } else {
            System.out.print("The tank is empty ");
            return 0.0;
        }
    }

    /**
     * Set air condition on
     */
    public abstract void setAirConditionOn();

    /**
     * Set air condition off
     */
    public abstract void setAirConditionOFF();

    /**
     * Clone an instance of Vehicle object, without cloning the
     * owner of this Vehicle and set the owner to null for cloned object by using deep cloning
     */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            // Assign the shallow copy to new reference variable vehicles
            Vehicles vehicles = (Vehicles) super.clone();

            /* deep copy */
            vehicles.setOwner(null);
            return vehicles; // return new vehicle

        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    // set type of type of sort by user request
    public static void setWhichSort(int x) {
        Vehicles.whichSort = x;
    }

    // Sort vehicles  by user request
    @Override
    public int compareTo(Vehicles o) {
        switch (whichSort) {
            case 3:
                // sort by cost for 100 km for vehicle
                return ((this.costFor100Km() > o.costFor100Km()) ? 1 : (this.costFor100Km() < o.costFor100Km()) ? -1 : 0);
            case 4:
                // sort by owner name
                return ((this.getOwner().getName()).compareTo(o.getOwner().getName()));
        }
        // sort by vehicle brand
        return ((this.brand).compareTo(o.brand));
    }
}
