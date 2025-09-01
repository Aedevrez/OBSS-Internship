public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(3, Destination.ANKARA);
        Passenger validPassenger = new Passenger("Adem", Destination.ANKARA);
        Passenger invalidPassenger = new Passenger("Efe", Destination.ADANA);

        bus.insertPassanger(validPassenger);
        System.out.println(bus);

        bus.insertPassanger(validPassenger);
        System.out.println(bus);

        bus.insertPassanger(invalidPassenger);
        System.out.println(bus);

        bus.insertPassanger(validPassenger);
        System.out.println(bus);

        bus.insertPassanger(validPassenger);
        System.out.println(bus);
    }
}
