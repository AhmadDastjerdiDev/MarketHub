package com.example.markethub1.order.entity;

import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @Column(name = "c_order_code")
    private Integer orderCode;

    @Column(name = "c_total_pay")
    private Long totalPayable;

    @Column(name = "c_shipping_cost")
    private Long shippingCost;

    @Column(name = "c_score")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "c_customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "tbl_order_product",
    joinColumns = @JoinColumn(name = "c_order_id"),
    inverseJoinColumns = @JoinColumn(name = "c_product_id"))
    private List<Product> products;
}
