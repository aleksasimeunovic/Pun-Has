package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Artikal {
    public Artikal(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Tip {Jelo,Pice}
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Tip",nullable = false)
    private Tip Tip;

    @Column(name = "Naziv",nullable = false)
    private String naziv;

    @Column(name = "Cena",nullable = false)
    private double Cena;

    @Column(name = "Kolicina", nullable = false)
    private double Kolicina;

    @Column(name = "Opis")
    private String Opis;

    public Artikal(Artikal.Tip tip, String naziv, double cena, double kolicina) {
        Tip = tip;
        this.naziv = naziv;
        Cena = cena;
        Kolicina = kolicina;
    }

    public Artikal.Tip getTip() {
        return Tip;
    }

    public void setTip(Artikal.Tip tip) {
        Tip = tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
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
        Opis = opis;
    }
}