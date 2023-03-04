package com.restapi.northwind.service;

import com.restapi.northwind.dto.SupplierDto;
import com.restapi.northwind.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    public SupplierService(SupplierRepository supplierRepository) {

        this.supplierRepository = supplierRepository;
    }
    public List<SupplierDto> getAll(){
        return null;
    }
}
