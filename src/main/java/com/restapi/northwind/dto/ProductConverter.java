package com.restapi.northwind.dto;

import com.restapi.northwind.config.ModelMapperConfig;
import com.restapi.northwind.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private final ModelMapperConfig modelMapperConfig;
    public ProductConverter(ModelMapperConfig modelMapperConfig) {

        this.modelMapperConfig = modelMapperConfig;
    }

    public ProductDto convertToDto(Product product) {
        if(product==null){
            return new ProductDto(null,"",null,null,null,null,null);
        }
        ProductDto productDto = modelMapperConfig.getModelMapper().map(product, ProductDto.class);
        return productDto;
    }

    public Product convertToEntity(ProductDto productDto) {
        if(productDto==null){
            return new Product(null,"",null,null,null,null,null);
        }
        Product product = modelMapperConfig.getModelMapper().map(productDto, Product.class);
        return product;
    }
}
