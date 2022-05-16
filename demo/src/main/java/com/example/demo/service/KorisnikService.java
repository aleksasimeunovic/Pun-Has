package com.example.demo.service;


import com.example.demo.model.Dostavljac;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Menadzer;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private DostavljacRepository dostavljacRepository;
    @Autowired
    private KupacRepository kupacRepository;
    @Autowired
    private AdminRepository adminRepository;


    public Korisnik pronadji(Long id){
        Optional<Korisnik> pronadjeni = korisnikRepository.findById(id);
        return pronadjeni.orElse(null); // lepa zamena za if upit
    }
    public List<Korisnik> pronadjiSve(){return korisnikRepository.findAll(); }

    public void obrisiPoId(Long id){
        Optional<Korisnik> pronadjeni = korisnikRepository.findById(id);
        if(pronadjeni.isPresent()){
            korisnikRepository.deleteById(id);
        }
    }
    public List<Korisnik> pregledKorisnika(){
        List<Korisnik> listaSvihKorisnika = new ArrayList<>();
        List<Korisnik> listaMenadzera = (List<Korisnik>) (List<?>) menadzerRepository.findAll();
        List<Korisnik> listaDosavljaca = (List<Korisnik>)(List<?>) dostavljacRepository.findAll();
        List<Korisnik> listaKupaca = (List<Korisnik>)(List<?>) korisnikRepository.findAll();
        List<Korisnik> listaAdmina = (List<Korisnik>)(List<?>) adminRepository.findAll();

        listaSvihKorisnika.addAll(listaMenadzera);
        listaSvihKorisnika.addAll(listaAdmina);
        listaSvihKorisnika.addAll(listaDosavljaca);
        listaSvihKorisnika.addAll(listaKupaca);

        return listaSvihKorisnika;
    }

    public Korisnik login(String username, String password){
        Korisnik korisnik = korisnikRepository.getByUsername(username);
        if(korisnik == null || !korisnik.getPassword().equals(password)){
            return null;
        }
        return korisnik;
    }
    public Korisnik register(String username, String password, String name, String lastName, Korisnik.POLOVI pol){
        Korisnik korisnik = new Korisnik(username,password,name,lastName,pol,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Kupac);

        if(korisnikRepository.getByUsername(username) != null){
            return null;
        }else{
            char ch;
            boolean brojFlag = false;
            boolean vSlovo = false;
            boolean ispravnaSifra = false;
            for(int i = 0; i < password.length();i++){
                ch = password.charAt(i);
                if(Character.isDigit(ch)){
                    brojFlag = true;
                }
                if(Character.isUpperCase(ch)){
                    vSlovo = true;
                }
            }
            if(vSlovo && brojFlag){
                ispravnaSifra = true;
            }
            if(password.length() < 6 || !ispravnaSifra){
                return null;
            }else{
                korisnikRepository.save(korisnik);
                return korisnik;
            }
        }
    }

}