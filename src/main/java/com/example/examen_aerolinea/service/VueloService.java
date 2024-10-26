package com.example.examen_aerolinea.service;


import com.example.examen_aerolinea.model.Vuelo;
import com.example.examen_aerolinea.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public List<Vuelo> obtenerVuelos() {
        return vueloRepository.findAll();
    }

    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public Vuelo obtenerVueloPorId(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

    public void eliminarVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
}
