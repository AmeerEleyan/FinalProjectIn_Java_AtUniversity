/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject; //  the package name for project

// Define the Petroleum class with two constructors
public final class PetroleumType  {

    /** Attributes */
    public static final int DIESEl = 1, GASOLINE = 2;
    private static double gasolinePrice = 6.5D, dieselPrice = 4.5D;

    /** Construct a petroleum with a default data price */
    public PetroleumType() {
        this(5.23,4.02);

    }
    /** Construct a petroleum with a specified price */
    public PetroleumType(double gasolinePrice, double dieselPrice) {
        PetroleumType.dieselPrice = gasolinePrice;
        PetroleumType.gasolinePrice = dieselPrice;
    }

    /**  Return the constant of the Diesel */
    public static int getDIESEl() {
        return PetroleumType.DIESEl;
    }

    /**  Return the constant of the Gasoline  */
    public static int getGASOLINE() {
        return PetroleumType.GASOLINE;
    }

    /**  Return the price of the Gasoline  */
    public static double getGasolinePrice() {
        return PetroleumType.gasolinePrice;
    }

    /**  Return the price of the Diesel  */
    public static double getDieselPrice() {
        return PetroleumType.dieselPrice;
    }

    /**  set a new price for Gasoline  */
    public static void setGasolinePrice(double gasolinePrice) {
        if(gasolinePrice<0) System.out.println("Error entering the gasoline price!");
        else PetroleumType.gasolinePrice = gasolinePrice;
    }

    /**  set a new price for Diesel  */
    public static void setDieselPrice(double dieselPrice) {
        if(dieselPrice<0) System.out.println("Error entering the gasoline price!");
        else PetroleumType.dieselPrice = dieselPrice;
    }

}
