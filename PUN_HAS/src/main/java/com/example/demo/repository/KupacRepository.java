package com.example.demo.repository;

import com.example.demo.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository <Kupac, Long> {
}
