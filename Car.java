import java.util.ArrayList;

public class Car {

    



    /*
     *  - a private `ArrayList` where it will store the `Passenger`s currently onboard, and an `int` for the `Car`'s maximum capacity (since `ArrayList`s will expand as we add objects, we'll need to manually limit their size)
        - a constructor, which takes in an initial value for the `Car`'s maximum capacity and initializes an appropriately-sized `ArrayList`
        - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` that return the maximum capacity and remaining seats, respectively
        - methods `public void addPassenger(Passenger p)` and `public void removePassenger(Passenger p)` to add or remove a `Passenger` from the `Car` (_Hint: don't forget to check that there are seats available if someone wants to board, and to confirm that the `Passenger` is actually onboard before trying to remove them! If you encounter a problem, throw a `RuntimeException`._)
        - and a final method `public void printManifest()` that prints out a list of all `Passenger`s aboard the car (or "This car is EMPTY." if there is no one on board)
     */

     private ArrayList<Passenger> passenger;
     private int maxCapacity;


     public Car(int maxCapacity) {
        this.maxCapacity=maxCapacity;
        passenger=new ArrayList<>();
    }
     
    public int getCapacity() {
        return maxCapacity;
    }

    public int seatsRemaining() {
        return maxCapacity-passenger.size();
    }

    public void addPassenger(Passenger p) {
        if(passenger.size()>=maxCapacity) {
            throw new RuntimeException("Train is at capacity.");
        }
        passenger.add(p);
    }

    public void removePassenger(Passenger p) {
        if(!passenger.contains(p)) {
            throw new RuntimeException("Passenger is not on the train.");
        }
        passenger.remove(p);
    }

    public void printManifest() {
        if(passenger.size()==0) {
            System.out.println("This car is EMPTY.");
        }
        else{
            System.out.println("This train car contains: ");
            for(int i=0; i<passenger.size(); i++) {
                System.out.println("    " + passenger.get(i).getName());
            }
        }
    }


    public static void main(String[] args) {
        Car c = new Car(2);
        c.printManifest();
        Passenger p = new Passenger("P");
        Passenger q = new Passenger("Q");
        Passenger r = new Passenger("R");

        c.addPassenger(p);
        c.printManifest();
        c.addPassenger(q);
        c.printManifest();
        try {
            c.addPassenger(r);
            c.printManifest();
            
        } catch (Exception e) {
            System.out.println("Train is at capacity.");
        }


        c.removePassenger(p);
        c.printManifest();
        c.removePassenger(q);
        c.printManifest();
        try {
            c.removePassenger(r);
            c.printManifest();
        } catch (Exception e) {
            System.out.println("Passenger is not on train.");
        }
        
    }
}
