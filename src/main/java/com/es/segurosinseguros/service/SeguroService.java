package com.es.segurosinseguros.service;


import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.utils.Mapper;
import com.es.segurosinseguros.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;



    public SeguroDTO getById(String id) {
        if(id.isBlank() || id.isEmpty()) throw new BadRequestException("id no valido");
        Long idL = Long.parseLong(id);
        Seguro seguro = repository.findById(idL).orElse(null);
        if (seguro == null) throw new NotFoundException("Seguro no encontrado");
        return Mapper.entityToDTO(seguro);
    }

    public List<SeguroDTO> getAll() {
        List<SeguroDTO> listaSegurosDTO = new ArrayList<>();
        List<Seguro> listaSeguros = (List<Seguro>) repository.findAll();
        if(listaSeguros.isEmpty()) throw new NotFoundException("Seguros no encontrados");

        for (Seguro seguro : listaSeguros) {
            listaSegurosDTO.add(Mapper.entityToDTO(seguro));
        }
        return listaSegurosDTO;
    }

    public SeguroDTO create(SeguroDTO seguroDTO) {
        if(seguroDTO == null) throw new BadRequestException("Seguro no puede ser nulo");
        Seguro seguro = Mapper.DTOToEntity(seguroDTO);
        return Mapper.entityToDTO(repository.save(seguro));
    }

    public SeguroDTO update(String id, SeguroDTO seguroDTO) {
        if(id == null || id.isEmpty()) throw new BadRequestException("id no valido");
        Seguro seguro = repository.findById(Long.parseLong(id)).orElse(null);
        if(seguro == null) throw new BadRequestException("Seguro no encontrado");
        Seguro seguroActualizado = Mapper.DTOToEntity(seguroDTO);
        return Mapper.entityToDTO(repository.save(seguroActualizado));

    }

    public boolean delete(String id) {
        if(id == null || id.isEmpty()) throw new BadRequestException("id no valido");
        Long idL = Long.parseLong(id);
        Seguro seguro = repository.findById(Long.parseLong(id)).orElse(null);
        if(seguro == null) throw new NotFoundException("Seguro no encontrado");
        if(repository.existsById(idL)){
            repository.deleteById(idL);
            return true;
        }
        return false;
    }
}
