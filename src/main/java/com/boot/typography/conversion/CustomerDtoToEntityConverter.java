package com.boot.typography.conversion;

import com.boot.typography.data.Customer;
import com.boot.typography.dto.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToEntityConverter implements Converter<CustomerDto, Customer> {

    @Override
    public Customer convert(CustomerDto source) {
        return Customer.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .phone(source.getPhone())
                .build();
    }
}
