package com.example.examen_aerolinea.repository;

import com.example.examen_aerolinea.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
