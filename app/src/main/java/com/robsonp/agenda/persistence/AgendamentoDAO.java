package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Agendamento;
import com.robsonp.agenda.domain.Recurso;
import com.robsonp.agenda.domain.repository.AgendamentoRepository;
import java.util.ArrayList;
import java.util.List;

@PersistenceController
public class AgendamentoDAO extends JPACrud<Agendamento, Integer> implements AgendamentoRepository {

    @Override
    public List<Agendamento> getAll() {
        return findAll();
    }

    @Override
    public void add(Agendamento agendamento) {
        if(agendamento.getId() == null)
            insert(agendamento);
        else
            update(agendamento);
    }

    @Override
    public Agendamento get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        delete(id);
    }

    @Override
    public List<Agendamento> getAllForResources(List<Recurso> recursos) {
        List ids = new ArrayList();
        for (Recurso recurso : recursos) {
            ids.add(recurso.getId());
        }
        return createQuery("select this from Agendamento this where this.recurso.id in :recursos")
                .setParameter("recursos", ids)
                .getResultList();
    }
    
}
