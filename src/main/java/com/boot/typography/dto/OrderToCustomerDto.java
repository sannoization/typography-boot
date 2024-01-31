package com.boot.typography.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderToCustomerDto {

    @JsonProperty(value = "customer_id")
    private Integer customerId;

    @JsonProperty(value = "order_id")
    private Integer orderId;


}
