package com.robsonp.agenda.infra;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Perfil;
import com.robsonp.agenda.domain.repository.PerfilRepository;
import javax.inject.Inject;

@Controller
public class CriaPerfisPadrao {
    
    @Inject
    private PerfilRepository perfilRepository;
    
    @Startup
    @Transactional
    public void execute(){
        if(perfilRepository.getAll().isEmpty()) {
            Perfil administrador = new Perfil("adm", "Administrador");
            perfilRepository.store(administrador);
            
            Perfil desenvolvedor = new Perfil("dev", "Desenvolvedor");
            perfilRepository.store(desenvolvedor);
            
            Perfil gerente = new Perfil("ger", "Gerente");
            perfilRepository.store(gerente);
        }
    }
}
