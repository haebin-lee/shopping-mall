package com.playground.mall.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@MappedSuperclass
public class BaseEntity {

    private Date createDate;
    private Date lastModifiedDate;
}
