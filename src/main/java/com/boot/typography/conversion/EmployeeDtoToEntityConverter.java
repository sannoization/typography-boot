package com.boot.typography.conversion;

import com.boot.typography.model.Employee;
import com.boot.typography.dto.EmployeeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEntityConverter implements Converter<EmployeeDto, Employee> {

    @Override
    public Employee convert(EmployeeDto source) {
        return Employee.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .phone(source.getPhone())
                .build();
    }
}
