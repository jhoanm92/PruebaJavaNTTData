package com.client.service.impl;

import com.client.dto.TipoDocumentoDTO;
import com.client.service.TipoDocumentoService;
import com.client.model.TipoDocumentoEntity;
import com.client.repository.GenericRepository;
import com.client.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoServiceImpl extends CRUDImpl<TipoDocumentoEntity, TipoDocumentoDTO, Integer> implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository repository;

    @Override
    protected GenericRepository<TipoDocumentoEntity, Integer> getRepository() {
        return repository;
    }
}
