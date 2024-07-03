package com.heli.service;

import com.heli.model.Cart;
import com.heli.model.CartItem;
import com.heli.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddCartItemRequest req, String jwt)throws Exception;

    public CartItem updateCartItemQuantity(int cartItemId, int quantity)throws Exception;

    public Cart removeItemFromCart(int cartItemId, String jwt)throws Exception;

    public Long calculateCartTotals(Cart cart)throws Exception;

    public Cart findCartById(int id)throws Exception;

    public Cart findCartByUserId(String jwt)throws Exception;

    public Cart clearCart(String jwt)throws Exception;
}
