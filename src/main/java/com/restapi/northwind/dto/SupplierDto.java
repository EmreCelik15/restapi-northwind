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
public class SupplierDto {
    private Long id;
    private String supplierName;
    private String contactName;
    private String adress;
    private String postalCode;
    private String country;
    private String phone;
    private Set<ProductDto> productDtos;
}
