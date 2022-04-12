package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {
    @Column
    private String Naziv;
    @Column
    private String Tip; //Kineski, francuski, italijanski... ne znam koji svi postoje zato nije u enum
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Artikal> Meni = new HashSet<>();
    @OneToOne()
    private Lokacija Lokacija;

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Restoran(String naziv, String tip, Set<Artikal> meni, com.example.demo.model.Lokacija lokacija) {
        Naziv = naziv;
        Tip = tip;
        Meni = meni;
        Lokacija = lokacija;
    }
    public Restoran(String naziv,String tip){
        this.Naziv = naziv;
        this.Tip = tip;
    }

    public Restoran() {

    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public Set<Artikal> getMeni() {
        return Meni;
    }

    public void setMeni(Set<Artikal> meni) {
        Meni = meni;
    }

    public com.example.demo.model.Lokacija getLokacija() {
        return Lokacija;
    }

    public void setLokacija(com.example.demo.model.Lokacija lokacija) {
        Lokacija = lokacija;
    }
}
