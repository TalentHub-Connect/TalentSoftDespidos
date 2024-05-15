package com.despido.talentdespido.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Retirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombredelempleado;
    private String etapa;
    private String causal;
    private int progresodedespido;
    private int salario;
    private String descripcionCausal;

    @Convert(converter = StringListConverter.class)
    private List<String> listaDocumentos;

    private String status;
    private int companyid;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombredelempleado() {
        return nombredelempleado;
    }
    public void setNombredelempleado(String nombredelempleado) {
        this.nombredelempleado = nombredelempleado;
    }
    public String getEtapa() {
        return etapa;
    }
    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
    public String getCausal() {
        return causal;
    }
    public void setCausal(String causal) {
        this.causal = causal;
    }
    public int getProgresodedespido() {
        return progresodedespido;
    }
    public void setProgresodedespido(int progresodedespido) {
        this.progresodedespido = progresodedespido;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public String getDescripcionCausal() {
        return descripcionCausal;
    }
    public void setDescripcionCausal(String descripcionCausal) {
        this.descripcionCausal = descripcionCausal;
    }
    public List<String> getListaDocumentos() {
        return listaDocumentos;
    }
    public void setListaDocumentos(List<String> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCompanyid() {
        return companyid;
    }
    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    
}

@Converter
class StringListConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting list to JSON", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to list", e);
        }
    }
}
