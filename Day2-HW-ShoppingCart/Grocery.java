public class Grocery extends Product {
    public Grocery(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount = 0.25;
    }

    @Override
    public String toString() {
        return "Grocery " + super.toString();
    }
}
