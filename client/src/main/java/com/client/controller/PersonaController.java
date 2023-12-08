package com.client.controller;

import com.client.dto.PersonaDTO;
import com.client.exeption.ModeloNotFoundException;
import com.client.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/buscar")
    public ResponseEntity<PersonaDTO> obtenerPersona(@RequestParam(name = "tipo")String tipo,
                                                     @RequestParam(name = "documento") Integer documento) {
        return new ResponseEntity<>(service.BuacarPorTipoYDocumento(tipo, documento), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PersonaDTO> register(@RequestBody PersonaDTO personaDTO) {
        return new ResponseEntity<>(service.register(personaDTO), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PersonaDTO> update(@RequestBody PersonaDTO personaDTO) {
        return new ResponseEntity<>(service.update(personaDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PersonaDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable("id") Integer id) {
        service.getById(id);
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        PersonaDTO obj = service.getById(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
