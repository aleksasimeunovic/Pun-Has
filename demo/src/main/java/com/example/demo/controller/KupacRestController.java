package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.PorudzbinaDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Kupac;
import com.example.demo.model.Restoran;
import com.example.demo.repository.RestoranRepository;
import com.example.demo.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KupacRestController {
    @Autowired
    private KupacService kupacService;

    @Autowired
    private RestoranRepository restoranRepository;

    @PostMapping("/api/kupac/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto, HttpSession session){
        if(registerDto.getUsername().isEmpty() ||
                registerDto.getPassword().isEmpty() ||
                registerDto.getName().isEmpty()     ||
                registerDto.getLastName().isEmpty() ||
                !registerDto.getPol().getDeclaringClass().isEnum())
        {

            return new ResponseEntity<>("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Kupac registrovanKupac = kupacService.register(registerDto.getUsername(),registerDto.getPassword(),registerDto.getName(),registerDto.getLastName(),registerDto.getPol());
        if(registrovanKupac == null){
            return new ResponseEntity<>("Korisnik vec postoji, ili sifra ne ispunjava kriterijum!", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("Kupac", registrovanKupac);
        return ResponseEntity.ok("Uspesna registracija");
    }

    @PostMapping("/api/kupac/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        //proveravamo da li su podaci validni
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Kupac loggedKupac = kupacService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKupac== null) {
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);
        }
        session.setAttribute("Kupac", loggedKupac);

        return ResponseEntity.ok("Uspesno ste se prijavili!");

    }

    //Ideja je da se prvo kreiraju funckionalnosti za pravljenje porudzbine.
    //Pregledi porudzbina : Tacke 1-3 u delu porudzbine mogu brzo da se implementiraju
    // tako da krecem od tacke 4

    //u servis prosledjujem ime artikla i poredim sa listom artikala iz restorana iz kog je poruceno, ako ima, moze, ako nema ne moze

    //PorudzbinaDto
    /*
        --Ime artikla koji kupac porucuje
        --KORPA JE U SUSTINI ARTIKLI U PORUDZBINI
        --Izlistavaju se naziv kolicina cena(pojedinacna), i ukupna cena

     */
    @PostMapping("/api/kupac/poruci")
    public ResponseEntity<String> porudzbina(@RequestBody PorudzbinaDto porudzbinaDto, HttpSession session){
        if(porudzbinaDto.getArtikli().isEmpty() || porudzbinaDto.getKolicina().isEmpty()){
            return new ResponseEntity("Invalid data", HttpStatus.BAD_REQUEST);
        }
        Kupac loggedKupac = (Kupac) session.getAttribute("Kupac");
        if(loggedKupac == null){
            return new ResponseEntity<>("Nema ulogovanih kupaca nije moguce poruciti", HttpStatus.BAD_REQUEST);
        }
        List<Restoran> listar = restoranRepository.findAll();
        for(Restoran r : listar){
            if(porudzbinaDto.getRestoran().equals(r.getNaziv())){
                if(r.isRadi()){kupacService.napraviPorudzbinu(porudzbinaDto.getRestoran(),porudzbinaDto.getArtikli(),porudzbinaDto.getKolicina(),loggedKupac);
                    return ResponseEntity.ok("Porudzbina kreirana");
                }
            }
        }
        return new ResponseEntity<>("Nema restorana koji rade",HttpStatus.BAD_REQUEST);
    }

}
