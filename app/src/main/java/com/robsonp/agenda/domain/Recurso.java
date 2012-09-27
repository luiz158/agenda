package com.robsonp.agenda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="recurso_seq", allocationSize=1)
public class Recurso implements Serializable {
    
    @Id
    @Column
    @GeneratedValue(generator="recurso_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String nome; 
    
    private String email;
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
