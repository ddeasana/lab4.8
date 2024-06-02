package restaurant.model;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private int id;
    private String customerName;
    private List<MenuItem> items;
    private OrderStatus status;
    private String paymentMethod;

    public Order(int id, String customerName, List<MenuItem> items, OrderStatus status, String paymentMethod) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerName;
    }

    public void setCustomerName(String customerId) {
        this.customerName = customerName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getItemsAsString() {
        return items.stream()
                .map(MenuItem::getName)
                .collect(Collectors.joining(", "));
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
