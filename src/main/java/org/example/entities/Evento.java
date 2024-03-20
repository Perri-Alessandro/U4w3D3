package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue
    public long id;

    public String titolo;

    public LocalDate data;

    public String descrizione;

    @Enumerated(EnumType.STRING)
    public EventoType tipoEvento;

    public long maxPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    public List<Partecipazione> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id")
    public Location location;

    public Evento() {
    }

    public Evento(String titolo, LocalDate data, String descrizione, long maxPartecipanti, EventoType tipoEvento, List<Partecipazione> partecipazioni, Location location) {
        this.data = data;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.maxPartecipanti = maxPartecipanti;
        this.tipoEvento = tipoEvento;
        this.partecipazioni = partecipazioni;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EventoType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(EventoType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public long getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setMaxPartecipanti(long maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPartecipanti=" + maxPartecipanti +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}
