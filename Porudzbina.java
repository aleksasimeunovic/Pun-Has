package projekat;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Porudzbina {
    enum STATUS {Obrada, Priprema, CekaDostavu, uTransportu, Dostavljena, Otkazana}
    private String UUID;
    private ArrayList<Artikal> PoruceniArtikli;
    private Restoran RestoranIKP; //iz kog poruceno
    private Date Datum;
    private Time Vreme;
    private double Cena;
    private Kupac Kupac;
    private STATUS Status;

    public Porudzbina(String UUID, ArrayList<Artikal> poruceniArtikli, Restoran restoranIKP, Date datum, Time vreme, double cena, projekat.Kupac kupac, STATUS status) {
        this.UUID = UUID;
        PoruceniArtikli = poruceniArtikli;
        RestoranIKP = restoranIKP;
        Datum = datum;
        Vreme = vreme;
        Cena = cena;
        Kupac = kupac;
        Status = status;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public ArrayList<Artikal> getPoruceniArtikli() {
        return PoruceniArtikli;
    }

    public void setPoruceniArtikli(ArrayList<Artikal> poruceniArtikli) {
        PoruceniArtikli = poruceniArtikli;
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

    public projekat.Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(projekat.Kupac kupac) {
        Kupac = kupac;
    }

    public STATUS getStatus() {
        return Status;
    }

    public void setStatus(STATUS status) {
        Status = status;
    }
}
