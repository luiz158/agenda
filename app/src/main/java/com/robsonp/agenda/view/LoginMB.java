package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.naming.AuthenticationException;

@ViewController
public class LoginMB {
    private String email;
    private String senha;

    @Inject
    private SecurityContext securityContext;
    
    @Inject
    private MessageContext messageContext;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void doLogin(){
        try {
            if(Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(senha))
                throw new AuthenticationException("Campo e-mail ou senha não foram preenchidos");
            securityContext.login();
            
            if(!securityContext.isLoggedIn())
                throw new AuthenticationException("Campo e-mail ou senha estão incorretos");
            
        } catch (AuthenticationException e) {
            messageContext.add(e.getMessage(), SeverityType.WARN);
        } catch (Exception e) {
            messageContext.add(e.getMessage(), SeverityType.ERROR);
        }
    }
}
