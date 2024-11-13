package com.es.segurosinseguros.service;


import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class SeguroService {
    public SeguroDTO getById(String id) {
        if(id.isBlank() || id.isEmpty()) throw new BadRequestException("id no valido");

        return null;
    }
}
