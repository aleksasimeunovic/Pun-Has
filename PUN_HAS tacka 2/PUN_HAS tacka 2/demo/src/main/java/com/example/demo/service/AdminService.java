package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Dostavljac;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Menadzer;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DostavljacRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Admin login(String username,String password){
        Admin admin = adminRepository.getByUsername(username);
        if(admin == null || !admin.getPassword().equals(password)){
            return null;
        }
        return admin;
    }

    public Menadzer createManager(String username, String password, String name, String lastName, Korisnik.POLOVI pol){
        Menadzer kreiraniMenadzer = new Menadzer(username,password,name,lastName,pol);

        menadzerRepository.save(kreiraniMenadzer);

        return kreiraniMenadzer;
    }
    public Dostavljac createDostavljac(String username, String password, String name, String lastName, Korisnik.POLOVI pol){
        Dostavljac kreiranDostavljac = new Dostavljac(username,password,name,lastName,pol);

        dostavljacRepository.save(kreiranDostavljac);

        return kreiranDostavljac;
    }

}
