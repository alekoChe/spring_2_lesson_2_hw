package com.gbAleko.spring.web.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor   //////////
public class OrderItemDto {

    private Long productId;
    private String title;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(ProductDto productDto){
        this.productId = productDto.getId();
        this.title = productDto.getTitle();
        this.quantity = 1;
        this.pricePerProduct = productDto.getPrice();
        this.price = productDto.getPrice();
    }

    public void changeQuantity(int delta){
        this.quantity += delta;
        this.price = this.quantity * this.pricePerProduct;
    }

}
