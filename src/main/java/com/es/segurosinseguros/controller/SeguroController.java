package com.es.segurosinseguros.controller;


import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService service;

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id){
        if(id == null) throw new BadRequestException("Id no debe ser nulo");
        SeguroDTO body = service.getById(id);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<SeguroDTO>> getAll(){
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<SeguroDTO> create(@RequestBody SeguroDTO body){
        if(body == null) throw new BadRequestException("Body no debe ser nulo");
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable String id, @RequestBody SeguroDTO body){
        if(id == null) throw new BadRequestException("Id no debe ser nulo");
        if(body == null) throw new BadRequestException("Body no debe ser nulo");
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        if(id == null) throw new BadRequestException("Id no debe ser nulo");
        return null;
    }
}
