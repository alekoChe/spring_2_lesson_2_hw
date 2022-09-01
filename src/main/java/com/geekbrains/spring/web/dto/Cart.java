package com.geekbrains.spring.web.dto;

import com.geekbrains.spring.web.entities.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Data
@Slf4j  /////////////////
public class Cart {

    private List<OrderItemDto> items;
    private  int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(String cartName, CacheManager manager){
        Cart cart = manager.getCache("Cart").get(cartName, Cart.class);
        if(Optional.ofNullable(cart).isPresent()){
            this.items = cart.getItems();
            this.totalPrice = cart.getTotalPrice();
        } else {
            this.items = new ArrayList<>();
            this.totalPrice = 0;
            manager.getCache("Cart").put(cartName, Cart.class);
        }
    }


//    public Cart(String cartName, CacheManager manager){
//            this.items = new ArrayList<>();
//            this.totalPrice = 0;
//        }

    public boolean addProductCount(Long id){
        for(OrderItemDto o: items){
            if(o.getProductId().equals(id)){
                o.changeQuantity(1);
                recalculate();
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product){
        if(addProductCount(product.getId())){
            return;
        }
        items.add(new OrderItemDto(product));
        recalculate();
    }

    private void recalculate(){
        totalPrice = 0;
        for(OrderItemDto o: items){
            totalPrice += o.getPrice();
        }
    }

    public void removeProduct(Long id){
        items.removeIf(o -> o.getProductId().equals(id));
        recalculate();
    }

    public void decreaseProduct(Long id){
        Iterator<OrderItemDto> iter = items.iterator();
        while (iter.hasNext()){
            OrderItemDto o = iter.next();
            if(o.getProductId().equals(id)){
                o.changeQuantity(-1);
                if(o.getQuantity() <= 0){
                    iter.remove();
                }
                recalculate();
                return;
            }
        }
        log.info("decrease product in cart"); ////////////////
    }

    public void clear(){
        items.clear();
        totalPrice = 0;
        log.info("Cart is cleared"); ////////////////
    }
}
