package guru.springframework.spring6restmvc.mappers;

import guru.springframework.spring6restmvc.entities.BeerOrder;
import guru.springframework.spring6restmvc.entities.BeerOrderLine;
import guru.springframework.spring6restmvc.entities.BeerOrderShipment;
import guru.springframework.spring6restmvc.model.BeerOrderDTO;
import guru.springframework.spring6restmvc.model.BeerOrderLineDTO;
import guru.springframework.spring6restmvc.model.BeerOrderShipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BeerOrderMapper {

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderShipment beerOrderShipmentDtoToBeerOrderShipment(BeerOrderShipmentDTO beerOrderShipmentDTO);

    BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDto(BeerOrderShipment beerOrderShipment);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDTO beerOrderLineDTO);

    BeerOrderLineDTO beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine);

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDTO beerOrder);

    BeerOrderDTO beerOrderToBeerOrderDto(BeerOrder beerOrder);

}

/*
@Mapper
public interface BeerOrderMapper {

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDTO orderDto);

    BeerOrderDTO beerOrderToBeerOrderDTO(BeerOrder order);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDTO orderLineDto);

    BeerOrderLineDTO beerOrderLineToBeerOrderLineDto(BeerOrderLine orderLine);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderShipment beerOrderShipmentDtoToBeerOrderShipment(BeerOrderShipmentDTO orderShipmentDto);

    BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDto(BeerOrderShipment orderShipment);
}*/
