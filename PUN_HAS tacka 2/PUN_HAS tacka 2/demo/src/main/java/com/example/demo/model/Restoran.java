package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {
    @Column
    private String Naziv;
    @Column
    private String tip;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Artikal> Meni = new HashSet<>();
    @OneToOne()
    private Lokacija lokacija;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Restoran(String naziv, String tip, Set<Artikal> meni, Lokacija lokacija) {
        Naziv = naziv;
        this.tip = tip;
        Meni = meni;
        this.lokacija = lokacija;
    }
    public Restoran(String naziv,String tip){
        this.Naziv = naziv;
        this.tip = tip;
    }
    public Restoran(){}

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Set<Artikal> getMeni() {
        return Meni;
    }

    public void setMeni(Set<Artikal> meni) {
        Meni = meni;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}