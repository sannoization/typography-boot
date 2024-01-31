package com.boot.typography.conversion;

import com.boot.typography.dto.OrderToCustomerDto;
import com.boot.typography.model.OrderToCustomer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderToCustomerToDtoConverter implements Converter<OrderToCustomer, OrderToCustomerDto> {

    @Override
    public OrderToCustomerDto convert(OrderToCustomer source) {
        return OrderToCustomerDto.builder()
                .customerId(source.getCustomerId())
                .orderId(source.getOrderId())
                .build();
    }
}