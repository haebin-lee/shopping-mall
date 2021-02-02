package com.playground.mall.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String userName;

    private String city;

    private String street;

    private String zipCode;
}
