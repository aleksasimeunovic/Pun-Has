package com.example.demo.service;


import com.example.demo.model.Admin;
import com.example.demo.model.Artikal;
import com.example.demo.model.Menadzer;
import com.example.demo.model.Restoran;
import com.example.demo.repository.ArtikalRepository;
import com.example.demo.repository.MenadzerRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private RestoranRepository restoranRepository;

    public Menadzer findByUsername(String username) {
        Optional<Menadzer> pronadjeni = Optional.ofNullable(menadzerRepository.getByUsername(username));
        return pronadjeni.orElse(null);
    }

    public Menadzer login(String username, String password) {
        Menadzer menadzer = menadzerRepository.getByUsername(username);
        if (menadzer == null || !menadzer.getPassword().equals(password)) {
            return null;
        }
        return menadzer;
    }

    public void addArticle(String naziv, double cena, Artikal.Tip tip, Menadzer menadzer) {
        Artikal artikal = new Artikal(tip, naziv, cena);
        artikal.setRestoran(menadzer.getRestoran());
        artikalRepository.save(artikal);
        menadzer.getRestoran().getMeni().add(artikal);
        restoranRepository.save(menadzer.getRestoran());
    }

    public void dodajKomentar(String naziv, String komentar,Menadzer menadzer) {
        Set<Artikal> artikli =  menadzer.getRestoran().getMeni();
        for (Artikal artikal : artikli) {
            if (artikal.getName().equals(naziv)) {
                artikal.setOpis(komentar);
                artikalRepository.save(artikal);
            }
        }
    }

    public void obrisiArtikal(String ime,Menadzer menadzer){
        Set<Artikal> artikli =  menadzer.getRestoran().getMeni();
        for(Artikal artikal : artikli){
            if(artikal.getName().equals(ime)){
                menadzer.getRestoran().getMeni().remove(artikal);
                artikalRepository.delete(artikal);
            }
        }
    }

    public void izmeniArtikal(String naziv,String novinaziv, double cena, Artikal.Tip tip,Menadzer menadzer){
        Set<Artikal> artikli =  menadzer.getRestoran().getMeni(); //pretraga ce da se radi tako sto ce menadzer morati da unese ime artikla da bi ga izmenio
        for(Artikal artikal : artikli){
            if(artikal.getName().equals(naziv)){
                if(!novinaziv.isEmpty()){
                    artikal.setName(novinaziv);
                    artikalRepository.save(artikal);
                }
                if(cena != 0){
                    artikal.setCena(cena);
                    artikalRepository.save(artikal);
                }
                if(artikal.getTip().getDeclaringClass().isEnum()){
                    artikal.setTip(tip);
                    artikalRepository.save(artikal);
                }
            }
        }
    }
    public void otvori(Menadzer menadzer){
        menadzer.getRestoran().setRadi(true);
    }
}
