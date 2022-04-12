package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {
    @OneToOne(mappedBy = "Komentar")
    private Kupac Kupac;
    @OneToOne(mappedBy = "Restoran")
    private Restoran Restoran;
    @Column
    private String Komentar;
    @Column
    private double Ocena;

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Komentar(Kupac kupac, Restoran restoran, double ocena) {
        Kupac = kupac;
        Restoran = restoran;
        Ocena = ocena;
    }

    public Komentar() {

    }

    public Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(Kupac kupac) {
        Kupac = kupac;
    }

    public Restoran getRestoran() {
        return Restoran;
    }

    public void setRestoran(Restoran restoran) {
        Restoran = restoran;
    }

    public String getKomentar() {
        return Komentar;
    }

    public void setKomentar(String komentar) {
        Komentar = komentar;
    }

    public double getOcena() {
        return Ocena;
    }

    public void setOcena(double ocena) {
        Ocena = ocena;
    }
}