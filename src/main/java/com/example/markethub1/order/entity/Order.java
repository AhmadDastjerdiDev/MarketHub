package com.example.markethub1.order.entity;

import com.example.markethub1.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_order")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_order_id")
    private Long orderId;

    @Column(name = "c_date")
    private Date date;

    @Column(name = "c_order_code")
    private Integer orderCode;

    @Column(name = "c_total_pay")
    private Long totalPayable;

    @Transient
    private Customer receiver;

    @Column(name = "c_shipping_cost")
    private Long shippingCost;

    @Column(name = "c_score")
    private Integer score;
}
