package com.restapi.northwind.controller;

import com.restapi.northwind.dto.ShipperDto;
import com.restapi.northwind.service.ShipperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shipper")
public class ShipperController {
    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }
    @GetMapping("/getall")
    public ResponseEntity<List<ShipperDto>> getAll(){
        return ResponseEntity.ok(shipperService.getAll());
    }
}
