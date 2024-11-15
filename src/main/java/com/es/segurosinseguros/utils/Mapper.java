package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;


//TODO: Completar metodos una vez esten definidas las clases DTO
public class Mapper {

    public static SeguroDTO entityToDTO(Seguro seguro) {
        SeguroDTO dto = new SeguroDTO();
     return dto;
    }

    public static Seguro DTOToEntity(SeguroDTO dto) {
        Seguro seguro = new Seguro();
        return seguro;
    }

    public static AsistenciaMedicaDTO entityToDTO(AsistenciaMedica a){
        AsistenciaMedicaDTO dto = new AsistenciaMedicaDTO();
        return dto;

    }
    public static AsistenciaMedica DTOToEntity(AsistenciaMedicaDTO dto) {
        AsistenciaMedica a = new AsistenciaMedica();
        return a;
    }
}
