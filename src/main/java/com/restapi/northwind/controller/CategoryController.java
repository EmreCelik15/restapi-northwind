package com.restapi.northwind.controller;

import com.restapi.northwind.dto.CategoryRequestDto;
import com.restapi.northwind.dto.CategoryResponseDto;
import com.restapi.northwind.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Validated
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryRequestDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable("id") @Min(value = 1,
            message = "Id 1 değerinden büyük olmalıdır.") Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PutMapping("/update")
    public ResponseEntity<CategoryRequestDto> updateCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDto));
    }
    @GetMapping("/getcategoryname/{name}")
    public ResponseEntity<CategoryResponseDto> getCategoryName(@PathVariable(value = "name") @NotBlank String categoryName){
        return ResponseEntity.ok(categoryService.getCategoryName(categoryName));
    }
}
