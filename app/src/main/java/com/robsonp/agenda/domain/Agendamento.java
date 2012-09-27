package com.robsonp.agenda.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name="agendamento_seq", allocationSize=1)
public class Agendamento {
    
    @Id
    @Column
    @GeneratedValue(generator="agendamento_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String descricao;
    
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date termino;
    
    @ManyToOne
    private Objetivo objetivo;
    
    @ManyToOne
    private Recurso recurso;
    
    @ManyToOne
    private Projeto projeto;

    public Agendamento() {
    }

    public Agendamento(Date inicio, Date termino) {
        this.inicio = inicio;
        this.termino = termino;
    }
    public Agendamento(String descricao, Date inicio, Date termino, Objetivo objetivo, Recurso recurso, Projeto projeto) {
        this.descricao = descricao;
        this.inicio = inicio;
        this.termino = termino;
        this.objetivo = objetivo;
        this.recurso = recurso;
        this.projeto = projeto;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
}
