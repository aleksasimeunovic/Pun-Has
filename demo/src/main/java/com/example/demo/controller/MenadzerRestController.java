package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.model.Artikal;
import com.example.demo.model.Menadzer;
import com.example.demo.service.MenadzerService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class MenadzerRestController {

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private RestoranService restoranService;

    @GetMapping("/api/menadzer/login")
    public ResponseEntity<String> menadzerLogin(@RequestBody LoginDto loginDto,HttpSession session){
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Menadzer loggedMenadzer = menadzerService.login(loginDto.getUsername(),loginDto.getPassword());
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Menadzer ne postoji",HttpStatus.NOT_FOUND);
        }
        session.setAttribute("Menadzer",loggedMenadzer);
        session.setAttribute("Korisnik",loggedMenadzer);

        return ResponseEntity.ok("Dobro dosli menadzere!");
    }

    @PostMapping("/api/menadzer/dodavanjeArtikla")
    public ResponseEntity<String> dodajArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("Menadzer");
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Nema ulogovanih menadzera, artikal se ne moze dodati",HttpStatus.METHOD_NOT_ALLOWED);
        }
        menadzerService.addArticle(artikalDto.getNaziv(),artikalDto.getCena(),artikalDto.getTip(),loggedMenadzer);
        return ResponseEntity.ok("Artikal dodat");
    }

    @PutMapping("/api/menadzer/dodavanjeKomentara")
    public ResponseEntity<String> dodajKomentar(@RequestBody KomentarDto komentarDto, HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("Menadzer");
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Nema ulogovanih menadzera, nije moguce uneti komentar",HttpStatus.METHOD_NOT_ALLOWED);
        }
        menadzerService.dodajKomentar(komentarDto.getNazivProizvoda(),komentarDto.getKomentar(),loggedMenadzer);
        return ResponseEntity.ok("Komentar dodat");
    }

    //OVO MORA DA SE ZAVRSI KADA PROMENIMO VEZE DA BUDU KAKO TREBA
    @DeleteMapping("/api/menadzer/brisanjeArtikla")
    public ResponseEntity<String> obrisiArtikal(@RequestBody ImeDto imeDto,HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("Menadzer");
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Nema ulogovanih menadzera, nije moguce izbrisati artikal",HttpStatus.METHOD_NOT_ALLOWED);
        }
        menadzerService.obrisiArtikal(imeDto.getName(),loggedMenadzer);
        return ResponseEntity.ok("Artikal obrisan");

    }

    //stavi se default dugme da je vrednost 0 na sajtu kada ovaj oce da menja, ako ne zeli ostavi 0, i to proverimo ovde
    @PutMapping("/api/menadzer/izmeniArtikal")
    public ResponseEntity<String> izmeniArtikal(@RequestBody ArtikalIzmenaDto artikalIzmenaDto, HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("Menadzer");
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Nema ulogovanih menadzera, nije moguce menjanje artikala",HttpStatus.METHOD_NOT_ALLOWED);
        }
        menadzerService.izmeniArtikal(artikalIzmenaDto.getNaziv(),artikalIzmenaDto.getNoviNaziv(),artikalIzmenaDto.getCena(),artikalIzmenaDto.getTip(),loggedMenadzer);
        return ResponseEntity.ok("Artikal izmenjen");
    }
    @PutMapping("/api/menadzer/status")
    public ResponseEntity<String> otvaranje(HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("Menadzer");
        if(loggedMenadzer == null){
            return new ResponseEntity<>("Nema ulogovanih menadzera, nije moguce menjanje artikala",HttpStatus.METHOD_NOT_ALLOWED);
        }
        menadzerService.otvori(loggedMenadzer);
        return ResponseEntity.ok("Restoran otvoren");
    }

}
