package com.client.service.impl;

import com.client.dto.PersonaDTO;
import com.client.exeption.ModeloNotFoundException;
import com.client.mapper.PersonaMapper;
import com.client.model.TipoDocumentoEntity;
import com.client.service.PersonaService;
import com.client.model.PersonaEntity;
import com.client.repository.GenericRepository;
import com.client.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl extends CRUDImpl<PersonaEntity, PersonaDTO, Integer> implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PersonaMapper mapper;
    @Override
    protected GenericRepository<PersonaEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public PersonaDTO BuacarPorTipoYDocumento(String tipo, Integer documento) {

        Optional<PersonaEntity> p = repository.BuacarPorTipoYDocumento(tipo , documento);

        if (p.isEmpty()) {
            throw new ModeloNotFoundException("PERSONA NO ENCONTRADA");
        }

        return mapper.toDto(p.get());
    }
}
