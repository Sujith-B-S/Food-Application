<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sg.oderhistorypojo.OrderHistory" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }

        h1 {
            text-align: center;
            color: #2d2d2d;
            margin: 30px 0;
            font-size: 32px;
            font-weight: 600;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 300px;
            padding: 20px;
            text-align: center;
            transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
            overflow: hidden;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }

        .card p {
            margin: 15px 0;
            color: #555;
            font-size: 16px;
        }

        .card ul {
            list-style-type: none;
            padding: 0;
        }

        .card li {
            margin: 5px 0;
            font-size: 14px;
            color: #777;
        }

        .empty-history {
            text-align: center;
            color: #777;
            font-size: 18px;
            margin-top: 50px;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            h1 {
                font-size: 28px;
            }
            .container {
                flex-direction: column;
                align-items: center;
            }
            .card {
                width: 90%;
            }
        }
    </style>
</head>
<body>

<h1>Order History</h1>

<%
    // Retrieve the order history list from the session
    ArrayList<OrderHistory> ohList = (ArrayList<OrderHistory>) request.getSession().getAttribute("ohList");

    if (ohList != null && !ohList.isEmpty()) {
        // Group orders by orderId
        Map<Integer, List<OrderHistory>> groupedOrders = new HashMap<>();
        for (OrderHistory oh : ohList) {
            groupedOrders.computeIfAbsent(oh.getOrderId(), k -> new ArrayList<>()).add(oh);
        }
%>
    <div class="container">
        <% for (Map.Entry<Integer, List<OrderHistory>> entry : groupedOrders.entrySet()) { 
            Integer orderId = entry.getKey();
            List<OrderHistory> orders = entry.getValue();
        %>
            <div class="card">
                <p><strong>Order ID:</strong> <%= orderId %></p>
                <p><strong>Items:</strong></p>
                <ul>
                    <% for (OrderHistory oh : orders) { %>
                        <li>Restaurant ID: <%= oh.getRestaurantId() %>, Total: ₹<%= oh.getTotal() %></li>
                    <% } %>
                </ul>
            </div>
        <% } %>
    </div>
<%
    } else {
%>
    <div class="empty-history">
        <h2>No orders found in your history!</h2>
    </div>
<%
    }
%>

</body>
</html>
