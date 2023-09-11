package Abstraction.StoresExample;

public class Order {
    protected int quantity;
    protected Product product;

    public Order(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
