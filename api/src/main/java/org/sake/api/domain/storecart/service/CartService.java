package org.sake.api.domain.storecart.service;

import org.sake.api.domain.storecart.model.Cart;
import org.sake.api.domain.storecart.model.CartItem;
import org.sake.api.domain.storecart.repository.CartItemRepository;
import org.sake.api.domain.storecart.repository.CartRepository;
import org.sake.api.domain.storecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sake.api.domain.storecart.model.Product;

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void addItemToCart(Long userId, Long productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(new CartItem());

        cartItem.setCart(cart);
        cartItem.setProduct(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")));
        cartItem.setQuantity(cartItem.getQuantity() + quantity);

        cartItemRepository.save(cartItem);
        updateCartTotalPrice(cart);
    }

    public void removeItemFromCart(Long userId, Long cartItemId) {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        cartItemRepository.delete(cartItem);
        updateCartTotalPrice(cart);
    }

    public void updateItemQuantity(Long userId, Long cartItemId, int quantity) {
        Cart cart = getCartByUserId(userId);
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
        updateCartTotalPrice(cart);
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartItemRepository.deleteAll(cart.getItems());
        cart.getItems().clear();
        updateCartTotalPrice(cart);
    }

    private void updateCartTotalPrice(Cart cart) {
        double totalPrice = cart.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
    }
