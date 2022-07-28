/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonName {

    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Column(name = "sur_name", nullable = false)
    private String surName;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}