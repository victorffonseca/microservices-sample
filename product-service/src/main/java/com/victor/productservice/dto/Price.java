package com.victor.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private Long id;
    private Long productId;
    private Integer originalPrice;
    private Integer discountedPrice;
}
