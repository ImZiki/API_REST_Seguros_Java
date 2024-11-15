package com.es.segurosinseguros.model;

import com.es.segurosinseguros.model.Seguro;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencias_medicas")
public class AsistenciaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistenciaMedica;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seguro_id", nullable = false)
    private Seguro seguro;


    @Column(nullable = false, length = 255)
    private String breveDescripcion;


    @Column(nullable = false, length = 255)
    private String lugar;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String explicacion;


    @Column(nullable = false)
    private String tipoAsistencia;


    @Column(nullable = false)
    private LocalDate fecha;


    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal importe;

    // Getters y Setters

    public Long getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    public void setIdAsistenciaMedica(Long idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
