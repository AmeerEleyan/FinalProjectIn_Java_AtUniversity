/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject;

// Define the Truck class with two constructors
public final class Truck extends Vehicles {
    /**
     * Attributes
     */
    private int numberOfSeats = 4, power = 520;
    private Boolean airConditionOn ;

    /**
     * Construct a Truck with a specified data filed
     */
    public Truck(String modelName, String modelNo, String brand, String engineType,
                 double tankSize, double fuelConsumption, Owner owner, int numberOfSeats,
                 int power, Boolean airConditionOn) {
        super(modelName, modelNo, brand, engineType, tankSize, fuelConsumption, owner);
        this.setNumberOfSeats(numberOfSeats);
        this.setPower(power);
        this.setAirConditionOn_Off(airConditionOn);
    }

    /**
     * Construct a Truck with a default data filed
     */
    public Truck() {

    }


    /**
     * Return number of seats of this Truck
     */
    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    /**
     * Return the power of this Truck
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Return the status of the air condition this car
     */
    public Boolean getAirConditionOn_OFF() {
        return this.airConditionOn;
    }


    /**
     * Set a new status air condition for this car
     */
    public void setAirConditionOn_Off(Boolean airConditionOn){
        this.airConditionOn = airConditionOn;
    }

    /**
     * Set a new number of seats for this Truck
     */
    public void setNumberOfSeats(int numberOfSeats) {
        // Check number of seats if at least one seats
        if (numberOfSeats > 0) this.numberOfSeats = numberOfSeats;
        else System.out.println("Error entering the number of seats!");
    }

    /**
     * Set a new power of a truck engine for this truck
     */
    public void setPower(int power) {
        // Check power of a truck if larger than 100 horse
        if (power >= 100) this.power = power;
        else System.out.println("Error entering the power of a truck engine!");
    }


    /**
     * Calculating cost for running 100Km based on the engine type and the petroleum price
     */
    @Override
    public double costFor100Km() {
        try {
            return ((100.0 / this.getFuelConsumption()) * PetroleumType.getDieselPrice());
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For Truck "+this.getModelNo());
            return 0.0;
        }
    }

    /**
     * Calculating cost for running 100Km based on the engine type and the petroleum price
     */
    @Override
    public double costFor100Km(PetroleumType petroleumType) {
        try {
            return ((100.0 / this.getFuelConsumption()) * petroleumType.getDieselPrice());
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For Truck "+this.getModelNo());
            return 0.0;
        }
    }

    /**
     * Set air condition on for this truck
     */
    @Override
    public void setAirConditionOn() {
        if (this.airConditionOn) {
            System.out.println("The air condition is On " + this.getModelName() + "(" + this.getModelNo() + ")");
        } else {
            this.airConditionOn = true; // set condition on
        }
    }

    /**
     * Set air condition off for this truck
     */
    @Override
    public void setAirConditionOFF() {
        if (this.airConditionOn) {
            this.airConditionOn = false; // Set condition off
        } else {
            System.out.println("The air condition is off " + this.getModelName() + "(" + this.getModelNo() + ")");
        }
    }

    /**
     * Return Truck and his/her owner info as string
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of seats: " + this.numberOfSeats +
                ", Power: " + this.power + " Horse" + " }";
    }
}
