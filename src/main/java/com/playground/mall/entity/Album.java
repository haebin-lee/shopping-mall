package com.playground.mall.entity;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item{

    private String artist;
    private String etc;
}
