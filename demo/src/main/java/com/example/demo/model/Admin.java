package com.example.demo.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Admin extends Korisnik {
    public Admin(Korisnik k){
        super(k);
    }
    public Admin(String username,String password,String name,String LastName,POLOVI pol, Date datum,ULOGA uloga){
        this.username = username;
        this.password = password;
        this.Ime = name;
        this.Prezime = LastName;
        this.Pol = pol;
        this.Datum_rodjenja = datum;
        this.Uloga = uloga;
    }
    public Admin(){
        super();
    }
}