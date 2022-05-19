package com.example.demo.configuration;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;


@Configuration
public class DatabaseConfiguration {

    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private RestoranRepository restoranRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ArtikalRepository artikalRepository;
    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Bean
    public boolean instantiate(){
        Korisnik korisnik = new Korisnik("Nemanja","nemanjica","Nemanja","Ranitovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Admin);
        Admin korisnik51 = new Admin("Aleksa","123","Aleksa","Simeunovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Admin);
        korisnikRepository.save(korisnik);
        Restoran restoran = new Restoran("Canzona", "Italijanski");
        restoranRepository.save(restoran);

        adminRepository.save(korisnik51);
        //Admin admin = new Admin(korisnik);
       // adminRepository.save(admin);

        Artikal artikal = new Artikal(Artikal.Tip.Jelo,"Sis Cevap",267,1);
        artikalRepository.save(artikal);
        artikal.setOpis("Mnogo dobar sis cevap");
        artikalRepository.save(artikal);
        Artikal artikal2 = new Artikal(Artikal.Tip.Jelo, "Pizza", 350,1);
        Korisnik korisnik2 = new Korisnik("Marko", "nemanjica","Marko","Markovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Dostavljac);
        artikalRepository.saveAll(
                List.of(artikal,artikal2)
        );
        Korisnik korisnik3 = new Korisnik("Petar","lozinka123","Petar","Petrovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Menadzer);
        Korisnik korisnik4 = new Korisnik("Stefan","menadzer123","Stefan","Stefic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Dostavljac);
        Korisnik korisnik5 = new Korisnik("Lexa","lexangton123","Aleksa","Spasic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Kupac);
        korisnikRepository.saveAll(
                List.of(korisnik3,korisnik4,korisnik5)
        );
        return true;
    }
}