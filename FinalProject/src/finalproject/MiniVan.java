/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject;

// Define the MiniVan class with two constructors
public final class MiniVan extends Vehicles {
    /**
     * Attributes
     */
    private int numberOfSeats = 7;
    private Boolean airConditionOn, hasAutoDoors = true;

    /**
     * Construct a MiniVan with a specified data filed
     */
    public MiniVan(String modelName, String modelNo, String brand, String engineType,
                   double tankSize, double fuelConsumption, Owner owner, int numberOfSeats,
                   Boolean airConditionOn, Boolean hasAutoDoors) {
        super(modelName, modelNo, brand, engineType, tankSize, fuelConsumption, owner);
        this.setNumberOfSeats(numberOfSeats);
        this.setHasAutoDoors(hasAutoDoors);
        this.setAirConditionOn_Off(airConditionOn);
    }

    /**
     * Construct a MiniVan with a default data filed
     */
    public MiniVan() {

    }

    /**
     * Return number of seats of this MiniVan
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Return the status of the air condition this car
     */
    public Boolean getAirConditionOn_OFF() {
        return this.airConditionOn;
    }

    /**
     * Return the status of the auto doors of this car
     */
    public Boolean getHasAutoDoors() {
        return this.hasAutoDoors;
    }

    /**
     * Set a new status air condition for this car
     */
    public void setAirConditionOn_Off(Boolean airConditionOn) {
        this.airConditionOn = airConditionOn;
    }

    /**
     * Set a new number of seats for this MiniVan
     */
    public void setNumberOfSeats(int numberOfSeats) {
        // Check number of seats if at least one seats
        if (numberOfSeats > 0) this.numberOfSeats = numberOfSeats;
        else System.out.println("Error entering the number of seats!");
    }

    /**
     * Set a new status for this car
     */
    public void setHasAutoDoors(Boolean hasAutoDoors) {
        this.hasAutoDoors = hasAutoDoors;
    }


    /**
     * Calculating cost for running 100Km with the engine type and the petroleum price
     */
    @Override
    public double costFor100Km() {
        try {
            return ((100.0 / this.getFuelConsumption()) *
                    ((this.getEngineType().equalsIgnoreCase("Gasoline")
                            || this.getEngineType().equalsIgnoreCase("hybrid")) ? PetroleumType.getGasolinePrice() : PetroleumType.getDieselPrice()));
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For MiniVan "+this.getModelNo());
            return 0.0;
        }
    }

    /**
     * Calculating cost for running 100Km with the engine type and the petroleum price
     */
    @Override
    public double costFor100Km(PetroleumType petroleumType) {
        try {
            return ((100.0 / this.getFuelConsumption()) *
                    ((this.getEngineType().equalsIgnoreCase("Gasoline")
                            || this.getEngineType().equalsIgnoreCase("hybrid")) ? petroleumType.getGasolinePrice() : petroleumType.getDieselPrice()));
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage()+", For MiniVan "+this.getModelNo());
            return 0.0;
        }
    }


    /**
     * Set air condition on for this minivan
     */
    @Override
    public void setAirConditionOn() {
        if (this.airConditionOn) {
            System.out.println("The air condition is On " + this.getModelName() + "(" + this.getModelNo() + ")");
        } else {
            this.airConditionOn = true; // set condition off
        }
    }

    /**
     * Set air condition off for this minivan
     */
    @Override
    public void setAirConditionOFF() {
        if (this.airConditionOn) {
            this.airConditionOn = false; // set condition off
        } else {
            System.out.println("The air condition is off " + this.getModelName() + "(" + this.getModelNo() + ")");
        }
    }

    /**
     * Return MiniVan and his/her owner info as string
     */
    @Override
    public String toString() {
        return super.toString() + ", Number of seats: " + this.numberOfSeats +
                ", Has auto doors: " + ((this.hasAutoDoors) ? "Yes" : "No") + " }";
    }
}
