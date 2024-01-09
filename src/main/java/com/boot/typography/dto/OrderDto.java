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
public class OrderDto {

    private Integer id;

    @JsonProperty(value = "start_date")
    private String startDate;
    @JsonProperty(value = "end_date")
    private String endDate;
    @JsonProperty(value = "employee_id")
    private Integer employeeId;
    @JsonProperty(value = "goods_id")
    private Integer goodsId;

}
