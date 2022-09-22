package com.gbAleko.spring.web.cart.tests;

import com.gbAleko.spring.web.cart.dto.ProductDto;
import com.gbAleko.spring.web.cart.services.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class CartTest {
    @Autowired
    private CartService cartService;

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    public void initCart() {
        cartService.clear("test_cart");
    }

    @Test
    public void addProductByIdToCartTest() {
        ProductDto productDto = new ProductDto();
        productDto.setId(111L);
        productDto.setTitle("Product-test");
        productDto.setPrice(222);

        Mockito.doReturn(Optional.of(productDto)).when(restTemplate)
                .getForObject("http://localhost:8189/web-market-core/api/v1/products/" + 111L, ProductDto.class);

        cartService.addProductByIdToCart(111L, "cartName-test");
        cartService.addProductByIdToCart(111L, "cartName-test");
        cartService.addProductByIdToCart(111L, "cartName-test");

        Mockito.verify(restTemplate, Mockito.times(1))
                .getForObject(ArgumentMatchers
                        .eq("http://localhost:8189/web-market-core/api/v1/products/" + 111L), ProductDto.class);

        Mockito.verify(restTemplate, Mockito.times(3))
                .getForObject(ArgumentMatchers
                        .eq("http://localhost:8189/web-market-core/api/v1/products/" + 111L), ProductDto.class);
    }


//
//    @Test
//    public void addToCartTest() {
//        Book book = new Book();
//        book.setId(5L);
//        book.setTitle("X");
//        book.setPrice(BigDecimal.valueOf(100.0));
//
//        Genre genre = new Genre();
//        genre.setTitle("X");
//        Author author = new Author();
//        author.setName("X");
//        book.setGenre(genre);
//        book.setAuthor(author);
//
//        Mockito.doReturn(Optional.of(book)).when(bookService).findById(5L);
//
//        cartService.addToCart("test_cart", 5L);
//        cartService.addToCart("test_cart", 5L);
//        cartService.addToCart("test_cart", 5L);
//
//        Mockito.verify(bookService, Mockito.times(1)).findById(ArgumentMatchers.eq(5L));
//        Assertions.assertEquals(1, cartService.getCurrentCart("test_cart").getItems().size());
//    }
}