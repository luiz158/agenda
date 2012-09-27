package com.robsonp.agenda.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {

    @Id
    @Column
    @GeneratedValue(generator="usuario_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name="usuario_seq", allocationSize=1)
    private Integer id;
    
    @Column
    private String nome;
    
    @Column
    private String email;
    
    @Column
    private String senha;
    
    @ManyToMany
    @JoinTable(name="usuario_perfil", 
            joinColumns=@JoinColumn(name = "usuario_id"), 
            inverseJoinColumns=@JoinColumn(name = "perfil_id"))
    private List<Perfil> perfis = new ArrayList<Perfil>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void alterarSenha(String novaSenha){
        senha = novaSenha;
    }
        
    public void vincularPerfil(Perfil perfil){
        perfis.add(perfil);
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

}
