package com.restapi.northwind.service;

import com.restapi.northwind.dto.ShipperDto;
import com.restapi.northwind.repository.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {
    private final ShipperRepository shipperRepository;
    public ShipperService(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    public List<ShipperDto> getAll() {
        return null;
    }
}
