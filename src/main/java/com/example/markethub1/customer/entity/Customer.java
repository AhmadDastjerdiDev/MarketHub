package com.example.markethub1.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

import java.util.Date;


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
