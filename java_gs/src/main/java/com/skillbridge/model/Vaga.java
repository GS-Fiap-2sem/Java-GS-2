package com.skillbridge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idEmpresa;

    @NotBlank
    private String titulo;

    @Column(length = 2000)
    private String descricao;

    private String localizacao;

    private Double remuneracao;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Long idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public Double getRemuneracao() { return remuneracao; }
    public void setRemuneracao(Double remuneracao) { this.remuneracao = remuneracao; }
}
