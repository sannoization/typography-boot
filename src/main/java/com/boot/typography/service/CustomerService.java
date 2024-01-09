package com.boot.typography.service;


import com.boot.typography.dto.CustomerDto;
import com.boot.typography.model.Customer;
import com.boot.typography.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final DtoConversionService conversionService;

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return conversionService.convert(customers, CustomerDto.class);
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer entity = conversionService.convert(customerDto, Customer.class);
        Customer result = customerRepository.saveAndFlush(entity);
        return conversionService.convert(result, CustomerDto.class);
    }

    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer found = customerRepository.findById(customerDto.getId()).orElseThrow();
        found.setFirstName(customerDto.getFirstName());
        found.setLastName(customerDto.getLastName());
        found.setEmail(customerDto.getEmail());
        found.setPhone(customerDto.getPhone());
        Customer result = customerRepository.saveAndFlush(found);
        return conversionService.convert(result, CustomerDto.class);
    }

    public CustomerDto getCustomer(Integer id) {
        Customer result = customerRepository.findById(id).orElseThrow();
        return conversionService.convert(result, CustomerDto.class);

    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomers(List<Integer> ids) {
        customerRepository.deleteAllById(ids);

    }


}
