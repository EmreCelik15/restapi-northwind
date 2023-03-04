package com.restapi.northwind.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private CustomerDto customerDto;
    private EmployeeDto employeeDto;
    private ShipperDto shipperDto;
    private LocalDate orderDate;
    private Set<OrderDetailDto> orderDetailDto;
}
