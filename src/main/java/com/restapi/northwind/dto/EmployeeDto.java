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
public class EmployeeDto {
    private Long id;
    private String customerName;
    private String contactName;
    private String birthDate;
    private String photo;
    private String note;
    private Set<OrderDto> orderDtos;
}
