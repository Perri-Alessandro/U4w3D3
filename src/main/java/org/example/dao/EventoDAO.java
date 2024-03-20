package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Evento;
import org.example.exceptions.NotFoundException;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(evento);

        tx.commit();

        System.out.println("EVENTO " + evento.getTitolo() + " SALVATO CORRETTAMENTE");
    }

    public Evento getById(long id) {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) throw new NotFoundException(id);
        return evento;
    }

    public void delete(long id) {
        Evento trovato = this.getById(id);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(trovato);

        tx.commit();

        System.out.println("EVENTO " + trovato.getTitolo() + " ELIMINATO CON SUCCESSO");
    }
}
