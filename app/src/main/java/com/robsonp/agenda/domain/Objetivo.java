package com.robsonp.agenda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Objetivo {
    
    @Id
    @Column
    @SequenceGenerator(name="objetivo_seq", allocationSize=1)
    @GeneratedValue(generator="objetivo_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String descricao;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}   
