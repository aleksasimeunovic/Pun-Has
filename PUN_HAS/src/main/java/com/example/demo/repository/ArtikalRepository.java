package com.example.demo.repository;

import com.example.demo.model.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikalRepository extends JpaRepository <Artikal, Long> {
}
