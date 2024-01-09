package com.boot.typography.service;


import com.boot.typography.dto.OrderDto;
import com.boot.typography.model.Order;
import com.boot.typography.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final DtoConversionService conversionService;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return conversionService.convert(orders, OrderDto.class);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order entity = conversionService.convert(orderDto, Order.class);
        Order result = orderRepository.saveAndFlush(entity);
        return conversionService.convert(result, OrderDto.class);
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        Order found = orderRepository.findById(orderDto.getId()).orElseThrow();
        found.setDateStart(LocalDateTime.parse(orderDto.getStartDate()));
        found.setDateEnd(LocalDateTime.parse(orderDto.getEndDate()));
        found.setEmployeeId(orderDto.getEmployeeId());
        found.setGoodsId(orderDto.getGoodsId());
        Order result = orderRepository.saveAndFlush(found);
        return conversionService.convert(result, OrderDto.class);
    }

    public OrderDto getOrder(Integer id) {
        Order result = orderRepository.findById(id).orElseThrow();
        return conversionService.convert(result, OrderDto.class);

    }

    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }

    public void deleteAllOrders(List<Integer> ids) {
        orderRepository.deleteAllById(ids);

    }


}
