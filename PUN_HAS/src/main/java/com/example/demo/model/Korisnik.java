package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KorisnickoIme", nullable = false)
    protected String KorisnickoIme;

    @Column(name ="Lozinka", nullable = false)
    protected String Lozinka;

    @Column(name="Ime", nullable = false)
    protected String Ime;

    @Column(name="Prezime", nullable = false)
    protected String Prezime;

    public enum POLOVI  {Musko,Zensko};
    @Enumerated(EnumType.ORDINAL)

    @Column(name = "Pol", nullable = false)
    protected POLOVI Pol;

    @Temporal(TemporalType.DATE)
    protected Date Datum_rodjenja;

   public enum ULOGA {Admin,Menadzer,Dostavljac,Kupac};
    @Enumerated(EnumType.ORDINAL)

    @Column(name = "Uloga", nullable = false)
    protected ULOGA Uloga;

    public Korisnik() {

    }

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, POLOVI pol, Date datum_rodjena, ULOGA uloga) {
        this.KorisnickoIme = korisnickoIme;
        this.Lozinka = lozinka;
        this.Ime = ime;
        this.Prezime = prezime;
        this.Pol = pol;
        this.Datum_rodjenja = datum_rodjena;
        this.Uloga = uloga;
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
        this.KorisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        this.Lozinka = lozinka;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        this.Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        this.Prezime = prezime;
    }

    public POLOVI getPol() {
        return Pol;
    }

    public void setPol(POLOVI pol) {
        this.Pol = pol;
    }

    public Date getDatum_rodjena() {
        return Datum_rodjenja;
    }

    public void setDatum_rodjena(Date datum_rodjena) {
        this.Datum_rodjenja = datum_rodjena;
    }

    public ULOGA getUloga() {
        return Uloga;
    }

    public void setUloga(ULOGA uloga) {
        this.Uloga = uloga;
    }
}