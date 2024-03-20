package org.example.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Location;
import org.example.exceptions.NotFoundException;

public class LocationDAO {
    private final EntityManager em;
    
    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(location);

        tx.commit();

        System.out.println("LOCATION " + location.getName() + " SALVATA CORRETTAMENTE");
    }

    public Location getById(long id) {
        Location location = em.find(Location.class, id);
        if (location == null) throw new NotFoundException(id);
        return location;
    }

    public void delete(long id) {
        Location trovato = this.getById(id);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(trovato);

        tx.commit();

        System.out.println("PARTECIPAZIONE PER EVENTO " + trovato.getName() + " ELIMINATA CON SUCCESSO");
    }
}
