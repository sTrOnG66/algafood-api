package com.algafood.algafood.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRestaurantRequestDTO {
    private String name;
        private BigDecimal shippingFee;
    private Long kitchenId;
}
