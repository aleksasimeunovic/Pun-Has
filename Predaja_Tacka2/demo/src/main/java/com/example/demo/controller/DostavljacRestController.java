package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.StatusDto;
import com.example.demo.model.Dostavljac;
import com.example.demo.repository.DostavljacRepository;
import com.example.demo.service.DostavljacService;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class DostavljacRestController {
    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    DostavljacService dostavljacService;

    @Autowired
    private SessionService sessionService;





    @GetMapping("/api/dostavljac/login")
    public ResponseEntity<String> dostavljaclogin(@RequestBody LoginDto loginDto, HttpSession session){
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty()) {
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Dostavljac loggedDostavljac = dostavljacService.login(loginDto.getUsername(),loginDto.getPassword());
        if(loggedDostavljac == null){
            return new ResponseEntity<>("Dostavljac ne postoji",HttpStatus.NOT_FOUND);
        }
        session.setAttribute("role",loggedDostavljac.getUloga());
        session.setAttribute("username", loggedDostavljac.getUsername());
        return new ResponseEntity(loggedDostavljac,HttpStatus.OK);
    }
    @PutMapping("/api/dostavljac/preuzmi/{uuid}")
    public ResponseEntity<String> preuzmiPorudzbinu(@PathVariable(name = "uuid") UUID uuid, HttpSession session){
        if(!sessionService.validateSession(session)){
            return null;
        }
        Dostavljac loggedDostavljac = dostavljacRepository.getByUsername(sessionService.getUsername(session));
        dostavljacService.preuzmi(uuid,loggedDostavljac);
        return ResponseEntity.ok("Porudzbina preuzeta");
    }
}
