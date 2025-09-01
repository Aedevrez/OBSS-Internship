public class UserInterface {
    private ShoppingCart shoppingCart;

    public UserInterface(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void run() {
        populateShoppingCart();
        shoppingCart.printProducts();
        System.out.println("Total (with discounts): " + shoppingCart.calculateTotalPrice());
    }

    public void populateShoppingCart() {
        shoppingCart.addProduct(new Electronics("Adaptör", 75));
        shoppingCart.addProduct(new Clothing("Gömlek", 130));
        shoppingCart.addProduct(new Grocery("Havuç", 15));
    }
}
