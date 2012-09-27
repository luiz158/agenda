package com.robsonp.agenda.view.schedule;

import com.robsonp.agenda.domain.Agendamento;
import org.primefaces.model.DefaultScheduleEvent;

public class AgendamentoScheduleEvent extends DefaultScheduleEvent {

    private Agendamento agendamento;
    
    public AgendamentoScheduleEvent(Agendamento agendamento) {
        this.agendamento = agendamento;
        setStartDate(agendamento.getInicio());
        setEndDate(agendamento.getTermino());
        setTitle(agendamento.getObjetivo() + " em " + agendamento.getProjeto());
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }
    
}
