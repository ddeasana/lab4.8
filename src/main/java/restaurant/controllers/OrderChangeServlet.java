package restaurant.controllers;

import restaurant.service.MenuService;
import restaurant.service.OrderService;
import restaurant.model.OrderStatus;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/changeOrder")
public class OrderChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("userType");
        if (userType.equals("worker")) {
            request.setAttribute("orderList", OrderService.getAllOrders());
            request.getRequestDispatcher("change-order.jsp").forward(request, response);
        }
        if (userType.equals("client")) {
            request.setAttribute("menuItems", MenuService.getAllMenuItems());
            request.getRequestDispatcher("place-order.jsp").forward(request, response);

        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderIdStr = request.getParameter("orderId");
        String statusStr = request.getParameter("status");
        if (orderIdStr != null && statusStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            OrderStatus status = OrderStatus.valueOf(statusStr);
            OrderService.updateOrderStatus(orderId, status);
        }
        request.setAttribute("orderList", OrderService.getAllOrders());
        request.setAttribute("userType", "worker");
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
