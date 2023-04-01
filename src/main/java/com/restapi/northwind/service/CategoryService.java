package com.restapi.northwind.service;

import com.restapi.northwind.config.ModelMapperConfig;
import com.restapi.northwind.dto.CategoryConverter;
import com.restapi.northwind.dto.CategoryRequestDto;
import com.restapi.northwind.dto.CategoryResponseDto;
import com.restapi.northwind.dto.ProductConverter;
import com.restapi.northwind.entity.Category;
import com.restapi.northwind.exception.CategoryNotFoundException;
import com.restapi.northwind.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    public List<CategoryResponseDto> getAllCategory() {
        List<CategoryResponseDto> categoryResponseDtoList = categoryRepository.findAll().stream()
                .map(category -> categoryConverter.convertToResponseDto(category))
                .collect(Collectors.toList());
        return categoryResponseDtoList;
    }

    public CategoryRequestDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryConverter.convertToEntity(categoryRequestDto);
        categoryRepository.save(category);
        return categoryConverter.convertToRequestDto(category);
    }

    public CategoryResponseDto getCategoryById(Long id) {
        CategoryResponseDto categoryResponseDto = categoryConverter.
                convertToResponseDto(categoryRepository.findById(id)
                        .orElseThrow(() -> new CategoryNotFoundException("Category Not Found!")));
        return categoryResponseDto;
    }

    public CategoryResponseDto getCategoryName(String categoryName) {
        return categoryConverter.convertToResponseDto(categoryRepository.findCategoryByCategoryName(categoryName)
                .orElseThrow(()->new CategoryNotFoundException("Category Not Found!")));
    }
}
