package com.robsonp.agenda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Local implements Serializable {
    
    @Id
    @SequenceGenerator(name="local_seq", allocationSize=1)
    @GeneratedValue(generator="local_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String nome;

    public Local() {
    }

    public Local(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
