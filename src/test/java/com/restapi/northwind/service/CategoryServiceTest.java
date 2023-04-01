package com.restapi.northwind.service;

import com.restapi.northwind.dto.CategoryConverter;
import com.restapi.northwind.dto.CategoryResponseDto;
import com.restapi.northwind.entity.Category;
import com.restapi.northwind.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author EmreÇelik
 * @Date 9.03.2023
 */
class CategoryServiceTest {
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;


    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryConverter = Mockito.mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository, categoryConverter);
    }
@DisplayName("should Return Category Response Dto List when Call Category Service Get All Category Method")
    @Test
    void shouldReturnAllCategoryResponseDtoElement_whenCallCategoryServiceGetAllCategoryMethod() {
        List<Category> categories=new ArrayList<>();
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<CategoryResponseDto> categoryResponseDtos = categoryService.getAllCategory();
        assertEquals(categoryResponseDtoList,categoryResponseDtos );
        Mockito.verify(categoryRepository).findAll();
    }

    @Test
    void createCategory() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void getCategoryName() {
    }
}