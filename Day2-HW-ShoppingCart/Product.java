public abstract class Product {
    public String name;
    protected double price;
    protected double discount;

    public double discountPrice() {
        return price * (1 - discount);
    }

    public String toString() {
        return "price: " + discountPrice();
    }
}
