package com.kht.ecommerce_application.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String city;
    private String street;
    private int streetNumber;
    private String zipcode;
    private String geolocationLat;
    private String geolocationLong;
}
