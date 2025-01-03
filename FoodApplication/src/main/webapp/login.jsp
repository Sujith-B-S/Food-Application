<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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
            background-color: #f0f0f0;
            color: #333;
        }

        /* Card Container */
        .login-container {
            background-color: white;
            width: 500px;
            padding: 40px;
            box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
            border-radius: 25px;
            text-align: center;
        }

        /* Title */
        .login-container h2 {
            margin-bottom: 20px;
            color: #333;
            font-size: 24px;
        }

        /* Input Styles */
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 15px;
            font-size: 16px;
        }

        /* Button */
        .login-container input[type="submit"] {
            width: 40%;
            padding: 12px;
            margin-top: 20px;
            background-color: #FF7F50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 15px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container input[type="submit"]:hover {
            background-color: #F88379;
        }

        /* Register Link with Animation */
        .register-link {
            margin-top: 20px;
            display: inline-block;
            color: #333;
            text-decoration: none;
            font-size: 14px;
            transition: color 0.3s ease;
        }

        /* Hover and Animation */
        .register-link:hover {
            color: #F88379;
            transform: scale(1.1);
            transition: transform 0.3s ease, color 0.3s ease;
        }

        /* Footer Text */
        .footer-text {
            margin-top: 20px;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <form action="login" method="POST">

        <input type="text" id="email" name="email" required placeholder="Email"><br>

        <input type="password" id="pwd" name="pwd" required placeholder="Password"><br>

        <input type="submit" value="Login">
    </form>
    
    <p class="footer-text">
        Don't have an account? 
        <a href="register.jsp" class="register-link">Register</a>
    </p>
</div>

</body>
</html>
