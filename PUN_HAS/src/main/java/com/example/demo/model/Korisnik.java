package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Korisnik {

    public Korisnik() {

    }
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    enum POLOVI  {Musko,Zensko};
    enum ULOGA {Admin,Menadzer,Dostavljac,Kupac};

    @Column
    protected String KorisnickoIme;
    @Column
    protected String Lozinka;
    @Column
    protected String Ime;
    @Column
    protected String Prezime;
    @Column
    protected POLOVI Pol;
    @Column
    protected Date Datum_rodjenja;
    @Column
    protected ULOGA Uloga;

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, POLOVI pol, Date datum_rodjena, ULOGA uloga) {
        KorisnickoIme = korisnickoIme;
        Lozinka = lozinka;
        Ime = ime;
        Prezime = prezime;
        Pol = pol;
        Datum_rodjenja = datum_rodjena;
        Uloga = uloga;
    }
    public Korisnik(Korisnik k){
        KorisnickoIme = k.KorisnickoIme;
        Lozinka = k.Lozinka;
        Ime = k.Ime;
        Prezime = k.Prezime;
        Pol = k.Pol;
        Datum_rodjenja = k.Datum_rodjenja;
        Uloga = k.Uloga;
    }

    public String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        KorisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public POLOVI getPol() {
        return Pol;
    }

    public void setPol(POLOVI pol) {
        Pol = pol;
    }

    public Date getDatum_rodjena() {
        return Datum_rodjenja;
    }

    public void setDatum_rodjena(Date datum_rodjena) {
        Datum_rodjenja = datum_rodjena;
    }

    public ULOGA getUloga() {
        return Uloga;
    }

    public void setUloga(ULOGA uloga) {
        Uloga = uloga;
    }
}