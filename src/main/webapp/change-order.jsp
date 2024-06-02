<%@ page import="restaurant.model.Order" %>
<%@ page import="restaurant.model.OrderStatus" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order Status</title>
</head>
<body>
<h2>Update Order Status</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Customer Name</th>
        <th>Items</th>
        <th>Status</th>
        <th>Payment</th>
        <th>Action</th>
    </tr>

    <% for (Order order : (List<Order>)request.getAttribute("orderList")) { %>
    <tr>
        <td><%= order.getId() %></td>
        <td><%= order.getCustomerId() %></td>
        <td><%= order.getItemsAsString() %></td>
        <td><%= order.getStatus() %></td>
        <td><%= order.getPaymentMethod() %></td>
        <td>
            <form action="changeOrder" method="post">
                <input type="hidden" name="orderId" value="<%= order.getId() %>">
                <select name="status">
                    <% for (OrderStatus status : OrderStatus.values()) { %>
                    <option value="<%= status %>" <%= status == order.getStatus() ? "selected" : "" %>><%= status %></option>
                    <% } %>
                </select>
                <button type="submit">Update</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<br>
<form action="index.jsp" >
    <input type="submit" value="Main page">
</form>
</body>
</html>