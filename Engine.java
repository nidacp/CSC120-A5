public class Engine {

    /*
     * - a private `FuelType` attribute to indicate what type of fuel it uses, and `double`s to store the current and maximum fuel levels (along with an appropriate accessors for each)
       - a constructor, which takes in initial values for the attributes named above and sets them appropriately
       - a method `public void refuel()` which will reset the `Engine`'s current fuel level to the maximum
       - a method `public void go()` which will decrease the current fuel level and print some useful information (e.g. remaining fuel level) provided the fuel level is above 0 (otherwise it should throw a `RuntimeException` containing an informative message)
 
     */
    private FuelType fuel;
    private double fuelNow;
    private double fuelMax;

    public Engine(FuelType fuel, double fuelMax) {
        this.fuel=fuel;
        this.fuelMax=fuelMax;
        this.fuelNow=fuelMax;
    }

    public void refuel() {
        this.fuelNow=this.fuelMax;
    }

    public void go() {
        if(fuelNow<=0) {
            throw new RuntimeException("Fuel level is too low to go anywhere. Refuel before trying again.");
        }
        fuelNow=fuelNow/10;
        System.out.println("Half the fuel has been used up. Current fuel level is" + fuelNow);
    }

    public double getFuelNow() {
        return this.fuelNow;
    }

    public double getFuelMax() {
        return this.fuelMax;
    }

    public FuelType getFuel() {
        return this.fuel;
    }



    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }

}
