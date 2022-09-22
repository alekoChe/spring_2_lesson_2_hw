package com.gbAleko.spring.web.cart.controllers;

import com.gbAleko.spring.web.cart.dto.Cart;
import com.gbAleko.spring.web.cart.dto.OrderDetailsDto;
import com.gbAleko.spring.web.cart.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public Cart getCurrentCart(@RequestBody String cartName){
        return cartService.getCurrentCart(cartName);
    }

    @PostMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id, @RequestBody String cartName){
        cartService.addProductByIdToCart(id, cartName);
    }

    @PostMapping("/clear")
    public void clearCart(@RequestBody String cartName){
        cartService.getCurrentCart(cartName).clear();
    }

    @PostMapping("/decrease/{id}")
    public void decreaseProductIntoCart(@PathVariable Long id, @RequestBody String cartName) {
        cartService.decreaseProductIntoCart(id, cartName);
    }

    @PostMapping("/remove/{id}")
    public void removeProductFromCart(@PathVariable Long id, @RequestBody String cartName) {
        cartService.removeProductFromCart(id, cartName);
    }

//    @PostMapping("/createOrder/{cartName}")
//    public void createOrder(@RequestHeader String username, @RequestBody OrderDetailsDto orderDetailsDto, @PathVariable String cartName){
//        cartService.createOrder(username, orderDetailsDto, cartName);
//    }

}
