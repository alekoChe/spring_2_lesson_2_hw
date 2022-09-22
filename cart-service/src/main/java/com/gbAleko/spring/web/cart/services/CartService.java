package com.gbAleko.spring.web.cart.services;

import com.gbAleko.spring.web.cart.dto.ProductDto;
import com.gbAleko.spring.web.cart.dto.Cart;
//import com.geekbrains.spring.web.entities.Product;
//import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
//    private final ProductsService productsService;
//    private final CacheManager cacheManager;
//    @Value("${other.cache.cart}")
//    private String CACHE_CART;
//    private Cart cart;

    @Qualifier("test")
    private final CacheManager cacheManager;
    private final RestTemplate restTemplate; //ProductService
    @Value("${spring.cache.user.name}")
    private String CACHE_CART;
    private Cart cart;

    //@Cacheable(value = "${other.cache.cart}", key = "#cartName")
    @Cacheable(value = "${spring.cache.user.name}", key = "#cartName")
    public Cart getCurrentCart(String cartName){
        cart = cacheManager.getCache(CACHE_CART).get(cartName, Cart.class);
        if(!Optional.ofNullable(cart).isPresent()){
            cart = new Cart(cartName, cacheManager);
            cacheManager.getCache(CACHE_CART).put(cartName, cart);
        }
        return cart;
    }

    //@CachePut(value = "${other.cache.cart}", key = "#cartName")
    @CachePut(value = "${spring.cache.user.name}", key = "#cartName")
    public Cart addProductByIdToCart(Long id, String cartName){
        Cart cart = getCurrentCart(cartName);
        if(!cart.addProductCount(id)) {
            ProductDto productDto =
                    restTemplate.getForObject("http://localhost:8189/web-market-core/api/v1/products/" + id, ProductDto.class);
            cart.addProduct(productDto);
        }
        return cart;
    }


    //@CachePut(value = "${other.cache.cart}", key = "#cartName")
    @CachePut(value = "${spring.cache.user.name}", key = "#cartName")
    public void clear(String cartName){
        Cart cart = getCurrentCart(cartName);
        cart.clear();
    }

    //@CachePut(value = "${other.cache.cart}", key = "#cartName")
    @CachePut(value = "${spring.cache.user.name}", key = "#cartName")
    public Cart decreaseProductIntoCart(Long id, String cartName) {
        Cart cart = getCurrentCart(cartName);
        cart.decreaseProduct(id);
        return cart;
    }

    //@CachePut(value = "${other.cache.cart}", key = "#cartName")
    @CachePut(value = "${spring.cache.user.name}", key = "#cartName")
    public Cart removeProductFromCart(Long id, String cartName) {
        Cart cart = getCurrentCart(cartName);
        cart.removeProduct(id);
        return cart;
    }

    /** добавил метод и закамментил */
//    public void createOrder(String username, OrderDetailsDto orderDetailsDto, String cartName) {
//        Cart currentCart = getCurrentCart(cartName);
//        OrderDto order = new OrderDto();
//        order.setAddress(orderDetailsDto.getAddress());
//        order.setPhone(orderDetailsDto.getPhone());
//        order.setUsername(username);
//        order.setTotalPrice(currentCart.getTotalPrice());
//        order.setItemDtoList(currentCart.getItems());
//        currentCart.clear();
//        kafkaTemplate.send(topic, order);
//    }

    //    public void addProductByIdToCart(Long id, String cartName){
//        if(!getCurrentCart(cartName).addProductCount(id)){
//            Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Не удалось найти продукт"));
//            Cart cart = getCurrentCart(cartName);
//            cart.addProduct(product);
//            cacheManager.getCache("Cart").put(cartName, cart);
//        }
//    }

    //    public void clear(String cartName){
//        Cart cart = getCurrentCart(cartName);
//        cart.clear();
//        cacheManager.getCache(CACHE_CART).put(cartName, cart);
//    }

    //    public void removeItemFromCart(String cartKey, Long productId) {
//        execute(cartKey, c -> c.removeProduct(productId));
//    }

}
