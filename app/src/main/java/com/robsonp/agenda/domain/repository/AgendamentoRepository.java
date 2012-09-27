package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Agendamento;
import java.util.List;

public interface AgendamentoRepository {
    public List<Agendamento> getAll();
    public Agendamento get(Integer id);
    public void add(Agendamento agendamento);
    public void remove(Integer id);
}
