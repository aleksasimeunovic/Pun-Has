package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artikal {
    public Artikal() {

    }
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum TIP {Jelo,Pice};
    @Enumerated(EnumType.ORDINAL)

    @Column(name = "Tip", nullable = false)
    private TIP Tip;

    @Column(name = "Naziv", nullable = false)
    private String Naziv;

    @Column(name = "Cena", nullable = false)
    private double Cena;

    @Column(name = "Kolicina", nullable = false)
    private double Kolicina;

    @Column(name = "Opis")
    private String Opis;

    public Artikal(String naziv, double cena, TIP tip, double kolicina) {
        Naziv = naziv;
        Cena = cena;
        Tip = tip;
        Kolicina = kolicina;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public TIP getTip() {
        return Tip;
    }

    public void setTip(TIP tip) {
        Tip = tip;
    }

    public double getKolicina() {
        return Kolicina;
    }

    public void setKolicina(double kolicina) {
        Kolicina = kolicina;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        this.Opis = opis;
    }
}