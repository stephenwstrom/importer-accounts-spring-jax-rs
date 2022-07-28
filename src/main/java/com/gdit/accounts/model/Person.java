/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person extends BaseEntity implements PersonInterface {


    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Override
    public PersonName getName() {
        return name;
    }

    @Override
    public void setName(PersonName name) {
        this.name = name;
    }

    @Embedded
    PersonName name;

    @ManyToMany(/* fetch = FetchType.EAGER */)
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new LinkedHashSet<>();





    @Override
    public Set<Address> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }




}