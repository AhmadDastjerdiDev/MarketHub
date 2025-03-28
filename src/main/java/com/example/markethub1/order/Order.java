package com.example.markethub1.order;

import com.example.markethub1.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
    private Date date;
    private Integer orderCode;
    private Long totalPayable;
    private Customer receiver;
    private Long shippingCost;
    private Integer score;
}
