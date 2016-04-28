package droidahmed.com.fawaz.model;

/**
 * Created by ahmed on 4/4/2016.
 */
public class InputProductToCart {
    private int Product;
    private int Quantity;

    public InputProductToCart() {
    }

    public InputProductToCart(int product, int quantity) {
        Product = product;
        Quantity = quantity;
    }

    public int getProduct() {
        return Product;
    }

    public void setProduct(int product) {
        Product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

}
