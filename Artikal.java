package projekat;

public class Artikal {
    enum TIP {Jelo,pice};
    private String Naziv;
    private double Cena;
    private TIP Tip;
    private double Kolicina;
    private String opis;

    public Artikal(String naziv, double cena, TIP tip, double kolicina) {
        Naziv = naziv;
        Cena = cena;
        Tip = tip;
        Kolicina = kolicina;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public TIP getTip() {
        return Tip;
    }

    public void setTip(TIP tip) {
        Tip = tip;
    }

    public double getKolicina() {
        return Kolicina;
    }

    public void setKolicina(double kolicina) {
        Kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
