package com.client.controller;

import com.client.dto.TipoDocumentoDTO;
import com.client.exeption.ModeloNotFoundException;
import com.client.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService service;

    @PostMapping()
    public ResponseEntity<TipoDocumentoDTO> register(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) {
        return new ResponseEntity<>(service.register(tipoDocumentoDTO), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<TipoDocumentoDTO> update(@RequestBody TipoDocumentoDTO tipoDocumentoDTO) {
        return new ResponseEntity<>(service.update(tipoDocumentoDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TipoDocumentoDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoDTO> getById(@PathVariable("id") Integer id) {
        service.getById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        TipoDocumentoDTO obj = service.getById(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
