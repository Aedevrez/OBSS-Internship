import java.util.Arrays;

public class Bus {
    private Passenger[] passengers;
    private Destination destination;
    
    public Bus(int capacity, Destination destination) {
        this.destination = destination;
        this.passengers = new Passenger[capacity];
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public void insertPassanger(Passenger passenger) {
        if (passenger.getDestination().equals(this.destination)) {
            for (int i = 0; i < passengers.length; i++) {
                if (passengers[i] == null) {
                    passengers[i] = passenger;
                    return;
                }
            }
            System.out.println("Bus is full!");
        } else {
            System.out.println("Different destinations!");
        }
        
    }

    @Override
    public String toString() {
        return "Bus passengers=" + Arrays.toString(passengers) + "";
    }
}
