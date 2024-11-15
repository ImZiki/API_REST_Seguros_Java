package com.es.segurosinseguros.service;



import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.repository.AsistenciaRepository;
import com.es.segurosinseguros.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;


    public AsistenciaMedicaDTO getById(String id) {
        if(id.isBlank() || id.isEmpty()) throw new BadRequestException("id no valido");
        Long idL = Long.parseLong(id);
        AsistenciaMedica asistenciaMedica = repository.findById(idL).orElse(null);
        if (asistenciaMedica == null) throw new NotFoundException("Asistencia médica no encontrada");
        return Mapper.entityToDTO(asistenciaMedica);
    }

    public List<AsistenciaMedicaDTO> getAll() {
        List<AsistenciaMedicaDTO> listaAsistenciasDTO = new ArrayList<>();
        List<AsistenciaMedica> listaAsistencias = (List<AsistenciaMedica>) repository.findAll();
        if(listaAsistencias.isEmpty()) throw new NotFoundException("Asistencias médicas no encontradas");

        for (AsistenciaMedica asistenciaMedica : listaAsistencias) {
            listaAsistenciasDTO.add(Mapper.entityToDTO(asistenciaMedica));
        }
        return listaAsistenciasDTO;
    }

    public AsistenciaMedicaDTO create(AsistenciaMedicaDTO asistenciaMedicaDTO) {
        if(asistenciaMedicaDTO == null) throw new BadRequestException("Asistencia médica no puede ser nula");
        AsistenciaMedica asistenciaMedica = Mapper.DTOToEntity(asistenciaMedicaDTO);
        return Mapper.entityToDTO(repository.save(asistenciaMedica));
    }

    public AsistenciaMedicaDTO update(String id, AsistenciaMedicaDTO asistenciaMedicaDTO) {
        if(id == null || id.isEmpty()) throw new BadRequestException("id no valido");
        AsistenciaMedica asistenciaMedica = repository.findById(Long.parseLong(id)).orElse(null);
        if(asistenciaMedica == null) throw new BadRequestException("Asistencia médica no encontrada");
        AsistenciaMedica asistenciaActualizada = Mapper.DTOToEntity(asistenciaMedicaDTO);
        return Mapper.entityToDTO(repository.save(asistenciaActualizada));
    }

    public boolean delete(String id) {
        if(id == null || id.isEmpty()) throw new BadRequestException("id no valido");
        Long idL = Long.parseLong(id);
        AsistenciaMedica asistenciaMedica = repository.findById(Long.parseLong(id)).orElse(null);
        if(asistenciaMedica == null) throw new NotFoundException("Asistencia médica no encontrada");
        if(repository.existsById(idL)) {
            repository.deleteById(idL);
            return true;
        }
        return false;
    }

}
