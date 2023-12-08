package com.client.service.impl;

import com.client.dto.PersonaDTO;
import com.client.model.PersonaEntity;
import com.client.model.TipoDocumentoEntity;
import com.client.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonaServiceImplTest {

    @Mock
    private PersonaServiceImpl personaService;

    @InjectMocks
    private PersonaDTO persona;

    @InjectMocks
    private TipoDocumentoEntity tipoDocumento;

    private String tipo = "C";
    private Integer documento = 23445322;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        tipoDocumento = new TipoDocumentoEntity();
        tipoDocumento.setTipo("P");
        tipoDocumento.setDescripcion("Pasaporte");

        persona = new PersonaDTO();
        persona.setPrimerNombre("Juan");
        persona.setSegundoNombre("Pablo");
        persona.setPrimerApellido("Fierro");
        persona.setSegundoApellido("Castro");
        persona.setDocumento(23445322);
        persona.setTipoDocumento(tipoDocumento);
        persona.setTelefono("123456789");
        persona.setDireccion("Carrera 1 No 32 - 98");
        persona.setCiudad("Pasto");


    }

    @Test
    void BuacarPorTipoYDocumento() {
        when(personaService.BuacarPorTipoYDocumento(tipo, documento)).thenReturn(persona);
        assertNotNull(personaService.BuacarPorTipoYDocumento(tipo, documento));
    }

    @Test
    void registrar() {
        when(personaService.register(persona)).thenReturn(persona);
        assertNotNull(personaService.register(persona));
    }
}