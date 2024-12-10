<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sg.cartitempojo.CartItem" %>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .container {
            margin: 20px auto;
            width: 90%;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f4f4f4;
        }

        .total {
            font-size: 1.2em;
            text-align: right;
            padding: 10px;
            background-color: #f4f4f4;
            font-weight: bold;
        }

        img {
            width: 80px;
            height: 80px;
            border-radius: 8px;
        }

        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin: 20px 0;
        }

        button {
            padding: 10px 15px;
            background-color: #FF6347;
            border: none;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #ff4500;
        }

        select {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        .empty-cart {
            text-align: center;
            font-size: 1.5em;
            color: #ff6347;
            margin: 30px 0;
        }
    </style>
    <script>
        function updateQuantity(cartItemId, quantity) {
            // Redirect to UpdateCartItem with the selected quantity
            window.location.href = `UpdateCartItem?cartItemId=${cartItemId}&quantity=${quantity}`;
        }

        function goBack() {
            window.history.back();
        }
    </script>
</head>
<body>
    <h1>Your Shopping Cart</h1>

    <div class="action-buttons">
        <button onclick="goBack()">Go Back</button>
        <a href="GetRestaurant"><button>Home</button></a>
        <a href="ClearCartItem"><button>Clear Cart</button></a>
    </div>

    <%-- Retrieve the cart from the session --%>
    <%
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
    %>
    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Image</th>
                    <th>Item Name</th>
                    <th>Description</th>
                    <th>Price (&#8377;)</th>
                    <th>Total (&#8377;)</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    double grandTotal = 0.0;
                    for (CartItem item : cart.values()) {
                        double total = item.getQuantity() * item.getPrice();
                        grandTotal += total;
                %>
                <tr>
                    <td><img src="<%= item.getImage() %>" alt="Item Image"></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getDescription() %></td>
                    <td>&#8377; <%= item.getPrice() %></td>
                    <td>&#8377; <%= total %></td>
                    <td>
                        <select name="quantity" onchange="updateQuantity(<%= item.getItemId() %>, this.value)">
                            <% for (int i = 1; i <= 10; i++) { %>
                                <option value="<%= i %>" <%= (i == item.getQuantity()) ? "selected" : "" %>><%= i %></option>
                            <% } %>
                        </select>
                    </td>
                    <td>
                        <a href="RemoveCartItem?cartItemId=<%= item.getItemId() %>"><button>Delete</button></a>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td colspan="4" class="total">Grand Total:</td>
                    <td colspan="3">&#8377; <%= grandTotal %></td>
                </tr>
            </tbody>
        </table>
    </div>
    
    <div class="action-buttons">
        <a href="checkkOut.jsp"><button>Check Out</button></a>
    </div>

    <% } else { %>
    <div class="empty-cart">
        Your cart is empty.
    </div>
    <% } %>
</body>
</html>
