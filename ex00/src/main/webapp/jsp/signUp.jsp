<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 26.06.2022
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <form action="${pageContext.request.contextPath}/singUp" method="post">
        <label for="first_name">First Name</label>
        <input type="text" id="first_name" name="first_name"><br><br>

        <label for="last_name">Last Name</label>
        <input type="text" id="last_name" name="last_name"><br><br>
        <label for="email">Email</label>
        <input type="text" id="email" name="email"><br><br>
        <label for="password">Password</label>
        <input type="text" id="password" name="password"><br><br>
        <input type="submit" value="Submit">
    </form>
</head>
<body>

</body>
</html>
