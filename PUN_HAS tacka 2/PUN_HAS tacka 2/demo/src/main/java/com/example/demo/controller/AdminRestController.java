package com.example.demo.controller;


import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Korisnik;
import com.example.demo.service.AdminService;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunMisc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AdminRestController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api/admin")
    public String pocetak(){return "Ovo je Admin rest Controller";}

     @PostMapping("/api/admin/login")
    public ResponseEntity<String> adminLogin(@RequestBody LoginDto loginDto, HttpSession seesion){
         if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
             return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
         }
         Admin loggedAdmin = adminService.login(loginDto.getUsername(),loginDto.getPassword());
         if(loggedAdmin == null){
             return new ResponseEntity<>("Admin ne postoji",HttpStatus.NOT_FOUND);
         }
         seesion.setAttribute("Admin",loggedAdmin);
         seesion.setAttribute("Korisnik",loggedAdmin);

         return ResponseEntity.ok("Dobro dosli admine!");
     }

     @GetMapping("/api/admin/pregled")
    public ResponseEntity<List<KorisnikDto>> findAll(HttpSession session){
        List<Korisnik> listaKorisnika = korisnikService.pregledKorisnika();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("Korisnik");
        if(loggedKorisnik == null){
            System.out.println("Nema sesije");
        }else{
            System.out.println(loggedKorisnik);
        }
        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : listaKorisnika){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
     }

}
