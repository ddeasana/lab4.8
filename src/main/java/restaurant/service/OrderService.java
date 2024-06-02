package restaurant.service;

import restaurant.model.Order;
import restaurant.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static List<Order> orderList = new ArrayList<>();
    private static int nextOrderId = 0;

    public static int getNextOrderId() {
        return nextOrderId;
    }

    public static void placeOrder(Order order) {

        orderList.add(order);
        nextOrderId++;
    }

    public static List<Order> getAllOrders() {
        return orderList;
    }

    public static void updateOrderStatus(int orderId, OrderStatus status) {
        for (Order order : orderList) {
            if (order.getId() == orderId) {
                order.setStatus(status);
                break;
            }
        }
    }
}