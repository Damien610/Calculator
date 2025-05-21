package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setup() {
        cart = new ShoppingCart();
    }

    @Test
    public void testEmptyCartCreation() {
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    public void testAddProduct() {
        Product p = new Product("Banana", 1.5);
        cart.addProduct(p);
        assertEquals(1, cart.getItemCount());
        assertEquals(1.5, cart.getTotalPrice());
    }

    @Test
    public void testAddMultipleProducts() {
        cart.addProduct(new Product("Apple", 1.0));
        cart.addProduct(new Product("Orange", 2.0));
        assertEquals(2, cart.getItemCount());
        assertEquals(3.0, cart.getTotalPrice());
    }

    @Test
    public void testAddNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));
    }

    @Test
    public void testProductWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Buggy", -10.0));
    }

    @Test
    public void testClearCart() {
        cart.addProduct(new Product("Milk", 2.5));
        cart.addProduct(new Product("Bread", 1.5));
        cart.clearCart();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice());
    }
}
