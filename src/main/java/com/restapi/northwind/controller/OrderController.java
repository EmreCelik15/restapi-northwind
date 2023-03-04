package com.restapi.northwind.controller;

import com.restapi.northwind.dto.OrderDto;
import com.restapi.northwind.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/getall")
    public ResponseEntity<List<OrderDto>> getall(){
        return ResponseEntity.ok(orderService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }
}
