/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table()
public class PersonHumanResource extends Person {

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    @Column(name = "employed")
    private boolean employed;
}