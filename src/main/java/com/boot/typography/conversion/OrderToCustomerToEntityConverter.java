package com.boot.typography.conversion;

import com.boot.typography.dto.OrderToCustomerDto;
import com.boot.typography.model.OrderToCustomer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderToCustomerToEntityConverter implements Converter<OrderToCustomerDto, OrderToCustomer> {

    @Override
    public OrderToCustomer convert(OrderToCustomerDto source) {
        return OrderToCustomer.builder()
                .customerId(source.getCustomerId())
                .orderId(source.getOrderId())
                .build();
    }
}
