package com.robsonp.agenda.security;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import com.robsonp.agenda.domain.Usuario;
import com.robsonp.agenda.domain.repository.UsuarioRepository;
import com.robsonp.agenda.security.util.Encrypt;
import com.robsonp.agenda.view.LoginMB;
import javax.inject.Inject;

public class Autenticador implements Authenticator {

    @Inject
    private Credentials credentials;
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    @Inject
    private LoginMB loginMB;

    @Override
    public boolean authenticate() {
        Usuario usuario = usuarioRepository.getByEmail(loginMB.getEmail());
        if(usuario == null)
            return false;
        
        String senhaUsuario = usuario.getSenha();
        String senhaInformadaEncriptada = Encrypt.md5(loginMB.getSenha());
        if(senhaUsuario.equals(senhaInformadaEncriptada)) {
            credentials.setUsuario(usuario);
            return true;
        }
        return false;
    }

    @Override
    public void unAuthenticate() {
        credentials.setUsuario(null);
    }

    @Override
    public User getUser() {
        if(credentials.getUsuario() == null)
            return null;
        
        return new User() {

            @Override
            public String getId() {
                return credentials.getUsuario().getEmail();
            }

            @Override
            public Object getAttribute(Object o) {
                return null;
            }

            @Override
            public void setAttribute(Object o, Object o1) {}
        };
    }
}
