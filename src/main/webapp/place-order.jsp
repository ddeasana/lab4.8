
<%@ page import="restaurant.model.MenuItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Place Order</h2>
<form action="orders" method="post">
    <label for="customerName">Customer Name:</label>
    <input type="text" id="customerName" name="customerName" required><br><br>

    <label for="itemIds">Item:</label>
    <select id="itemIds" name="itemIds" multiple required>
        <%
            List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            for (MenuItem item : menuItems) {
        %>
        <option value="<%= item.getId() %>"><%= item.getName() %> - <%= item.getPrice() %></option>
        <%
            }
        %>
    </select><br><br>

    <label for="paymentMethod">Payment Method:</label>
    <select id="paymentMethod" name="paymentMethod" required>
        <option value="CARD">Card</option>
        <option value="CASH">Cash</option>
    </select><br><br>

    <button type="submit">Place Order</button>
</form>
<form action="index.jsp" >
    <input type="submit" value="Main page">
</form>

</body>
</html>