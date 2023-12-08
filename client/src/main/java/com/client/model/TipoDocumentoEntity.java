package com.client.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipos_documento")
public class TipoDocumentoEntity {

    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "tipo", unique = true, nullable = false)
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

}