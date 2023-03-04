package com.restapi.northwind.dto;

import com.restapi.northwind.config.ModelMapperConfig;
import com.restapi.northwind.entity.Shipper;
import org.springframework.stereotype.Component;

@Component
public class ShipperConverter {
    private final ModelMapperConfig modelMapperConfig;

    public ShipperConverter(ModelMapperConfig modelMapperConfig) {

        this.modelMapperConfig = modelMapperConfig;
    }

    public ShipperDto convertToDto(Shipper shipper) {
        if (shipper == null) {
            return new ShipperDto(null,null, "", null);
        }
        ShipperDto shipperDto = modelMapperConfig.getModelMapper().map(shipper, ShipperDto.class);
        return shipperDto;
    }

    public Shipper convertToEntity(ShipperDto shipperDto) {
        if (shipperDto == null) {
            return new Shipper(null, "", "", null);
        }
        Shipper shipper = modelMapperConfig.getModelMapper().map(shipperDto, Shipper.class);
        return shipper;
    }
}
