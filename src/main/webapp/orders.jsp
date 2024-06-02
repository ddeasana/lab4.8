<%@ page import="restaurant.model.Order" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Id</th>
        <th>customerName</th>
        <th>Items</th>
        <th>Status</th>
        <th>Payment</th>
    </tr>

    <% for (Order order : (List<Order>)request.getAttribute("orderList")) { %>
    <tr>
        <td><%= order.getId()%></td>
        <td><%= order.getCustomerId()%></td>
        <td><%= order.getItemsAsString()%></td>
        <td><%= order.getStatus()%></td>
        <td><%= order.getPaymentMethod()%></td>
    </tr>
    <% } %>
</table>
<br>

<% if (request.getAttribute("userType") == "client") { %>
<form action="changeOrder" method="get">
    <input type="hidden" name="userType" value="client">
    <input type="submit" value="Create an order">
</form>
<%} %>

<% if (request.getAttribute("userType") == "worker") { %>
<form action="changeOrder" method="get">
    <input type="hidden" name="userType" value="worker">
    <input type="submit" value="Change order status">
</form>

<%} %>

<form action="index.jsp" >
    <input type="submit" value="Main page">
</form>
</body>
</html>
