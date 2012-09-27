package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Agendamento;
import com.robsonp.agenda.domain.repository.AgendamentoRepository;
import com.robsonp.agenda.view.schedule.AgendamentoScheduleEvent;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.MenuModel;
import org.primefaces.model.ScheduleModel;

@ViewController
public class AgendaMB {
    
    @Inject
    private AgendamentoRepository agendamentoRepository;
    
    private Agendamento agendamento;
    
    private ScheduleModel scheduleModel;

    @Inject
    private MessageContext messageContext;
    
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public ScheduleModel getScheduleModel() {
        if(scheduleModel == null) 
            updateScheduleModel();
        return scheduleModel;
    }

    public void setScheduleModel(ScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    }
    
    public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {
        agendamento = ((AgendamentoScheduleEvent) selectEvent.getScheduleEvent()).getAgendamento();
    }

    public void onDateSelect(DateSelectEvent selectEvent) {
        agendamento = new Agendamento();
        agendamento.setInicio(selectEvent.getDate());
        agendamento.setTermino(selectEvent.getDate());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        agendamento = ((AgendamentoScheduleEvent) event.getScheduleEvent()).getAgendamento();
        agendamento.setInicio(event.getScheduleEvent().getStartDate());
        agendamento.setTermino(event.getScheduleEvent().getEndDate());
        agendamentoRepository.add(agendamento);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        agendamento = ((AgendamentoScheduleEvent) event.getScheduleEvent()).getAgendamento();
        agendamento.setInicio(event.getScheduleEvent().getStartDate());
        agendamento.setTermino(event.getScheduleEvent().getEndDate());
        agendamentoRepository.add(agendamento);
    }

    private void updateScheduleModel() {
        List<Agendamento> agendamentos = agendamentoRepository.getAll();
        
        scheduleModel = new DefaultScheduleModel();
        for(Agendamento ag : agendamentos)
            scheduleModel.addEvent(new AgendamentoScheduleEvent(ag));
    }
    
    public void criarAgendamento(){
        Date hoje = new Date();
        agendamento = new Agendamento(hoje, hoje);
    }
    
    @Transactional
    public void salvar(){
        try {
            agendamentoRepository.add(agendamento);
            messageContext.add("Agendameto adicionado", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            agendamentoRepository.remove(agendamento.getId());
            messageContext.add("Agendameto removido", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
}
