package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Local;
import com.robsonp.agenda.domain.repository.LocalRepository;
import java.util.List;

@PersistenceController
public class LocalDAO extends JPACrud<Local, Integer> implements LocalRepository {

    @Override
    public List<Local> getAll() {
        return findAll();
    }

    @Override
    public void store(Local bean) {
        if(bean.getId() == null)
            insert(bean);
        else
            update(bean);
    }

    @Override
    public Local get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        remove(id);
    }

    @Override
    public List<Local> getComNomeContendo(String partialName) {
        return createQuery("select this from Local this where upper(this.nome) like upper(:nome)")
                .setParameter("nome", "%"+partialName+"%")
                .getResultList();
    }
    
}
