package org.example.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Partecipazione;
import org.example.exceptions.NotFoundException;

public class PartecipazioneDao {
    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(partecipazione);

        tx.commit();

        System.out.println("PARTECIPAZIONE PER " + partecipazione.getEvento() + " SALVATA CORRETTAMENTE");
    }

    public Partecipazione getById(long id) {
        Partecipazione evento = em.find(Partecipazione.class, id);
        if (evento == null) throw new NotFoundException(id);
        return evento;
    }

    public void delete(long id) {
        Partecipazione trovato = this.getById(id);

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.remove(trovato);

        tx.commit();

        System.out.println("PARTECIPAZIONE PER EVENTO " + trovato.getEvento() + " ELIMINATA CON SUCCESSO");
    }
}
