package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipKupca implements Serializable {
    @Column
    private String Ime;
    @Column
    private int Popust;
    @Column
    private int TrazeniBrB;

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public TipKupca(String ime, int popust, int trazeniBrB) {
        this.Ime = ime;
        Popust = popust;
        TrazeniBrB = trazeniBrB;
    }

    public TipKupca() {

    }

    private Long id;
    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        this.Ime = ime;
    }

    public int getPopust() {
        return Popust;
    }

    public void setPopust(int popust) {
        Popust = popust;
    }

    public int getTrazeniBrB() {
        return TrazeniBrB;
    }

    public void setTrazeniBrB(int trazeniBrB) {
        TrazeniBrB = trazeniBrB;
    }
}
