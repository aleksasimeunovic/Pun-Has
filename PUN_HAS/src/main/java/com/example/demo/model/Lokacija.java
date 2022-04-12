package com.example.demo.model;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {
    @Column
    private Point Pozicija;
    @Column
    private String Adresa;

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Lokacija(Point pozicija, String adresa) {
        Pozicija = pozicija;
        Adresa = adresa;
    }

    public Lokacija() {

    }

    public Point getPozicija() {
        return Pozicija;
    }

    public void setPozicija(Point pozicija) {
        Pozicija = pozicija;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    // private double Geosirina;
    // private double Geovisina;
}