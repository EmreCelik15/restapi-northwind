package com.restapi.northwind.service;

import com.restapi.northwind.config.ModelMapperConfig;
import com.restapi.northwind.dto.OrderDto;
import com.restapi.northwind.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapperConfig modelMapperConfig;

    public OrderService(OrderRepository orderRepository, ModelMapperConfig modelMapperConfig) {
        this.orderRepository = orderRepository;
        this.modelMapperConfig = modelMapperConfig;
    }

    public List<OrderDto> getAll() {
        return null;
    }

    public OrderDto findById(Long id) {
        return null;
    }
}
