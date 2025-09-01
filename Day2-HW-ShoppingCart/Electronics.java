public class Electronics extends Product {
    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount = 0.15;
    }

    @Override
    public String toString() {
        return "Electronics " + super.toString();
    }
}
