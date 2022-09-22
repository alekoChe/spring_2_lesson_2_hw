package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.dto.OrderDto;
import com.geekbrains.spring.web.entities.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@RequiredArgsConstructor
@Mapper
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);


    @InheritInverseConfiguration
    OrderDto fromOrder(Order order);

    List<Order> toOrderList(List<OrderDto> orderDtos);

    List<OrderDto> fromOrderList(List<Order> orders);
}
