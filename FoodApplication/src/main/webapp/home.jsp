<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sg.restaurantpojo.Restaurant" %>
<%@ page import="com.sg.menupojo.Menu" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sg.userpojo.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Food Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/fontawesome.min.css" integrity="sha512-B46MVOJpI6RBsdcU307elYeStF2JKT87SsHZfRSkjVi4/iZ3912zXi45X5/CBr/GbCyLx6M1GQtTKYRd52Jxgw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        /* Google Font */
        @import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@400;600;700&display=swap');

        html {
            scroll-behavior: smooth;
        }

        body {
            margin: 0;
            font-family: 'Nunito Sans', sans-serif;
            background-color: #f9f9f9;
        }

        /* Navbar Styling */
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            height: 90px;
            background-color: #FF734C;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }
        
        h2{
        	text-align: center;
        	font-size: 40px;
        }
        .navbar-left .nav {
            display: flex;
            align-items: center;
        }

        .navbar-left {
            gap: 35px;
            display: flex;
            align-items: center;
        }

        .app-name {
            font-size: 28px;
            font-weight: 700;
            color: white;
            margin-right: 20px;
        }

        nav {
            display: flex;
            gap: 15px;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            font-weight: 600;
        }

        .navbar a:hover {
            color: black;
        }

        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .user-info p {
            margin: 0;
            color: white;
            font-size: 18px;
        }

        .user-info a {
            color: #fff;
            padding: 8px 12px;
            border-radius: 5px;
            margin-right: 30px;
            background-color: #ff4500;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .user-info a:hover {
            background-color: #ff3300;
        }

        .cart-button {
            display: inline-block;
            margin-right: 30px;
            padding: 10px 20px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            background: linear-gradient(90deg, #ff7e5f, #feb47b);
            border: none;
            border-radius: 25px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-decoration: none;
            text-align: center;
            transition: all 0.3s ease-in-out;
        }

        .cart-button:hover {
            background: linear-gradient(90deg, #feb47b, #ff7e5f);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
            transform: translateY(-2px);
        }

        .cart-button:active {
            transform: translateY(0);
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
        }

        /* Hamburger Menu */
        .hamburger {
            display: none;
            flex-direction: column;
            gap: 5px;
            cursor: pointer;
        }

        .hamburger div {
            width: 25px;
            height: 3px;
            background-color: white;
        }

        .navbar nav.active {
            display: flex;
            flex-direction: column;
            background-color: #FF734C;
            position: absolute;
            top: 70px;
            left: 0;
            width: 100%;
            padding: 10px 0;
            z-index: 999;
        }

        .carousel {
            max-width: 95%;
            margin: 50px auto;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            margin-top: 130px;
        }

        .carousel-inner img {
            height: 270px; /* Fixed height for uniformity */
            object-fit: cover;
        }

        .carousel-caption {
            background: rgba(0, 0, 0, 0.6); /* Semi-transparent background for text */
            padding: 10px;
            border-radius: 5px;
        }

        .carousel-caption h5 {
            font-size: 20px;
            font-weight: bold;
        }

        .carousel-caption p {
            font-size: 14px;
        }

        .container {
            margin: 50px;
            margin-top: 30px;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 50px;
            padding: 20px;
        }
        .container-item {
            margin: 50px;
            margin-top: 30px;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 50px;
            padding: 20px;
        }

        .card {
            border: 1px solid #ddd;
            border-radius: 10px;
            margin-bottom: 10px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }

        .card img {
            width: 100%;
            height: 250px;
            object-fit: cover;
            border-radius: 10px 10px 0px 0px;
        }

        .card-content {
            padding: 15px;
            text-align: center;
        }

        .card-content h3 {
            font-size: 1.5rem;
            color: #1E201E;
            margin: 10px 0;
        }

        .card-content p {
            font-size: 0.9rem;
            color: #666;
            margin: 5px 0;
        }

        a {
            text-decoration: none;
        }

        /* Responsive Adjustments */
        @media (max-width: 790px) {
            .hamburger {
                display: flex;
                width: 10px;
            }

            .navbar nav {
                display: none;
            }

            .navbar nav.active {
                display: flex;
            }

            .app-name {
                font-size: 24px;
            }

            .user-info a {
                font-size: 14px;
            }
        }

        @media (max-width: 450px) {
            .hamburger {
                display: flex;
            }

            .navbar nav {
                display: none;
            }

            .navbar nav.active {
                display: flex;
            }

            .app-name {
                font-size: 20px;
            }

            .user-info a {
                font-size: 7px;
            }
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const hamburger = document.querySelector('.hamburger');
            const nav = document.querySelector('.navbar nav');

            hamburger.addEventListener('click', () => {
                nav.classList.toggle('active');
            });
        });
    </script>
</head>

<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="navbar-left">
            <div class="title">
                <p class="app-name">Food World</p>
            </div>
            <div class="hamburger">
                <div></div>
                <div></div>
                <div></div>
            </div>
            <nav>
                <a href="home.jsp">Home</a>
                <a href="#restaurant-details">Restaurants</a>
                <a href="contact.jsp">Contact Us</a>
                <a href="about.jsp">About</a>
            </nav>
        </div>
        <a href="cart.jsp" class="cart-button"> Go to Cart</a>
        <a href="ShowOrderHistory" class="cart-button">OrderHistory</a>
        <div class="user-info">
            <% 
                User user = (User) session.getAttribute("loggedInUser"); 
                if (user != null) { 
            %>
                <p>Welcome, <%= user.getUsername() %></p>
                <a href="login.jsp">Logout</a>
            <% 
                } else { 
            %>
                <a href="login.jsp">Login</a>
                <a href="register.jsp">Register</a>
            <% 
                } 
            %>
        </div>
    </div>
    

    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Eat Tastier</h5>
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://images.freeimages.com/images/large-previews/ac6/roasted-chicken-feast-0410-5702617.jpg" class="d-block w-100" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Stay Healthier</h5>
               
            </div>
        </div>
        <div class="carousel-item">
            <img src="https://cdn.pixabay.com/photo/2014/04/22/02/56/pizza-329523_1280.jpg" class="d-block w-100" alt="Third slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Become Happier</h5>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/js/fontawesome.min.js" integrity="sha512-NeFv3hB6XGV+0y96NVxoWIkhrs1eC3KXBJ9OJiTFktvbzJ/0Kk7Rmm9hJ2/c2wJjy6wG0a0lIgehHjCTDLRwWw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    <div class = "popular-items">
    	<h2>Popular Items</h2>
    	<div class="container-item">
        <% 
            List<Menu> hmList = (List<Menu>) session.getAttribute("hmList");
            if (hmList != null) {
                for (Menu res : hmList) {
        %>
        <a href="ShowMenu?restaurantId=<%= res.getRestaurantId() %>">
        <div class="card">
            <img src="<%= res.getImage() %>" alt="Restaurant">
            <div class="card-content">
                <h3><%= res.getName() %></h3>
                <p><strong>Cuisine:</strong> <%= res.getPrice() %></p>
                <p><strong>Location:</strong> <%= res.getRating() %></p>
            </div>
        </div>
        </a>
        <% 
            } 
        } 
        %>
    </div>
    	
    </div>
    

    <!-- Restaurant Cards -->
    <div id = "restaurant-details">
    	<h2>Restaurants</h2>
    <div class="container">
    <!-- <h2>Restaurants</h2> -->
        <% 
            List<Restaurant> resList = (List<Restaurant>) session.getAttribute("resList");
            if (resList != null) {
                for (Restaurant res : resList) {
        %>
        <a href="ShowMenu?restaurantId=<%= res.getRestaurantId() %>">
        <div class="card">
            <img src="<%= res.getImage() %>" alt="Restaurant">
            <div class="card-content">
                <h3><%= res.getName() %></h3>
                <p><strong>Cuisine:</strong> <%= res.getCuisineType() %></p>
                <p><strong>Location:</strong> <%= res.getAddress() %></p>
            </div>
        </div>
        </a>
        <% 
            } 
        } 
        %>
    </div>
    </div>
</body>
</html>
