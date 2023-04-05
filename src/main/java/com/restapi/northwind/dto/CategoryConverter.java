package com.restapi.northwind.dto;

import com.restapi.northwind.config.ModelMapperConfig;
import com.restapi.northwind.entity.Category;
import com.restapi.northwind.entity.OrderDetail;
import com.restapi.northwind.entity.Product;
import com.restapi.northwind.service.SupplierService;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CategoryConverter {
    private final ModelMapperConfig modelMapperConfig;
    private final ProductConverter productConverter;
    private final OrderDetailConverter orderDetailConverter;

    public CategoryConverter(ModelMapperConfig modelMapperConfig, ProductConverter productConverter, OrderDetailConverter orderDetailConverter) {

        this.modelMapperConfig = modelMapperConfig;
        this.productConverter = productConverter;
        this.orderDetailConverter = orderDetailConverter;
    }

    public CategoryResponseDto convertToResponseDto(Category category) {
        if (category == null) {
            return new CategoryResponseDto(null, "", "", null);
        }
        Set<ProductDto> productDto = category.getProducts().stream().
                map(product -> productConverter.convertToDto(product)).collect(Collectors.toSet());
        CategoryResponseDto categoryResponseDto = modelMapperConfig.getModelMapper().
                map(category, CategoryResponseDto.class);
        categoryResponseDto.setProductDtos(productDto);
        for (ProductDto productDto1 : categoryResponseDto.getProductDtos()) {
            for (Product product : category.getProducts()) {
                productDto1.setSupplierId(product.getSupplier().getId());
                productDto1.setCategoryRequestDto(convertToRequestDto(product.getCategory()));
                productDto1.setOrderDetailDtos(product.getOrderDetail().stream().
                        map(orderDetail -> orderDetailConverter.convertToDto(orderDetail)).collect(Collectors.toSet()));
            }
        }
        return categoryResponseDto;
    }

    public CategoryRequestDto convertToRequestDto(Category category) {
        if (category == null) {
            return new CategoryRequestDto(null, "", "");
        }
        CategoryRequestDto categoryRequestDto = modelMapperConfig.getModelMapper().map(category, CategoryRequestDto.class);
        return categoryRequestDto;
    }

    public Category convertToEntity(CategoryRequestDto categoryRequestDto) {
        if (categoryRequestDto == null) {
            return new Category(null, "", "", null);
        }
        Category category = modelMapperConfig.getModelMapper().map(categoryRequestDto, Category.class);
        return category;
    }

}
