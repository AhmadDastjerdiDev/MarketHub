package com.example.markethub1.product.entity;

import com.example.markethub1.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_product_id")
    private Long productId;

    @Column(name = "c_customer_id")
    private Long customerId;

    @Column(name = "c_product_name")
    private String productName;

    @Column(name = "c_product_type")
    private String productType;

    //private String producer;

    @Column(name = "c_price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "c_order_id")
    private Order order;
}
