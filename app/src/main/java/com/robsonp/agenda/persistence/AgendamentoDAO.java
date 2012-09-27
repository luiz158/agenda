package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Agendamento;
import com.robsonp.agenda.domain.repository.AgendamentoRepository;
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
    
}
