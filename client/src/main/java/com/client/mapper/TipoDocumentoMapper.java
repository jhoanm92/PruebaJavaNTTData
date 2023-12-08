package com.client.mapper;

import com.client.dto.TipoDocumentoDTO;
import com.client.model.TipoDocumentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoMapper implements GenericMapper<TipoDocumentoEntity, TipoDocumentoDTO>{

    @Autowired
    private ModelMapper mapper;

    @Override
    public TipoDocumentoEntity toEntity(TipoDocumentoDTO dto) {
        return mapper.map(dto, TipoDocumentoEntity.class);
    }

    @Override
    public TipoDocumentoDTO toDto(TipoDocumentoEntity entity) {
        return mapper.map(entity, TipoDocumentoDTO.class);
    }

    @Override
    public List<TipoDocumentoEntity> toEntities(List<TipoDocumentoDTO> dtos) {
        return dtos.stream().map(x -> mapper.map(x, TipoDocumentoEntity.class)).toList();
    }

    @Override
    public List<TipoDocumentoDTO> toDtos(List<TipoDocumentoEntity> entities) {
        return entities.stream().map(x -> mapper.map(x, TipoDocumentoDTO.class)).toList();
    }
}
