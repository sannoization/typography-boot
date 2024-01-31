package com.boot.typography.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "order_to_customer", schema = "typography")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@IdClass(OrderToCustomerId.class)
public class OrderToCustomer implements Serializable {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @Id
    @Column(name = "order_id")
    private Integer orderId;


}
