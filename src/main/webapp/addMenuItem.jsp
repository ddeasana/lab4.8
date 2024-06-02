<html>
<body>
<h2>New Menu Item</h2>
<form action="menu" method="post">
  <input type="hidden" name="userType" value="worker">
  <label for="id">ItemId:</label>
  <input type="text" id = "id" name="id" required><br>
  <br>
  <label for="price">Price:</label>
  <input type="text" id = "price" name="price" required><br>
  <br>
  <label for="name">Name:</label>
  <input type="text" id = "name" name="name" required><br>
  <br>
  <input type="hidden" name="userType" value="worker">
  <input type="submit" value="Submit">
</form>

<form action="menu" method="get">
  <input type="hidden" name="userType" value="worker">
  <input type="submit" value="Go back">
</form>
</body>
</html>