package projekat;

import java.awt.*;

public class Lokacija {
    private Point Pozicija;
    private String Adresa;

    public Lokacija(Point pozicija, String adresa) {
        Pozicija = pozicija;
        Adresa = adresa;
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
