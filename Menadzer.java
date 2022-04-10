package projekat;

public class Menadzer extends Korisnik{
    private Restoran zadRest;
    public Menadzer(Korisnik k, Restoran zadRest ){
        super(k);
        this.zadRest = zadRest;
    }

    public Restoran getZadRest() {
        return zadRest;
    }

    public void setZadRest(Restoran zadRest) {
        this.zadRest = zadRest;
    }
}
