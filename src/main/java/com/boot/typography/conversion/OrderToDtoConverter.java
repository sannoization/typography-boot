package com.boot.typography.conversion;

import com.boot.typography.dto.OrderDto;
import com.boot.typography.model.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderToDtoConverter implements Converter<Order, OrderDto> {

    @Override
    public OrderDto convert(Order source) {
        return OrderDto.builder()
                .id(source.getId())
                .startDate(source.getDateStart().toString())
                .endDate(source.getDateEnd().toString())
                .employeeId(source.getEmployeeId())
                .goodsId(source.getGoodsId())
                .build();
    }
}