package com.restapi.northwind.dto;

import com.restapi.northwind.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Long id;
    private Order order;
    private ProductDto productDto;
    private Long quantity;
}
