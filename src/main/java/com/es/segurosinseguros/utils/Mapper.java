package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;


//TODO: Completar metodos una vez esten definidas las clases DTO
public class Mapper {

    public SeguroDTO entityToDTO(Seguro seguro) {
        SeguroDTO dto = new SeguroDTO();
     return dto;
    }

    public Seguro DTOToEntity(SeguroDTO dto) {
        Seguro seguro = new Seguro();
        return seguro;
    }

    public AsistenciaDTO entityToDTO(AsistenciaMedica a){
        AsistenciaDTO dto = new AsistenciaDTO();
        return dto;

    }
    public AsistenciaMedica DTOToEntity(AsistenciaDTO dto) {
        AsistenciaMedica a = new AsistenciaMedica();
        return a;
    }
}
