/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;
import java.util.UUID;

public interface PersonInterface {
    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    UUID getId();

    void setId(UUID id);

    Integer getVersion();

    public PersonName getName();

    public void setName(PersonName name);

    Set<Address> getAddresses();

    void setAddresses(Set<Address> addresses);

    default Period age(){
        var now = LocalDate.now();
        var period = Period.between(getBirthDate(), now);

        return period;
    }
}
