package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    public long id;

    public String name;

    public String città;
    @OneToMany
    public List<Evento> eventi;

    public Location() {
    }

    public Location(String name, String città, List<Evento> eventi) {
        this.name = name;
        this.città = città;
        this.eventi = eventi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", città='" + città + '\'' +
                ", eventi=" + eventi +
                '}';
    }
}
