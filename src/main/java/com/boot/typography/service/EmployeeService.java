package com.boot.typography.service;

import com.boot.typography.model.Employee;
import com.boot.typography.dto.EmployeeDto;
import com.boot.typography.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DtoConversionService conversionService;

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return conversionService.convert(employees, EmployeeDto.class);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee entity = conversionService.convert(employeeDto, Employee.class);
        Employee result = employeeRepository.saveAndFlush(entity);
        return conversionService.convert(result, EmployeeDto.class);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee entity = conversionService.convert(employeeDto, Employee.class);
        Employee result = employeeRepository.saveAndFlush(entity);
        return conversionService.convert(result, EmployeeDto.class);
    }

    public EmployeeDto getEmployee(Integer id) {
        Employee result = employeeRepository.findById(id).orElseThrow();
        return conversionService.convert(result, EmployeeDto.class);

    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees(List<Integer> ids) {
        employeeRepository.deleteAllById(ids);

    }
}
