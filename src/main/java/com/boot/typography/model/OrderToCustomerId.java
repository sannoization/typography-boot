package com.boot.typography.model;

import lombok.*;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderToCustomerId implements Serializable {
    private Integer customerId;

    private Integer orderId;
}
