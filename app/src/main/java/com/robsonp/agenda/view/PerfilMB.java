package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import com.robsonp.agenda.domain.Perfil;
import com.robsonp.agenda.domain.repository.PerfilRepository;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class PerfilMB {
    
    @Inject
    private PerfilRepository perfilRepository;
    
    public List<Perfil> getList(){
        return perfilRepository.getAll();
    }
}
