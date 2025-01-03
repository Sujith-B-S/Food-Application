<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<style>
    /* Basic Reset */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
        transition: opacity 0.5s ease;
    }

    /* Animation for Fade In and Fade Out */
    .fade-out {
        opacity: 0;
        transition: opacity 0.5s ease;
    }

    /* Form Container */
    .register-container {
        background-color: white;
        padding: 40px;
        width: 400px;
        box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    /* Error Message */
    .error-message {
        color: red;
        margin-bottom: 20px;
        font-size: 14px;
    }

    /* Form Fields */
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 16px;
    }

    /* Submit Button */
    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #FF7F50;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #F88379;
    }

    /* Register Link Animation */
    .footer-text {
        margin-top: 20px;
        font-size: 14px;
        color: #666;
    }

    .footer-text a {
        color: #333;
        text-decoration: none;
        transition: color 0.3s ease;
    }

    .footer-text a:hover {
        color: #4CAF50;
    }
</style>
<script>
    function fadeOut(event) {
        event.preventDefault();
        document.body.classList.add('fade-out');
        setTimeout(() => {
            window.location.href = event.target.href;
        }, 500); // Delay to allow fade-out to complete
    }
</script>
</head>
<body>

<div class="register-container">
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
        <p class="error-message"><%= errorMessage %></p>
    <% } %>

    <form action="validation" method="POST">
        User Name : <input type="text" name="name" required><br><br>
        Email : <input type="text" name="email" required><br><br>
        Password : <input type="password" name="password" required><br><br>
        Confirm Password : <input type="password" name="cpassword" required><br><br>
        Mobile Number : <input type="text" name="mobile" required><br><br>
        Address : <input type="text" name="address" required><br><br>
        <input type="submit" value="Register">
    </form>

    <p class="footer-text">
        Already registered? &nbsp;
        <a href="login.jsp" onclick="fadeOut(event)">Login</a>
    </p>
</div>

</body>
</html>
