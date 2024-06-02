<%@ page import="restaurant.model.MenuItem" %>
<%@ page import="java.util.List" %>

<html>

<body>
<h1>Menu</h1>
<p></p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <% for (MenuItem item : (List<MenuItem>)request.getAttribute("menuItems")) { %>
    <tr>
        <td><%= item.getId()%></td>
        <td><%= item.getName()%></td>
        <td><%= item.getPrice()%></td>
    </tr>
    <% } %>
</table>
<br>

<% if (request.getAttribute("userType") == "client") { %>
    <form action="orders" >
    <input type="hidden" name="userType" value="client">
    <input type="submit" value="Order menu">
    </form>
<%} %>

<% if (request.getAttribute("userType") == "worker") { %>
<form action="addMenuItem.jsp" >
    <input type="submit" value="Add new menu item">
</form>

<form action="orders" >
    <input type="hidden" name="userType" value="worker">
    <input type="submit" value="Order menu">
</form>
<%} %>

<form action="index.jsp" >
    <input type="submit" value="Main page">
</form>

</body>
</html>