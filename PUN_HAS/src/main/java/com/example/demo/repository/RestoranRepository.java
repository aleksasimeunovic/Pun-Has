package com.example.demo.repository;

import com.example.demo.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestoranRepository extends JpaRepository <Restoran, Long> {
}
