package com.client.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personas")
public class PersonaEntity {

    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "documento", unique = true, nullable = false)
    private Integer documento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_documento_fk", referencedColumnName = "id_tipo_documento")
    private TipoDocumentoEntity tipoDocumento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

}
