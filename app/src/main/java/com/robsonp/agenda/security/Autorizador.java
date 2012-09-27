package com.robsonp.agenda.security;

import br.gov.frameworkdemoiselle.security.Authorizer;
import com.robsonp.agenda.domain.Perfil;
import javax.inject.Inject;

public class Autorizador implements Authorizer {

    @Inject
    private Credentials credentials;
    
    @Override
    public boolean hasRole(String identificadorPerfil) {
        for(Perfil perfil : credentials.getUsuario().getPerfis()) {
            if(perfil.getIdentificador().equals(identificadorPerfil))
                return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(String resource, String operation) {
        return false;
    }
    
}
