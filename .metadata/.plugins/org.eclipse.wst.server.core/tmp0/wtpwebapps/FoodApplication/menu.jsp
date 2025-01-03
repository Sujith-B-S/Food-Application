<%@ page import="com.sg.menupojo.Menu" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu Details</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }

        .navbar {
            background-color: #ff6347;
            padding: 20px; /* Increased padding for a bigger navbar */
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .navbar a {
            color: white;
            margin: 0 25px; /* Increased margin for spacing */
            text-decoration: none;
            font-weight: bold;
            padding: 15px 20px; /* Increased padding for larger buttons */
            border-radius: 5px;
            font-size: 1.1em; /* Increased font size */
            transition: background-color 0.3s;
        }

        .navbar a:hover {
            background-color: #ff3d00;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            margin-top: 20px;
            padding: 0 20px;
        }

        .card {
            width: 23%;
            border: none;
            border-radius: 10px;
            overflow: hidden;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin-bottom: 20px;
            transition: transform 0.3s ease;
            position: relative;
        }

        .card img {
            width: 100%;
            height: 200px;
            border-radius: 10px 10px 0 0;
            object-fit: cover;
        }

        .card-content {
            padding: 15px;
        }

        .card-content h3 {
            margin: 10px 0;
            font-size: 1.5em;
            color: #333;
        }

        .card-content p {
            margin: 5px 0;
            font-size: 0.9em;
            color: #666;
        }

        .card:hover {
            transform: scale(1.05);
            cursor: pointer;
        }

        select {
            width: 50%;
            padding: 5px;
            margin: 10px 0;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            padding: 10px 15px;
            background-color: #FF734C;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #ff3d00;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .card {
                width: 45%;
            }
        }

        @media (max-width: 480px) {
            .card {
                width: 100%;
            }
        }

        .no-menu {
            text-align: center;
            font-size: 1.2em;
            color: #ff6347;
            margin-top: 20px;
        }
    </style>
    <script>
        // Function to handle adding an item to the cart using AJAX
        function addToCart(menuId) {
            const quantity = document.getElementById("quantity-" + menuId).value;

            // Perform AJAX request
            $.ajax({
                url: 'AddToCartController',
                method: 'POST',
                data: { menuId: menuId, quantity: quantity },
                success: function(response) {
                    alert("Added to cart successfully!"); // Notify success
                },
                error: function(xhr) {
                    alert("Error: " + (xhr.responseJSON ? xhr.responseJSON.message : "An error occurred")); // Notify error
               
                }
            });
        }
    </script>
</head>
<body>

    <div class="navbar">
        <a href="javascript:history.back()">Back</a>
        <a href="home.jsp">Home</a>
        <a href="cart.jsp" class="cart-button">Go to Cart</a>
    </div>

    <h1>Menu Item Details</h1>
    
    <div class="container">
        <% 
            // Get the menu list from the request
            List<Menu> menuList = (List<Menu>) request.getAttribute("menu");
            
            // Check if the menu list is not null and not empty
           
            if (menuList != null && !menuList.isEmpty()) { 
                // Loop through the menu list and display each item
                for (Menu menu : menuList) {
        %>
        <div class="card">
            <div class="card-content">
                <img alt="Menu Items" src="<%= menu.getImage() %>">
                <h3><%= menu.getName() %></h3>
                <p><strong>Description:</strong> <%= menu.getDescription() %></p>
                <p><strong>Price:</strong> ₹<%= menu.getPrice() %></p>
                <p><strong>Rating:</strong> <%= menu.getRating() %>/5</p>
                <p><strong>Available:</strong> <%= menu.isAvailable() ? "Yes" : "No" %></p>
                <label for="quantity-<%= menu.getMenuId() %>">Quantity:</label>
                <select id="quantity-<%= menu.getMenuId() %>" name="quantity">
                    <% for (int i = 1; i <= 10; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                <button type="button" onclick="addToCart(<%= menu.getMenuId() %>)">Add to Cart</button>
            </div>
        </div>
        <% 
                } // End of for loop
            } else { // If no menu items are available
        %>
        <p>No menu details found for this restaurant.</p>
        <% } %>
    </div>
    <div style="text-align: center; margin-top: 20px;">
        
    </div>
</body>
</html>
