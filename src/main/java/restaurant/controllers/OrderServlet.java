package restaurant.controllers;

import restaurant.model.MenuItem;
import restaurant.model.Order;
import restaurant.model.OrderStatus;
import restaurant.service.MenuService;
import restaurant.service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static restaurant.model.OrderStatus.IN_PROGRESS;


@WebServlet("/orders")
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orderList", OrderService.getAllOrders());
        req.setAttribute("menuItems", MenuService.getAllMenuItems());
        String userType = req.getParameter("userType");
        if (userType.equals("worker")){
            req.setAttribute("userType", "worker");
        }
        if (userType.equals("client")) {
            req.setAttribute("userType", "client");
        }
        req.getRequestDispatcher("orders.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String customerName = request.getParameter("customerName");
        String[] itemIds = request.getParameterValues("itemIds");
        String paymentMethod = request.getParameter("paymentMethod");
        List<MenuItem> selectedItems = new ArrayList<>();
        for (String itemIdStr : itemIds) {
            int itemId = Integer.parseInt(itemIdStr);
            selectedItems.add(MenuService.getMenuItemById(itemId));
        }
        Order order = new Order(OrderService.getNextOrderId(), customerName,selectedItems, IN_PROGRESS, paymentMethod);
        OrderService.placeOrder(order);
        request.setAttribute("userType", "client");
        request.setAttribute("orderList", OrderService.getAllOrders());
        request.getRequestDispatcher("orders.jsp").forward(request, response);

    }

}