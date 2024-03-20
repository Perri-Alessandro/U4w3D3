package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Enumerated(EnumType.STRING)
    public PartecipazioneType stato;
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
    }

    public PartecipazioneType getStato() {
        return stato;
    }

    public void setStato(PartecipazioneType stato) {
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "stato=" + stato +
                ", id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
