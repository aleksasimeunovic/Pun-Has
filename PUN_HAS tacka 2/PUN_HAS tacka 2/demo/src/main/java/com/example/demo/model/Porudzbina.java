package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina {
    @Id
    private UUID UUID = java.util.UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Restoran restoranIKP; //iz kog je poruceno

    @Column(name = "Datum", nullable = false)
    private Date datum; //vreme je sadrzano u datumu pa ga ne moramo importovati.

    @Column(name = "Cena",nullable = false)
    private double Cena;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Kupac Kupac;

    enum STATUS {Obrada,Priprema,CekaDostavu,uTransportu, Dostavljena,Otkazana}
    @Enumerated(EnumType.ORDINAL)

    @Column(name = "Status",nullable = false)
    private STATUS Status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Artikal> listaArtikala = new HashSet<>();

    public Porudzbina(java.util.UUID UUID, Restoran restoranIKP, Date datum, double cena, Kupac kupac, STATUS status, Set<Artikal> listaArtikala) {
        this.UUID = UUID;
        this.restoranIKP = restoranIKP;
        this.datum = datum;
        Cena = cena;
        Kupac = kupac;
        Status = status;
        this.listaArtikala = listaArtikala;
    }

    public java.util.UUID getUUID() {
        return UUID;
    }

    public void setUUID(java.util.UUID UUID) {
        this.UUID = UUID;
    }

    public Restoran getRestoranIKP() {
        return restoranIKP;
    }

    public void setRestoranIKP(Restoran restoranIKP) {
        this.restoranIKP = restoranIKP;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(Kupac kupac) {
        Kupac = kupac;
    }

    public STATUS getStatus() {
        return Status;
    }

    public void setStatus(STATUS status) {
        Status = status;
    }

    public Set<Artikal> getListaArtikala() {
        return listaArtikala;
    }

    public void setListaArtikala(Set<Artikal> listaArtikala) {
        this.listaArtikala = listaArtikala;
    }
}