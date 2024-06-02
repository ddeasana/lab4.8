<html>
<body>
<h2>Restaurant Main Page</h2>
<p>Are you a client or a restaurant worker?</p>

<form action="menu" method="get">
    <input type="hidden" name="userType" value="client">
    <input type="submit" value="Client">
</form>

<form action="menu" method="get">
    <input type="hidden" name="userType" value="worker">
    <input type="submit" value="Restaurant worker">
</form>
</body>
</html>