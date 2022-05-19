package com.example.demo.controller;


import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.Korisnik;
import com.example.demo.service.KorisnikService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api/")
    public String welecome() {
        return "Pozdrav iz apija!";
    }

    @GetMapping("/api/korisnici")
    public List<Korisnik> listaKorisnika() {
        List<Korisnik> listaK = korisnikService.pronadjiSve();
        return listaK; // povratna vrednost tipa List<Korisnik>
    }

    @DeleteMapping("/api/obrisi-korisnika/{id}")
    public List<Korisnik> listanakonBrisanja(@PathVariable(name = "id") Long id) {
        this.korisnikService.obrisiPoId(id);
        List<Korisnik> tmp = korisnikService.pronadjiSve();
        return tmp;
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        //proveravamo da li su podaci validni
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Korisnik loggedKorisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKorisnik == null) {
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);
        }
        session.setAttribute("Korisnik", loggedKorisnik);

      /*  if (session.getAttribute("Korisnik") != null) {
            System.out.println("Prijavljen je korisnik!");
        }*/
        return ResponseEntity.ok("Uspesno ste se prijavili!");

    }

    @GetMapping("/api/provera")  //provera da li mogu da posebno proverim na "urlu" da li je prijavljen admin.
    public String provera(HttpSession session){
        if(session.getAttribute("Korisnik") != null){
            return "Korisnik je prijavljen!";
        }
        return null;
    }
    @PostMapping("/api/register")
    public  ResponseEntity<String> register(@RequestBody RegisterDto registerDto, HttpSession session){
        if(registerDto.getUsername().isEmpty() ||
           registerDto.getPassword().isEmpty() ||
           registerDto.getName().isEmpty()     ||
           registerDto.getLastName().isEmpty() ||
           !registerDto.getPol().getDeclaringClass().isEnum())
        {

            return new ResponseEntity<>("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Korisnik registrovanKorisnik = korisnikService.register(registerDto.getUsername(),registerDto.getPassword(),registerDto.getName(),registerDto.getLastName(),registerDto.getPol());
        if(registrovanKorisnik == null){
            return new ResponseEntity<>("Korisnik vec postoji, ili sifra ne ispunjava kriterijum!", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("Korisnik", registrovanKorisnik);
        return ResponseEntity.ok("Uspesna registracija");
    }
    @GetMapping("/api/korisnik/pregled")
    public Korisnik pregled(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("Korisnik") != null){
            Korisnik loggedKorisnik = (Korisnik) session.getAttribute("Korisnik");
            List<Korisnik> tmp = korisnikService.pronadjiSve();
            for(Korisnik k : tmp){
                if(k.getUsername().equals(loggedKorisnik.getUsername())){
                    return k;
                }
            }
    }
        return null;
    }

    @PutMapping("/api/korisnik/izmeni")
    public ResponseEntity<String> izmena(@RequestBody RegisterDto registerDto, HttpSession session){
        if(session.getAttribute("Korisnik") != null){
            Korisnik loggedKorisnik = (Korisnik) session.getAttribute("Korisnik");
            List<Korisnik> tmp = (List<Korisnik>) korisnikService.pronadjiSve();
            for(Korisnik k : tmp) {
                    if (korisnikService.izmenaPodataka(loggedKorisnik.getUsername(), registerDto.getUsername(), registerDto.getPassword(), registerDto.getName(), registerDto.getLastName(), registerDto.getPol()) == false) {
                        return new ResponseEntity<>("Novi username je zauzet", HttpStatus.BAD_REQUEST);
                    } else {
                        return ResponseEntity.ok("Podaci izmenjeni");
                    }
            }
    }
        return new ResponseEntity<>("Nema ulogovanih korisnika", HttpStatus.BAD_REQUEST);
    }
}