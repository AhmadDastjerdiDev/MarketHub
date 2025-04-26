package com.example.markethub1.product.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

        private Long productId;

        private String productName;

        private String productType;

        //private String producer;

        private Long price;
}
