package com.robsonp.agenda.security;

import com.robsonp.agenda.domain.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Credentials implements Serializable {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
