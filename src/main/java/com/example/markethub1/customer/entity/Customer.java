package com.example.markethub1.customer.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private Long id;

    @Column(name = "c_fullName")
    private String fullName;

    @Column(name = "c_SNS")
    private String SNS;

    @Column(name = "c_phoneMumber")
    private String phoneNumber;

    @Column(name = "c_email")
    private String email;

    @Column(name = "c_job")
    private String job;

    @Column(name = "c_birthday")
    private Date birthday;

    @Column(name = "c_address")
    private String address;

    @Column(name = "c_postalCode")
    private String postalCode;

}
