package com.client.service;

import com.client.dto.PersonaDTO;
import com.client.model.PersonaEntity;

import java.util.Optional;

public interface PersonaService extends CRUD<PersonaDTO, Integer>{

    PersonaDTO BuacarPorTipoYDocumento(String tipo, Integer documento);
}
