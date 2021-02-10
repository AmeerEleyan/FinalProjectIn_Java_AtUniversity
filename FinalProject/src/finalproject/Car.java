/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject;

// Define the Car class with two constructors
public final class Car extends Vehicles {
    /**
     * Attributes
     */
    private int numberOfSeats = 5;
    private Boolean airConditionOn;

    /**
     * Construct a car with a specified data filed
     */
    public Car(String modelName, String modelNo, String brand, String engineType,
               double tankSize, double fuelConsumption, Owner owner, int numberOfSeats,
               Boolean airConditionOn) {
        super(modelName, modelNo, brand, engineType, tankSize, fuelConsumption, owner);
        this.setNumberOfSeats(numberOfSeats);
        this.setAirConditionOn_Off(airConditionOn);
        this.setAirConditionOn_Off(airConditionOn);
    }

    /**
     * Construct a Car with a default data filed
     */
    public Car() {

    }

    /**
     * Return number of seats of this car
     */
    public int getNumberOfSeats() {
        return this.numberOfSeats;
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
    public void setAirConditionOn_Off(Boolean airConditionOn) {
        this.airConditionOn = airConditionOn;
    }

    /**
     * Set a new number of seats for this car
     */
    public void setNumberOfSeats(int numberOfSeats) {
        // Check number of seats if at least one seats
        if (numberOfSeats > 0) this.numberOfSeats = numberOfSeats;
        else
            System.out.println("Error entering the number of seats in car " + this.getModelName() + "(" + this.getModelNo() + ")");
    }

    /**
     * Calculating cost for running 100Km with the engine type and the petroleum price
     */
    @Override
    public double costFor100Km() {
        try {
            return ((100.0 / this.getFuelConsumption()) * PetroleumType.getGasolinePrice());
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For car "+this.getModelNo());
            return 0.0;
        }
    }

    /**
     * Calculating cost for running 100Km with the engine type and the petroleum price
     */
    @Override
    public double costFor100Km(PetroleumType petroleumType) {
        try {
            return ((100.0 / this.getFuelConsumption()) * petroleumType.getGasolinePrice());
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For car "+this.getModelNo());
            return 0.0;
        }
    }

    /**
     * Set air condition on for this car
     */
    @Override
    public void setAirConditionOn() {
        if (this.airConditionOn) {
            System.out.println("The air condition is On " + this.getModelName() + "(" + this.getModelNo() + ")");
        } else {
            this.airConditionOn = true; // set the condition on
        }
    }

    /**
     * Set air condition off for this car
     */
    @Override
    public void setAirConditionOFF() {
        if (this.airConditionOn) {
            this.airConditionOn = false; // set the condition off
        } else {
            System.out.println("The air condition is off " + this.getModelName() + "(" + this.getModelNo() + ")");
        }
    }

    /**
     * Return Car and his/her owner info as string
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of seats: " + this.numberOfSeats + " }";
    }
}
