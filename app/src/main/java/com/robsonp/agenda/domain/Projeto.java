package com.robsonp.agenda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="projeto_seq", allocationSize=1)
public class Projeto implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator="projeto_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
