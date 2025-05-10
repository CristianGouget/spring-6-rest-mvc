package guru.springframework.spring6restmvc.model;

import guru.springframework.spring6restmvc.entities.BeerOrder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@Data
public class BeerOrderLineDTO {

    private UUID id;

    private Long version;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer orderQuantity;

    private Integer quantityAllocated;

    private BeerDTO beer;

    //private BeerOrder beerOrder;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    private BeerOrderLineStatus orderLineStatus;
}