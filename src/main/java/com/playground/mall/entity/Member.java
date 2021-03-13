package com.playground.mall.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    @Builder
    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
