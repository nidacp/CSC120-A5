import java.util.ArrayList;

public class Train {

    /*
     * -  a private `Engine` attribute, which we will mark with the keyword `final` to establish the **composition** relationship (e.g. `private final Engine engine;`)
 -  a private `ArrayList` to keep track of the `Car`s currently attached
 -  a constructor `public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity)` which will initialize the `Engine` and `Car`s and store them
 -  a couple of accessors: 
     -  `public Engine getEngine()`
     -  `public Car getCar(int i)` to return the `i`th car
     -  `public int getMaxCapacity()` which will return the maximum total capacity across all `Car`s
     -  `public int seatsRemaining()` which will return the number of remaining open seats across all `Car`s
- and finally, its own `public void printManifest()` that prints a roster of all `Passenger`s onboard (_Hint: your `Car`s can help!_)

     */

    private final Engine eng;
    private ArrayList<Car> cars;
    
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.eng= new Engine(fuelType, fuelCapacity);
        cars= new ArrayList<>();
        for(int i=0; i<nCars; i++) {
            Car c = new Car(passengerCapacity);
            cars.add(c);
        }
    }

    public Engine getEngine() {
        return this.eng;
    }

    public Car getCar(int i) {
        if(i>=cars.size() || i<0) {
            throw new IndexOutOfBoundsException("Trying to access an index outside of the car arraylist size.");
        }
        return(cars.get(i));
    }

    public int getMaxCapacity() {
        int totMax=0;
        for(int i=0; i<cars.size(); i++) {
            totMax+=cars.get(i).getCapacity();
        }
        return totMax;
    }

    public int seatsRemaining() {
        int seats=0;
        for(int i=0; i<cars.size(); i++) {
            seats+=cars.get(i).seatsRemaining();
        }
        return seats;
    }

    public void printManifest() {
        for(int i=0; i<cars.size(); i++) {
            System.out.println("Car number " + i + "'s manifest:");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        Train t = new Train(FuelType.STEAM, 100.,  5, 10);
        System.out.println("Max capacity: " + t.getMaxCapacity());
        System.out.println("Seats remaining: " + t.seatsRemaining());
        System.out.println("Engine: " + t.getEngine());
        try {
            System.out.println("Car 0: " + t.getCar(0));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Could not reach car 0.");
        }
        try {
            System.out.println("Car -1: " + t.getCar(-1));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Could not reach car -1.");
        }
        try {
            System.out.println("Car 4: " + t.getCar(t.cars.size()-1));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Could not reach car 4.");
        }
        try {
            System.out.println("Car 5: " + t.getCar(t.cars.size()));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Could not reach car 5.");
        }
     
        Passenger p = new Passenger("P");
        Passenger q = new Passenger("Q");
        Passenger r = new Passenger("R");
        t.getCar(0).addPassenger(p);
        q.boardCar(t.getCar(1));
        r.boardCar(t.getCar(2));
        

        System.out.println("");
        System.out.println("Full manifest: ");
        t.printManifest();
    }


}
