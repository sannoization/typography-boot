package com.boot.typography.conversion;
import com.boot.typography.model.Employee;
import com.boot.typography.dto.EmployeeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToDtoConverter implements Converter<Employee, EmployeeDto> {

    @Override
    public EmployeeDto convert(Employee source) {
        return EmployeeDto.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .phone(source.getPhone())
                .email(source.getEmail())
                .build();
    }
}
