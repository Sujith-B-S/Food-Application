<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sg.cartitempojo.CartItem" %>
<html>
<head>
    <title>Your Cart</title>
    <style>
        h1 {
            text-align: center;
        }

        .container {
            margin: 20px auto;
            width: 80%;
            border-collapse: collapse;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .total {
            text-align: right;
            font-weight: bold;
        }

        img {
            width: 80px;
            height: 80px;
        }

        button {
            padding: 5px 10px;
            background-color: #FF734C;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #ff3d00;
        }
    </style>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <a href = "GetRestaurant"> <button>Home</button> </a>
    <a href = "ClearCartItem"> <button>Clear Cart</button> </a>
    
    <%
        // Retrieve the cart from the session
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
    %>
    <table class="container">
        <thead>
            <tr>
                <th>Image</th>
                <th>Item Name</th>
                <th>Description</th>
                <th>Price (₹)</th>
                <th>Total (₹)</th>
                <th>Quantity</th>
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
                
                <td><%= item.getPrice() %></td>
                <td><%= total %></td>
                <td>
                    <form action="UpdateCartItem" method="get">
                        <input type="hidden" name="cartItemId" value="<%= item.getItemId() %>">
                        <select name="quantity" >
                            <% 
                                // Dynamically generate quantity options from 1 to 10
                                for(int i = 0; i <= 10; i++) {
                            %>
                                <option value="<%= i %>" <%= (i == item.getQuantity()) ? "selected" : "" %>><%= i %></option>
                            <% 
                                }
                            %>
                        </select>
                        <a href="UpdateCartItem?cartItemId=<%= item.getItemId() %>"><button>Update</button></a>
                    </form>
                        <a href="RemoveCartItem?cartItemId=<%= item.getItemId() %>"><button>Delete</button></a>
                </td> 
            </tr>
            <% } %>
            <tr>
                <td colspan="5" class="total">Grand Total:</td>
                <td><%= grandTotal %></td>
            </tr>
        </tbody>
    </table>
    <% 
        } else { 
    %>
    <p>Your cart is empty.</p>
    <% 
        } 
    %>

    <br/>
    <a href="checkout.jsp"><button>Proceed to Checkout</button></a>
</body>
</html>
