/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "street", nullable = false)
    private String street;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}