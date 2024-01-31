package com.boot.typography.service;

import com.boot.typography.dto.OrderToCustomerDto;
import com.boot.typography.model.OrderToCustomer;
import com.boot.typography.repository.OrderToCustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderToCustomerService {

    private final OrderToCustomerRepository orderToCustomerRepository;
    private final DtoConversionService conversionService;

    public List<OrderToCustomerDto> getAllRecords() {
        List<OrderToCustomer> records = orderToCustomerRepository.findAll();
        return conversionService.convert(records, OrderToCustomerDto.class);
    }

    public OrderToCustomerDto createRelationShip(OrderToCustomerDto dto) {
        OrderToCustomer entity = conversionService.convert(dto, OrderToCustomer.class);
        OrderToCustomer result = orderToCustomerRepository.saveAndFlush(entity);
        return conversionService.convert(result, OrderToCustomerDto.class);
    }

    public List<OrderToCustomerDto> getRecordByCustomerId(Integer customerId) {
        List<OrderToCustomer> result = orderToCustomerRepository.findAllByCustomerId(customerId);
        return conversionService.convert(result, OrderToCustomerDto.class);

    }

    public List<OrderToCustomerDto> getRecordByOrderId(Integer orderId) {
        List<OrderToCustomer> result = orderToCustomerRepository.findAllByOrderId(orderId);
        return conversionService.convert(result, OrderToCustomerDto.class);
    }

    public OrderToCustomerDto getRecordByCustomerIdAndOrderId(Integer customerId, Integer orderId) {
        OrderToCustomer result = orderToCustomerRepository.findOrderToCustomerByCustomerIdAndOrderId(customerId, orderId);
        return conversionService.convert(result, OrderToCustomerDto.class);
    }

    @Transactional
    public void deleteRecordByCustomerId(Integer customerId) {
        orderToCustomerRepository.deleteByCustomerId(customerId);
    }

    @Transactional
    public void deleteRecordByOrderId(Integer orderId) {
        orderToCustomerRepository.deleteByOrderId(orderId);
    }

    @Transactional
    public void deleteRecordByBothIds(Integer customerId, Integer orderId) {
        orderToCustomerRepository.deleteByCustomerIdAndOrderId(customerId, orderId);
    }

}
