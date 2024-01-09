package com.boot.typography.conversion;

import com.boot.typography.dto.OrderDto;
import com.boot.typography.model.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderDtoToEntityConverter implements Converter<OrderDto, Order> {

    @Override
    public Order convert(OrderDto source) {
        return Order.builder()
                .id(source.getId())
                .dateStart(LocalDateTime.parse(source.getStartDate()))
                .dateEnd(LocalDateTime.parse(source.getEndDate()))
                .employeeId(source.getEmployeeId())
                .goodsId(source.getGoodsId())
                .build();
    }
}
