package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Perfil;
import com.robsonp.agenda.domain.repository.PerfilRepository;
import java.util.List;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Integer> implements PerfilRepository {

    @Override
    public List<Perfil> getAll() {
        return findAll();
    }

    @Override
    public void store(Perfil bean) {
        if(bean.getId() == null)
            insert(bean);
        else
            update(bean);
    }

    @Override
    public Perfil get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        remove(id);
    }
    
}
