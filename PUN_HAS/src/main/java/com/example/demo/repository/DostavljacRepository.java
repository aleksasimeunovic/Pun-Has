package com.example.demo.repository;

import com.example.demo.model.Dostavljac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DostavljacRepository extends JpaRepository <Dostavljac, Long> {
}
