/*
 * Copyright (c) 2022. GDIT Proprietary
 */

package com.gdit.accounts;

import com.gdit.accounts.model.Person;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Component
@Path("/accounts")
@Transactional
public class AccountsService {

    @Inject
    EntityManager em;

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> get() {
        var query = em.createQuery("select p from Person p");
        List<Person> resultList = (List<Person>) query.getResultList();
        for (Person p: resultList) {
            p.getAddresses().size();
        }

        return resultList;
    }

    @GET
    @Path("/person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional

    public Person get(@PathParam("id") UUID id) {
        var query = em.createQuery("select p from Person p where p.id = ?1");
        query.setParameter(1, id);
        Person result = (Person) query.getSingleResult();
        result.getAddresses().size();

        return result;
    }

    @PUT
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String put(Person p) {
        em.persist(p);
        return p.getId().toString();
    }

    @POST
    @Path("/person/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Person p, @PathParam("id") UUID id) {
        var query = em.createQuery("select p from Person p where p.id = ?1");
        query.setParameter(1, id);
        var pold = (Person) query.getSingleResult();
        pold.getName().setGivenName(p.getName().getGivenName());
    }



}