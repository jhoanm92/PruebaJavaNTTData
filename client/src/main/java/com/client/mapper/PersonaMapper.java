package com.client.mapper;

import com.client.dto.PersonaDTO;
import com.client.model.PersonaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaMapper implements GenericMapper<PersonaEntity, PersonaDTO>{

    @Autowired
    private ModelMapper mapper;

    @Override
    public PersonaEntity toEntity(PersonaDTO dto) {
        return mapper.map(dto, PersonaEntity.class);
    }

    @Override
    public PersonaDTO toDto(PersonaEntity entity) {
        return mapper.map(entity, PersonaDTO.class);
    }

    @Override
    public List<PersonaEntity> toEntities(List<PersonaDTO> dtos) {
        return dtos.stream().map(x -> mapper.map(x, PersonaEntity.class)).toList();
    }

    @Override
    public List<PersonaDTO> toDtos(List<PersonaEntity> entities) {
        return entities.stream().map(x -> mapper.map(x, PersonaDTO.class)).toList();
    }
}
