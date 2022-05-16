package com.example.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "KorisnickoIme",nullable = false,unique = true)
    protected String username;

    @Column(name = "Lozinka")
    protected String password;

    @Column(name = "Ime")
    protected String Ime;

    @Column(name = "Prezime")
    protected String Prezime;

    public enum POLOVI {Musko,Zensko};
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Pol")
    protected POLOVI Pol;

    @Temporal(TemporalType.DATE)
    protected Date Datum_rodjenja;

    public enum ULOGA {Admin,Menadzer,Dostavljac,Kupac}
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Uloga")
    protected ULOGA Uloga;

    public Korisnik(){}

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, POLOVI Pol, Date datum_rodjenja, ULOGA uloga) {
        this.username = korisnickoIme;
        this.password = lozinka;
        this.Ime = ime;
        this.Prezime = prezime;
        this.Pol = Pol;
        this.Datum_rodjenja = datum_rodjenja;
        this.Uloga = uloga;
    }
    public Korisnik(Korisnik k){
        this.username = k.username;
        this.Datum_rodjenja = k.Datum_rodjenja;
        this.Ime = k.Ime;
        this.Prezime = k.Prezime;
        this.password = k.password;
        this.Pol = k.Pol;
        this.Uloga = k.Uloga;
    }
    public Korisnik(String username, String password){
        this.username = username;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDatum_rodjenja() {
        return Datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        Datum_rodjenja = datum_rodjenja;
    }

    public ULOGA getUloga() {
        return Uloga;
    }

    public void setUloga(ULOGA uloga) {
        Uloga = uloga;
    }
}