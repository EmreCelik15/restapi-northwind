package com.restapi.northwind.controller;

import com.restapi.northwind.dto.SupplierDto;
import com.restapi.northwind.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @GetMapping("/getall")
    public ResponseEntity<List<SupplierDto>> getAll(){
        return ResponseEntity.ok(supplierService.getAll());
    }
}
