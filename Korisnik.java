package projekat;

import java.util.Date;

public class Korisnik {

    enum POLOVI  {Musko,Zensko};
    enum ULOGA {Admin,Menadzer,Dostavljac,Kupac};

    protected String KorisnickoIme;
    protected String Lozinka;
    protected String Ime;
    protected String Prezime;
    protected POLOVI Pol;
    protected Date Datum_rodjena;
    protected ULOGA Uloga;

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, POLOVI pol, Date datum_rodjena, ULOGA uloga) {
        KorisnickoIme = korisnickoIme;
        Lozinka = lozinka;
        Ime = ime;
        Prezime = prezime;
        Pol = pol;
        Datum_rodjena = datum_rodjena;
        Uloga = uloga;
    }
    public Korisnik(Korisnik k){
        KorisnickoIme = k.KorisnickoIme;
        Lozinka = k.Lozinka;
        Ime = k.Ime;
        Prezime = k.Prezime;
        Pol = k.Pol;
        Datum_rodjena = k.Datum_rodjena;
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
        return Datum_rodjena;
    }

    public void setDatum_rodjena(Date datum_rodjena) {
        Datum_rodjena = datum_rodjena;
    }

    public ULOGA getUloga() {
        return Uloga;
    }

    public void setUloga(ULOGA uloga) {
        Uloga = uloga;
    }
}
