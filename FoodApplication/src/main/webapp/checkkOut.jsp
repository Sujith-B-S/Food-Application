<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f8f8;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .payment-methods {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .payment-method {
            flex: 1;
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 10px;
            cursor: pointer;
            transition: background-color 0.3s, border-color 0.3s;
        }

        .payment-method:hover {
            background-color: #red;
            border-color: #ff734c;
        }

        .selected {
            background-color: #ff734c;
            color: white;
            border-color: #ff3d00;
        }

        .summary {
            margin-bottom: 20px;
        }

        .summary p {
            margin: 8px 0;
        }

        #submit {
            width: 100%;
            padding: 15px;
            background-color: #ff734c;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #ff3d00;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Checkout</h1>

        <!-- Payment Methods -->
        <div class="form-group">
            <label>Select Payment Method:</label>
            <div class="payment-methods">
                <div class="payment-method" onclick="selectPayment(this)">Credit/Debit Card</div>
                <div class="payment-method" onclick="selectPayment(this)">UPI</div>
                <div class="payment-method" onclick="selectPayment(this)">Cash on Delivery</div>
            </div>
        </div>
<form action="SaveOrders">
        <!-- Details Form -->
        <div class="form-group">
            <label for="address">Delivery Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter your address" required>
        </div>

        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input type="number" id="phone" name="phone" placeholder="Enter your phone number" required>
        </div>

        <!-- Summary -->
        <div class="summary">
            <h2>Order Summary</h2>
            <p>Items Total: ₹<span id="itemsTotal">1500</span></p>
            <p>Delivery Charge: ₹<span id="deliveryCharge">50</span></p>
            <p><strong>Grand Total: ₹<span id="grandTotal">1550</span></strong></p>
        </div>

        <!-- Place Order Button -->
       
       		<input id = "submit" type = "submit" value = "Place Order">
       </form>
    </div>

    <script>
        function selectPayment(element) {
            // Clear previous selection
            const methods = document.querySelectorAll('.payment-method');
            methods.forEach(method => method.classList.remove('selected'));

            // Mark the selected payment method
            element.classList.add('selected');
        }
    </script>
</body>
</html>
