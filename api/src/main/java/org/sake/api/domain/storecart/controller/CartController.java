package org.sake.api.domain.storecart.controller;

import org.sake.api.domain.storecart.model.Cart;
import org.sake.api.domain.storecart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storecart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/items")
    public void addItemToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addItemToCart(userId, productId, quantity);
    }

    @PutMapping("/items/{id}")
    public void updateItemQuantity(@RequestParam Long userId, @PathVariable Long id, @RequestParam int quantity) {
        cartService.updateItemQuantity(userId, id, quantity);
    }

    @DeleteMapping("/items/{id}")
    public void removeItemFromCart(@RequestParam Long userId, @PathVariable Long id) {
        cartService.removeItemFromCart(userId, id);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}
