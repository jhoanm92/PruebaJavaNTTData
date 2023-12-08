package com.client.repository;

import com.client.model.PersonaEntity;
import com.client.model.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends GenericRepository<PersonaEntity, Integer> {

    Optional<PersonaEntity> findByTipoDocumentoAndDocumento(TipoDocumentoEntity tipoDocumento, Integer documento);

    @Query("SELECT p " +
            "FROM PersonaEntity p " +
            "INNER JOIN TipoDocumentoEntity t " +
            "ON p.tipoDocumento = t.id " +
            "WHERE p.documento = :documento AND t.tipo = :tipoDocumento")
    Optional<PersonaEntity> BuacarPorTipoYDocumento(String tipoDocumento, Integer documento);
}
