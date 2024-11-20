package com.sg.cartdaoimpl;

import java.util.Map;

import com.sg.cartitempojo.CartItem;

public class CartDAOImpl {

    // Add or update an item in the cart
    public Map<Integer, CartItem> addItem(Map<Integer, CartItem> cart, CartItem ci) {
        int itemId = ci.getItemId();
        if (cart.containsKey(itemId)) {
            CartItem existingItem = cart.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + ci.getQuantity());
        } else {
            cart.put(itemId, ci);
        }
        return cart;
    }

    // Update the quantity of an item in the cart
    public Map<Integer, CartItem> updateItem(Map<Integer, CartItem> cart, int itemId, int quantity) {
        if (cart.containsKey(itemId)) {
            if (quantity <= 0) {
                cart.remove(itemId); // Remove the item if quantity is 0 or less
            } else {
                cart.get(itemId).setQuantity(quantity);
            }
        }
        return cart;
    }

    // Remove an item from the cart
    public Map<Integer, CartItem> removeItem(Map<Integer, CartItem> cart, int itemId) {
        cart.remove(itemId);
        return cart;
    }

    // Clear all items in the cart
    public void clearCart(Map<Integer, CartItem> cart) {
        cart.clear();
    }
}
