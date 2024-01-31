package com.boot.typography.controller;

import com.boot.typography.dto.OrderToCustomerDto;
import com.boot.typography.service.OrderToCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlist")
@RequiredArgsConstructor
public class OrderToCustomerController {

    private final OrderToCustomerService service;

    @GetMapping
    public List<OrderToCustomerDto> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping(path = "/customer/{id}")
    public List<OrderToCustomerDto> getRecordByCustomerId(@PathVariable Integer id) {
        return service.getRecordByCustomerId(id);
    }

    @GetMapping(path = "/order/{id}")
    public List<OrderToCustomerDto> getRecordByOrderId(@PathVariable Integer id) {
        return service.getRecordByOrderId(id);
    }

    @GetMapping(path = "/{customerId}/{orderId}")
    public OrderToCustomerDto getRecordByAllIds(@PathVariable Integer customerId,
                                                          @PathVariable Integer orderId) {
        return service.getRecordByCustomerIdAndOrderId(customerId, orderId);
    }

    @PostMapping
    public OrderToCustomerDto createRecord(@RequestBody OrderToCustomerDto dto) {
        return service.createRelationShip(dto);
    }

    @DeleteMapping(path = "/order/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteByOrderId(@PathVariable Integer id) {
        service.deleteRecordByOrderId(id);
    }


    @DeleteMapping(path = "/customer/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteByCustomerId(@PathVariable Integer id) {
        service.deleteRecordByCustomerId(id);
    }

    @DeleteMapping(path = "/{customerId}/{orderId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteByBothIds(@PathVariable Integer customerId, @PathVariable Integer orderId) {
        service.deleteRecordByBothIds(customerId, orderId);
    }


}
