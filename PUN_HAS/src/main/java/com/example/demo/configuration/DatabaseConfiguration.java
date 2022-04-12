package com.example.demo.configuration;


import com.example.demo.model.*;

import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;


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
        Korisnik korisnik = new Korisnik("Nemanja", "nemanjica","Nemanja","Ranitovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Admin);
        korisnikRepository.save(korisnik);
        Restoran restoran = new Restoran("Canzona", "Italijanski");
        restoranRepository.save(restoran);
        Admin admin = new Admin(korisnik);
        adminRepository.save(admin);

        Artikal artikal = new Artikal("SIS CEVAP",267, Artikal.TIP.Jelo, 1);
        artikalRepository.save(artikal);

        artikal.setOpis("VEOMA LEP SIS CEVAP");
        artikalRepository.save(artikal);

        Artikal artikal2 = new Artikal("Pizza",350, Artikal.TIP.Jelo,1);

        Korisnik korisnik2 = new Korisnik("Marko", "nemanjica","Marko","Markovic", Korisnik.POLOVI.Musko,new java.util.Date(System.currentTimeMillis()), Korisnik.ULOGA.Dostavljac);

        artikalRepository.saveAll(
                List.of(artikal,artikal2)
        );


        return true;
    }
}
