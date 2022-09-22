//package com.geekbrains.spring.web.controllers;
//
//import com.geekbrains.spring.web.dto.Cart;
//import com.geekbrains.spring.web.services.CartService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/carts")
//@RequiredArgsConstructor
//public class CartController {
//    private final CartService cartService;
//
//    @PostMapping
//    public Cart getCurrentCart(@RequestBody String cartName){
//        return cartService.getCurrentCart(cartName);
//    }
//
//    @PostMapping("/add/{id}")
//    public void addProductToCart(@PathVariable Long id, @RequestBody String cartName){
//        cartService.addProductByIdToCart(id, cartName);
//    }
//
//    @PostMapping("/clear")
//    public void clearCart(@RequestBody String cartName){
//        cartService.getCurrentCart(cartName).clear();
//    }
//
//    @PostMapping("/decrease/{id}")
//    public void decreaseProductIntoCart(@PathVariable Long id, @RequestBody String cartName) {
//        cartService.decreaseProductIntoCart(id, cartName);
//    }
//
//    @PostMapping("/remove/{id}")
//    public void removeProductFromCart(@PathVariable Long id, @RequestBody String cartName) {
//        cartService.removeProductFromCart(id, cartName);
//    }
//
//}