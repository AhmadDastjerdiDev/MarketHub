package com.example.markethub1.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer {
    private Long id;
    private String fullName;
    private String SNS;
    private String phoneNumber;
    private String email;
    private String job;
    private Date birthday;
    private String address;
    private String postalCode;
    private List myFavorites;



}
