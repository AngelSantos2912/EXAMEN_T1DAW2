package com.example.examen_aerolinea.controller;


import com.example.examen_aerolinea.model.Vuelo;
import com.example.examen_aerolinea.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public List<Vuelo> obtenerVuelos() {
        return vueloService.obtenerVuelos();
    }

    @PostMapping
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.guardarVuelo(vuelo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVuelo(@PathVariable Long id) {
        Vuelo vuelo = vueloService.obtenerVueloPorId(id);
        return vuelo != null ? ResponseEntity.ok(vuelo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vueloDetails) {
        Vuelo vuelo = vueloService.obtenerVueloPorId(id);
        if (vuelo != null) {
            vuelo.setOrigen(vueloDetails.getOrigen());
            vuelo.setDestino(vueloDetails.getDestino());
            vuelo.setFecha(vueloDetails.getFecha());
            vuelo.setPrecio(vueloDetails.getPrecio());
            return ResponseEntity.ok(vueloService.guardarVuelo(vuelo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Long id) {
        vueloService.eliminarVuelo(id);
        return ResponseEntity.noContent().build();
    }
}

