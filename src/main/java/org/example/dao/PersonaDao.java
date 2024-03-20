package org.example.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Persona;
import org.example.exceptions.NotFoundException;

public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(persona);

        tx.commit();

        System.out.println("PERSONA " + persona.getName() + persona.getSurname() + " SALVATA CORRETTAMENTE");
    }

    public Persona getById(long id) {
        Persona persona = em.find(Persona.class, id);
        if (persona == null) throw new NotFoundException(id);
        return persona;
    }

    public void delete(long id) {
        Persona persona = this.getById(id);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(persona);

        tx.commit();

        System.out.println("PERSONA " + persona.getName() + persona.getSurname() + " ELIMINATA CON SUCCESSO");
    }
}
