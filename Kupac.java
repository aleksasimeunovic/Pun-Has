package projekat;

import java.util.ArrayList;
import java.util.Date;

public class Kupac extends Korisnik{
    private ArrayList<Porudzbina> ListaPorudzbina;
    private int BrojSkupljenihBod;
    private TipKupca Tip;

   public Kupac(Korisnik k,ArrayList<Porudzbina> listaPorudzbina, int BrojskupljenihBod, TipKupca tip){
       super(k);
       this.ListaPorudzbina = listaPorudzbina;
       this.BrojSkupljenihBod = BrojskupljenihBod;
       this.Tip = tip;
   }

    public ArrayList<Porudzbina> getListaPorudzbina() {
        return ListaPorudzbina;
    }

    public void setListaPorudzbina(ArrayList<Porudzbina> listaPorudzbina) {
        ListaPorudzbina = listaPorudzbina;
    }

    public int getBrojSkupljenihBod() {
        return BrojSkupljenihBod;
    }

    public void setBrojSkupljenihBod(int brojSkupljenihBod) {
        BrojSkupljenihBod = brojSkupljenihBod;
    }

    public TipKupca getTip() {
        return Tip;
    }

    public void setTip(TipKupca tip) {
        Tip = tip;
    }
}
