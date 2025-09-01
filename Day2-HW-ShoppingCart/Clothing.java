public class Clothing extends Product {
    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount = 0.1;
    }

    @Override
    public String toString() {
        return "Clothing " + super.toString();
    }

}
