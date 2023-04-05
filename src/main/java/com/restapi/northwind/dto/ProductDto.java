package com.restapi.northwind.dto;


import com.restapi.northwind.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Long supplierId;
    private CategoryRequestDto categoryRequestDto;
    private Set<OrderDetailDto> orderDetailDtos;
    private String unit;
    private BigDecimal price;
}
