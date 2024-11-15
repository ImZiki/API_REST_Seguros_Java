package com.es.segurosinseguros.controller;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaMedicaController {

    @Autowired
    private AsistenciaService service;

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaMedicaDTO> getById(@PathVariable String id) {
        if (id == null) throw new BadRequestException("Id no debe ser nulo");
        AsistenciaMedicaDTO body = service.getById(id);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AsistenciaMedicaDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/seguros/{idSeguro}/asistencias")
    public ResponseEntity<AsistenciaMedicaDTO> create(@RequestBody AsistenciaMedicaDTO body, @PathVariable String idSeguro) {
        if(idSeguro == null) throw new BadRequestException("Id no debe ser nulo");
        if (body == null) throw new BadRequestException("Body no debe ser nulo");
        return new ResponseEntity<>(service.create(body), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaMedicaDTO> update(@PathVariable String id, @RequestBody AsistenciaMedicaDTO body) {
        if (id == null) throw new BadRequestException("Id no debe ser nulo");
        if (body == null) throw new BadRequestException("Body no debe ser nulo");
        return new ResponseEntity<>(service.update(id, body), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        if (id == null) throw new BadRequestException("Id no debe ser nulo");
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
