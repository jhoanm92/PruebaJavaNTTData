package com.client.service.impl;

import com.client.exeption.ModeloNotFoundException;
import com.client.service.CRUD;
import com.client.mapper.GenericMapper;
import com.client.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public abstract class CRUDImpl<T, DTO, ID> implements CRUD<DTO, ID> {

    @Autowired
    protected abstract GenericRepository<T, ID> getRepository();

    @Autowired
    private GenericMapper<T, DTO> mapper;


    @Override
    public DTO register(DTO dto) {
        try {
            return mapper.toDto(getRepository().save(mapper.toEntity(dto)));
        }catch (Exception e){
            System.out.println(e.getCause());
            throw new ModeloNotFoundException("HA OCURRIDO UN ERROR AL GUARDAR");
        }
    }

    @Override
    public DTO update(DTO dto) {
        return mapper.toDto(getRepository().save(mapper.toEntity(dto)));
    }

    @Override
    public List<DTO> getAll() {
        return mapper.toDtos(getRepository().findAll());
    }

    @Override
    public DTO getById(ID id) {
        Optional<T> optional = getRepository().findById(id);
        if(optional.isEmpty()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }
        return mapper.toDto(optional.get());
    }

    @Override
    public void delete(ID id) {
        getById(id);
        getRepository().deleteById(id);
    }
}
