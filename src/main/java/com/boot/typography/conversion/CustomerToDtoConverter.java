package com.boot.typography.conversion;

import com.boot.typography.model.Customer;
import com.boot.typography.dto.CustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToDtoConverter implements Converter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer source) {
        return CustomerDto.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .build();
    }
}
