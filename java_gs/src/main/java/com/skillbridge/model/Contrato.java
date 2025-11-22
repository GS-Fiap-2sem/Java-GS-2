package com.skillbridge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idVaga;

    @NotNull
    private Long idAluno;

    private String status;
    private String dataInicio;
    private String dataFim;

    private Integer notaEmpresa;
    private Integer notaAluno;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdVaga() { return idVaga; }
    public void setIdVaga(Long idVaga) { this.idVaga = idVaga; }

    public Long getIdAluno() { return idAluno; }
    public void setIdAluno(Long idAluno) { this.idAluno = idAluno; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }

    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }

    public Integer getNotaEmpresa() { return notaEmpresa; }
    public void setNotaEmpresa(Integer notaEmpresa) { this.notaEmpresa = notaEmpresa; }

    public Integer getNotaAluno() { return notaAluno; }
    public void setNotaAluno(Integer notaAluno) { this.notaAluno = notaAluno; }
}
