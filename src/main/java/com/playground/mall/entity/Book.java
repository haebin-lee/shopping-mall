package com.playground.mall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("B")
public class Book extends Item{

    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }
}
