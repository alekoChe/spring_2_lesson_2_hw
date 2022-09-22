package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.OrderConverter;
import com.geekbrains.spring.web.converters.OrderMapper;
import com.geekbrains.spring.web.dto.OrderDetailsDto;
import com.geekbrains.spring.web.dto.OrderDto;
import com.geekbrains.spring.web.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
        //private final UserService userService;
        private final OrderService orderService;
        private final OrderConverter orderConverter;
        private final OrderMapper orderMapper;


//    @PostMapping("/{cartName}")
//    public void createOrder(Principal principal, @RequestBody OrderDetailsDto orderDetailsDto, @PathVariable String cartName){
//        User user = userService.findByUsername(principal.getName())
//                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//       orderService.createOrder(user, orderDetailsDto, cartName);
//    }

    @PostMapping("/{cartName}")
    public void createOrder(@RequestHeader String username, @RequestBody OrderDetailsDto orderDetailsDto, @PathVariable String cartName){
        orderService.createOrder(username, orderDetailsDto, cartName);
    }

//    @GetMapping
//    public List<OrderDto> getCurrentOrders(Principal principal){  // убрали Principal
//        return orderService.findOrdersByUsername(principal.getName()).stream()
//                //.map(orderConverter::entityToDto).collect(Collectors.toList());
//                .map(orderMapper::fromOrder).collect(Collectors.toList());
//    }

    @GetMapping
    public List<OrderDto> getCurrenUrders(@RequestHeader String username){
        return orderService.findOrdersByUsername(username).stream()
                //.map(orderConverter::entityToDto).collect(Collectors.toList());
                .map(orderMapper::fromOrder).collect(Collectors.toList());
    }
}


