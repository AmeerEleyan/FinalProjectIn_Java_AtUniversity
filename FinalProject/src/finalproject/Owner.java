/*
 * @author Amir Eleyan
 * ID: 1191076
 */
package finalproject; //  the package name for project

import java.util.Calendar; // import class Calender from util package
import java.util.GregorianCalendar; // import class GregorianCalendar from util package

// Define the owner class with two constructors
public final class Owner {
    /** attributes */
    String
            // name of owner
            name ,
            // PIN of owner
            PIN ,
            // address of owner
            address,
            // mobile number of owner
             mobileNo ;

    Calendar dateOfBirth; // date of birth of owner

    /** Construct a owner with a default data filed */
    public Owner() {
        this("Ameer","125E","Rammallah","0598986107",new GregorianCalendar());
    }

    /** Construct a owner with a specified data filed */
    public Owner(String name, String PIN, String address, String mobileNo, Calendar dateOfBirth) {
        this.setName(name);
        this.setPIN(PIN);
        this.setAddress(address);
        this.setMobileNo(mobileNo);
        this.setDateOfBirth(dateOfBirth);
    }


   /** Return the name of this owner */
    public String getName() {
        return this.name;
    }

   /** Return the PIN of this owner */
    public String getPIN() { return this.PIN; }

    /** Return the address of this owner as string */
    public  String getAddress() { return this.address; }

    /** Return the mobile no of this owner as string */
    public String getMobileNo() { return this.mobileNo; }

   /** Return the date of birth as a format of Calender for this owner  */
    public Calendar getDateOfBirth() { return this.dateOfBirth; }

    /** Set a new name for this owner */
    public void setName(String name) {
        // Check the name if does not have any digit(just letters)
        if (!name.matches(".*\\d.*")) this.name = name;
        else  System.out.println("Error entering the name!");
    }

    /** Set a new PIN for this owner */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     * Set a new address for this owner
     */
    public void setAddress(String address) {
        // Check the address if does not have any digit(just letters)
        if (!address.matches(".*\\d.*")) this.address = address;
        else System.out.println("Error entering the Address!");
    }

    /**
     * Set a new mobile number for this owner
     */
    public void setMobileNo(String mobileNo) {
        // Check the mobile number if does not have any letters(just 10 digits)
        if (mobileNo.matches("\\d{10}")) this.mobileNo = mobileNo;
        else System.out.println("Error entering the phone number!");
    }

    /**
     * Set a new date of birth for this owner
     */
    public void setDateOfBirth(Calendar dateOfBirth) {
        // Current Date
        Calendar currentTime = new GregorianCalendar();

        // The date entered is greater than the current date
        if ((currentTime.get(Calendar.YEAR) < dateOfBirth.get(Calendar.YEAR)) ||
                ((currentTime.get(Calendar.YEAR) == dateOfBirth.get(Calendar.YEAR)) && (currentTime.get(Calendar.MONTH) < dateOfBirth.get(Calendar.MONTH)))
                || ((currentTime.get(Calendar.YEAR) == dateOfBirth.get(Calendar.YEAR)) && (currentTime.get(Calendar.MONTH) == dateOfBirth.get(Calendar.MONTH))
                && (currentTime.get(Calendar.DAY_OF_MONTH) < dateOfBirth.get(Calendar.DAY_OF_MONTH)))) {
            System.out.println("INPUT ERROR IN DATE OF BIRTH!");
        } else
            this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method that calculate the age of owner in years and months
     * and return age as double type of this owner.
     */
    public double getAge() {

        // Current Date
        Calendar currentTime = new GregorianCalendar();

        // Calculating  age in years
        int ageInYears = (currentTime.get(Calendar.YEAR) - this.dateOfBirth.get(Calendar.YEAR));

        /*
         * Note: when we invoke currentTime.get(Calendar.MONTH) we add one to it, because the month in class Calender
         * in the system start from index  zero, in order to accurately complete the calculation for the user,
         * so we should add one
         */

        // Calculating age in months
        int ageInMonths = ((currentTime.get(Calendar.MONTH) + 1) -
                ((this.dateOfBirth.get(Calendar.MONTH) == Calendar.DECEMBER) ? 12 : this.dateOfBirth.get(Calendar.MONTH) + 1));

        // The year of birth of the owner less than the current year but the current month larger than the month of birth
        if (ageInMonths < 0) {
            ageInMonths = 12 - (this.dateOfBirth.get(Calendar.MONTH) + 1) + (currentTime.get(Calendar.MONTH) + 1);
            ageInYears--;
            if (currentTime.get(Calendar.DAY_OF_MONTH) < this.dateOfBirth.get(Calendar.DAY_OF_MONTH)) ageInMonths--;

         /* The month of birth of the owner equals the current month and the current day of the month
          less than the day of the month of birt */
        }else if (ageInMonths == 0 && currentTime.get(Calendar.DAY_OF_MONTH) < this.dateOfBirth.get(Calendar.DAY_OF_MONTH)) {
            ageInYears--;
            ageInMonths = 11;
        }
        // i.e. 45.11 -> 45 is age in year and 11 age in month
        // i.e. 45.05 -> 45 is age in year and 5 age in month
        // i.e. 45.1 -> 45 is age in year and 10 age in month
        return (ageInYears + ageInMonths / 100.0);
    }


    /**
     * Return the info of this owner as String
     */
    @Override
    public String toString() {
        return ",Owner -> " + "Name: " + this.name +
                ", PIN: " + this.PIN + ", Address: " + this.address +
                ", MobileNo: " + this.mobileNo + ", DateOfBirth: " + (this.dateOfBirth.get(Calendar.MONTH) + 1) + '/' +
                +this.dateOfBirth.get(Calendar.DAY_OF_MONTH) + '/'
                + this.dateOfBirth.get(Calendar.YEAR)+ ", Age: "+this.getAge();
    }
}
