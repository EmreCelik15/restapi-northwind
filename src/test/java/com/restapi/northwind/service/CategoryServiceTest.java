package com.restapi.northwind.service;

import com.restapi.northwind.dto.CategoryConverter;
import com.restapi.northwind.dto.CategoryRequestDto;
import com.restapi.northwind.dto.CategoryResponseDto;
import com.restapi.northwind.entity.Category;
import com.restapi.northwind.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.awt.*;
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
    void shouldCreateCategory_whenTakeCategoryRequestParameter() {
        Category category=new Category(1L,"categoryName","description",null);
        CategoryRequestDto expected=new CategoryRequestDto(1L,"categoryName","description");
        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(category);
        Mockito.when(categoryConverter.convertToEntity(expected)).thenReturn(category);
        Mockito.when(categoryConverter.convertToRequestDto(category)).thenReturn(expected);
        CategoryRequestDto categoryRequestDto=categoryService.createCategory(new CategoryRequestDto(1L,"categoryName","description"));
        assertEquals(categoryRequestDto,expected);
        Mockito.verify(categoryRepository).save(any(Category.class));
    }

    @Test
    void shouldReturnCategoryResponseDto_whenCategoryIdExist() {
        Long id= 2L;
        Category category=new Category(id,"categoryName","description",null);
        CategoryResponseDto expected=new CategoryResponseDto(id,"categoryName","description",null);
        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        Mockito.when(categoryConverter.convertToResponseDto(category)).thenReturn(expected);
        CategoryResponseDto result=categoryService.getCategoryById(id);
        assertEquals(result,expected);
        Mockito.verify(categoryRepository).findById(id);
    }

    @Test
    void shouldReturnCategoryResponseDto_whenCategoryNameExist() {
        String name= "categoryName";
        Category category=new Category(1L,"categoryName","description",null);
        CategoryResponseDto expected=new CategoryResponseDto(1L,"categoryName","description",null);
        Mockito.when(categoryRepository.findCategoryByCategoryName(name)).thenReturn(Optional.of(category));
        Mockito.when(categoryConverter.convertToResponseDto(category)).thenReturn(expected);
        CategoryResponseDto result=categoryService.getCategoryByName(name);
        assertEquals(result,expected);
        Mockito.verify(categoryRepository).findCategoryByCategoryName(name);
    }
}