package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Projeto;
import com.robsonp.agenda.domain.repository.ProjetoRepository;
import java.util.List;
import javax.persistence.Query;

@PersistenceController
public class ProjetoDAO extends JPACrud<Projeto, Integer> implements ProjetoRepository {

    @Override
    public List<Projeto> getAll() {
        return findAll();
    }

    @Override
    public void add(Projeto projeto) {
        if(projeto.getId() == null)
            insert(projeto);
        else
            update(projeto);
    }

    @Override
    public Projeto get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        delete(id);
    }

    @Override
    public List<Projeto> getComNomeContendo(String partialName) {
        Query qry = createQuery("select p from Projeto p where upper(p.nome) like upper(:partialName)");
        qry.setParameter("partialName", "%".concat(partialName).concat("%"));
        return qry.getResultList();
    }
    
}
