package com.robsonp.agenda.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Perfil implements Serializable {
    
    @Id
    @Column
    @SequenceGenerator(name="perfil_seq", allocationSize=1)
    @GeneratedValue(generator="perfil_seq", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String identificador;
    
    @Column
    private String nome;

    public Perfil() {
    }

    public Perfil(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nome;
    }
    
}
