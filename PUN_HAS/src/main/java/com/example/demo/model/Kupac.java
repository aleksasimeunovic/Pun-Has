package com.example.demo.model;

import com.example.demo.model.Porudzbina;
import com.example.demo.model.TipKupca;

import javax.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Kupac extends Korisnik implements Serializable {
    @Column
    private int BrojSkupljenihBod;
    @OneToOne(mappedBy = "Kupac")
    private TipKupca Tip;


    @OneToMany(mappedBy = "Kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Porudzbina> listaPorudzbina = new HashSet<>();

    public Kupac(Korisnik k, Set<Porudzbina> listaPorudzbina, int BrojskupljenihBod, TipKupca tip){
        super(k);
        this.listaPorudzbina = listaPorudzbina;
        this.BrojSkupljenihBod = BrojskupljenihBod;
        this.Tip = tip;
    }

    public Kupac() {

    }

    public Set<Porudzbina> getListaPorudzbina() {
        return listaPorudzbina;
    }

    public void setListaPorudzbina(Set<Porudzbina> listaPorudzbina) {
        listaPorudzbina = listaPorudzbina;
    }

    public int getBrojSkupljenihBod() {
        return BrojSkupljenihBod;
    }

    public void setBrojSkupljenihBod(int brojSkupljenihBod) {
        BrojSkupljenihBod = brojSkupljenihBod;
    }

    public TipKupca getTip() {
        return Tip;
    }

    public void setTip(TipKupca tip) {
        Tip = tip;
    }
}