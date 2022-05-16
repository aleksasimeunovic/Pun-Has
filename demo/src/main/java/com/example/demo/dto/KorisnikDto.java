package com.example.demo.dto;

import com.example.demo.model.Korisnik;

import java.util.Date;

public class KorisnikDto {
    private String username,password,Ime,Prezime;
    private Korisnik.POLOVI pol;
    private Date datum;

    public KorisnikDto(Korisnik k){
        this.username = k.getUsername();
        this.password = k.getPassword();
        this.Ime = k.getIme();
        this.Prezime = k.getPrezime();
        this.pol = k.getPol();
        this.datum = new java.util.Date(System.currentTimeMillis());
    }
    public KorisnikDto(String username, String password, String Ime, String Prezime, Korisnik.POLOVI pol) {
        this.username = username;
        this.password = password;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.pol = pol;
        this.datum = new java.util.Date(System.currentTimeMillis());
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

    public String getName() {
        return Ime;
    }

    public void setName(String name) {
        this.Ime = name;
    }

    public String getLastName() {
        return Prezime;
    }

    public void setLastName(String lastName) {
        this.Prezime = lastName;
    }

    public Korisnik.POLOVI getPol() {
        return pol;
    }

    public void setPol(Korisnik.POLOVI pol) {
        this.pol = pol;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

}
