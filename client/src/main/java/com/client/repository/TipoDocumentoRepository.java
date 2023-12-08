package com.client.repository;

import com.client.model.TipoDocumentoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends GenericRepository<TipoDocumentoEntity, Integer> {
}
