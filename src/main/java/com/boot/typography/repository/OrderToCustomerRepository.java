package com.boot.typography.repository;

import com.boot.typography.model.OrderToCustomer;
import com.boot.typography.model.OrderToCustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderToCustomerRepository extends JpaRepository<OrderToCustomer, OrderToCustomerId> {

    @Modifying
    void deleteByCustomerId(Integer customerId);
    @Modifying
    void deleteByOrderId(Integer orderId);

    @Modifying
    void deleteByCustomerIdAndOrderId(Integer customerId, Integer orderId);

    List<OrderToCustomer> findOrderToCustomerByCustomerId(Integer customerId);

    List<OrderToCustomer> findAllByCustomerId(Integer customerId);

    List<OrderToCustomer> findAllByOrderId(Integer orderId);

    OrderToCustomer findOrderToCustomerByCustomerIdAndOrderId(Integer customerId, Integer orderId);

}
