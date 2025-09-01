import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0.0;

        for (Product product : products) {
            total += product.discountPrice();
        }

        return total;
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
