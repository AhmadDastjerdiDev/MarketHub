package com.example.markethub1.order.dto;

import com.example.markethub1.customer.entity.Customer;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

        private Long orderId;

        private Date date;

        private Integer orderCode;

        private Long totalPayable;

        private Customer receiver;

        private Long shippingCost;

        private Integer score;
}
