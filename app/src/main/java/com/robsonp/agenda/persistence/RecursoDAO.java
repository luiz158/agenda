package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Recurso;
import com.robsonp.agenda.domain.repository.RecursoRepository;
import java.util.List;
import javax.persistence.Query;

public class RecursoDAO extends JPACrud<Recurso, Integer> implements RecursoRepository {

    @Override
    public List<Recurso> getComNomeContendo(String partialName) {
        Query qry = createQuery("select r from Recurso r where upper(r.nome) like upper(:partialName)");
        qry.setParameter("partialName", "%".concat(partialName).concat("%"));
        return qry.getResultList();
    }

    @Override
    public List<Recurso> getAll() {
        return findAll();
    }

    @Override
    public void store(Recurso bean) {
        if(bean.getId() == null)
            insert(bean);
        else
            update(bean);
    }

    @Override
    public Recurso get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        remove(id);
    }
    
}
