package com.example.demo.model;

import javax.persistence.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Porudzbina {
    public Porudzbina() {

    }
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restoran RestoranIKP; //iz kog poruceno
    @Column
    private Date Datum;
    @Column
    private Time Vreme;
    @Column
    private double Cena;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Kupac Kupac;
    enum STATUS {Obrada, Priprema, CekaDostavu, uTransportu, Dostavljena, Otkazana}
    @Enumerated(EnumType.ORDINAL)
    @Column
    private STATUS Status;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Artikal> listArtikala = new HashSet<>();

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Dostavljac dostavljac;*/

    public Porudzbina(Long UUID, Set<Artikal> listArtikala, Restoran restoranIKP, Date datum, Time vreme, double cena, com.example.demo.model.Kupac kupac, STATUS status) {
        this.UUID = UUID;
        this.listArtikala = listArtikala;
        RestoranIKP = restoranIKP;
        Datum = datum;
        Vreme = vreme;
        Cena = cena;
        Kupac = kupac;
        Status = status;
    }

    public Long getUUID() {
        return UUID;
    }

    public void setUUID(Long UUID) {
        this.UUID = UUID;
    }

    public Set<Artikal> getPoruceniArtikli() {
        return listArtikala;
    }

    public void setPoruceniArtikli(Set<Artikal> poruceniArtikli) {
        listArtikala = poruceniArtikli;
    }

    public Restoran getRestoranIKP() {
        return RestoranIKP;
    }

    public void setRestoranIKP(Restoran restoranIKP) {
        RestoranIKP = restoranIKP;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public Time getVreme() {
        return Vreme;
    }

    public void setVreme(Time vreme) {
        Vreme = vreme;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public com.example.demo.model.Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(com.example.demo.model.Kupac kupac) {
        Kupac = kupac;
    }

    public STATUS getStatus() {
        return Status;
    }

    public void setStatus(STATUS status) {
        Status = status;
    }
}
