package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Admin extends Korisnik{
    public Admin(Korisnik k){
        super(k);
    }

    public Admin() {
        super();
    }
}