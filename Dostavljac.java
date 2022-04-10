package projekat;

import java.util.ArrayList;

public class Dostavljac extends Korisnik{
    private ArrayList<Porudzbina> Porudzbine;

    public Dostavljac(Korisnik k,ArrayList<Porudzbina> porudzbine){
        super(k);
        this.Porudzbine = porudzbine;
    }

    public ArrayList<Porudzbina> getPorudzbine() {
        return Porudzbine;
    }

    public void setPorudzbine(ArrayList<Porudzbina> porudzbine) {
        Porudzbine = porudzbine;
    }
}
