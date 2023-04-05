package com.restapi.northwind.service;

import com.restapi.northwind.dto.SupplierConverter;
import com.restapi.northwind.dto.SupplierDto;
import com.restapi.northwind.exception.CategoryNotFoundException;
import com.restapi.northwind.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierConverter supplierConverter;
    public SupplierService(SupplierRepository supplierRepository, SupplierConverter supplierConverter) {

        this.supplierRepository = supplierRepository;
        this.supplierConverter = supplierConverter;
    }
    public List<SupplierDto> getAll(){
        return null;
    }
    public SupplierDto getSupplierById(Long id) {
        SupplierDto supplierDto = supplierConverter.
                convertToDto(supplierRepository.findById(id)
                        .orElseThrow(() -> new CategoryNotFoundException("Category Not Found!")));
        return supplierDto;
    }
}
