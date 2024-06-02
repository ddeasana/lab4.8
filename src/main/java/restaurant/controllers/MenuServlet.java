package restaurant.controllers;

import restaurant.model.MenuItem;
import restaurant.service.MenuService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("menuItems", MenuService.getAllMenuItems());
        try{
            String userType = req.getParameter("userType");

        if (userType.equals("worker")) {
            try {
                req.setAttribute("userType", "worker");
                req.getRequestDispatcher("menu.jsp").forward(req, resp);
            } catch (Exception e) {
                resp.sendRedirect("error.jsp");
            }
        }
        if (userType.equals("client")) {
            try {
                req.setAttribute("userType", "client");
                req.getRequestDispatcher("menu.jsp").forward(req, resp);
            } catch (Exception e) {
                resp.sendRedirect("error.jsp");
            }
        }
        }catch (Exception e){
            req.setAttribute("userType", "worker");
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = 0;
        String name = " ";
        name = request.getParameter("name");
        double price = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
            price = Double.parseDouble(request.getParameter("price"));

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
        MenuItem item = new MenuItem(id, name, price);
        MenuService.addMenuItem(item);
        response.sendRedirect("menu");
        }

}