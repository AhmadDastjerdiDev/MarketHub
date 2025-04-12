package com.example.markethub1.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

        private Long productId;

        private String productName;

        private String productType;

        //private String producer;

        private Long price;
}
