package com.restapi.northwind.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipperDto {
    private Long id;
    private String shipperName;
    private String phone;
    private Set<OrderDto> orderDtos;
}
