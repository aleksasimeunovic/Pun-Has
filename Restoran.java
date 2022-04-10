package projekat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restoran {
    private String Naziv;
    private String Tip; //Kineski, francuski, italijanski... ne znam koji svi postoje zato nije u enum
    private ArrayList<Artikal> Meni; //
    private Lokacija Lokacija;

    public Restoran(String naziv, String tip, ArrayList<Artikal> meni, projekat.Lokacija lokacija) {
        Naziv = naziv;
        Tip = tip;
        Meni = meni;
        Lokacija = lokacija;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public ArrayList<Artikal> getMeni() {
        return Meni;
    }

    public void setMeni(ArrayList<Artikal> meni) {
        Meni = meni;
    }

    public projekat.Lokacija getLokacija() {
        return Lokacija;
    }

    public void setLokacija(projekat.Lokacija lokacija) {
        Lokacija = lokacija;
    }
}

