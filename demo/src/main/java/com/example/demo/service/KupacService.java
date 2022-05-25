package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;
    @Autowired
    private RestoranRepository restoranRepository;
    @Autowired
    private ArtikliUPorudzbiniRepository artikliUPorudzbiniRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public Kupac register(String username, String password, String name, String lastName, Korisnik.POLOVI pol) {
        Kupac kupac = new Kupac(username, password, name, lastName, pol, new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Kupac);

        if (kupacRepository.getByUsername(username) != null) {
            return null;
        } else {
            char ch;
            boolean brojFlag = false;
            boolean vSlovo = false;
            boolean ispravnaSifra = false;
            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isDigit(ch)) {
                    brojFlag = true;
                }
                if (Character.isUpperCase(ch)) {
                    vSlovo = true;
                }
            }
            if (vSlovo && brojFlag) {
                ispravnaSifra = true;
            }
            if (password.length() < 6 || !ispravnaSifra) {
                return null;
            } else {
                kupacRepository.save(kupac);
                return kupac;
            }
        }
    }
    public Kupac login(String username, String password) {
        List<Kupac> tmp = kupacRepository.findAll();
        for(Kupac k : tmp){
            if(k.getUsername().equals(username)){
                if(k.getPassword().equals(password)){
                    return k;
                }
            }
        }
        return null;
    }

    public void napraviPorudzbinu(String restoran,Set<String> listaNaziva, List<Integer> kolicine, Kupac k){
        List<Restoran> listaRestorana = restoranRepository.findAll();
        Porudzbina porudzbina = new Porudzbina();
        Restoran trenutniRestoran = new Restoran();
        ArtikliUPorudzbini tmp = new ArtikliUPorudzbini();

        for(Restoran rest : listaRestorana){
            if(rest.getNaziv().equals(restoran)){
                trenutniRestoran = rest;
            }
        }
        List<Artikal> listaPostojecihArtikala = new ArrayList<>(trenutniRestoran.getMeni());
        for(int i = 0; i < listaNaziva.size();i++){
           for(String naziv : listaNaziva){
               if(listaPostojecihArtikala.get(i).getName().equals(naziv)){
                   tmp.setArtikal(listaPostojecihArtikala.get(i));
                   tmp.setBroj(kolicine.get(i));
                   porudzbina.getListaArtikalaUPorudzbini().add(tmp);
               }
           }
        }
        porudzbina.setStatus(Porudzbina.STATUS.Obrada);
        porudzbinaRepository.save(porudzbina);
        k.getListaPorudzbina().add(porudzbina);
        kupacRepository.save(k); //ovo ne moze da stoji jer ako porucimo vise stvari od jednom dolazi do preklapanja u tabeli
    //kupac ima listu porudzbina
    }


}
