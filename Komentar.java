package projekat;

public class Komentar {
    private Kupac Kupac;
    private Restoran Restoran;
    private String Komentar;
    private double Ocena;

    public Komentar(projekat.Kupac kupac, projekat.Restoran restoran, double ocena) {
        Kupac = kupac;
        Restoran = restoran;
        Ocena = ocena;
    }

    public projekat.Kupac getKupac() {
        return Kupac;
    }

    public void setKupac(projekat.Kupac kupac) {
        Kupac = kupac;
    }

    public projekat.Restoran getRestoran() {
        return Restoran;
    }

    public void setRestoran(projekat.Restoran restoran) {
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
