package projekat;

public class TipKupca {
    private String ime;
    private int Popust;
    private int TrazeniBrB;

    public TipKupca(String ime, int popust, int trazeniBrB) {
        this.ime = ime;
        Popust = popust;
        TrazeniBrB = trazeniBrB;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getPopust() {
        return Popust;
    }

    public void setPopust(int popust) {
        Popust = popust;
    }

    public int getTrazeniBrB() {
        return TrazeniBrB;
    }

    public void setTrazeniBrB(int trazeniBrB) {
        TrazeniBrB = trazeniBrB;
    }
}
