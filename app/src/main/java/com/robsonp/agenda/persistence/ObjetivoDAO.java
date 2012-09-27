package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Objetivo;
import com.robsonp.agenda.domain.repository.ObjetivoRepository;
import java.util.List;
import javax.persistence.Query;

public class ObjetivoDAO extends JPACrud<Objetivo, Integer> implements ObjetivoRepository {

    @Override
    public List<Objetivo> getComNomeContendo(String partialName) {
        Query qry = createQuery("select o from Objetivo o where upper(o.descricao) like upper(:partialName)");
        qry.setParameter("partialName", "%".concat(partialName).concat("%"));
        return qry.getResultList();
    }

    @Override
    public List<Objetivo> getAll() {
        return findAll();
    }

    @Override
    public void store(Objetivo bean) {
        if(bean.getId() == null)
            insert(bean);
        else
            update(bean);
    }

    @Override
    public Objetivo get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        remove(id);
    }
    
}
