package com.algafood.algafood.domain.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRestaurantRequestDTO {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal shippingFee;
    @NotNull
    private Long kitchenId;
}
