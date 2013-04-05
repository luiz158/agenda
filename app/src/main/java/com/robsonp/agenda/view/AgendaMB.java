package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Agendamento;
import com.robsonp.agenda.domain.Recurso;
import com.robsonp.agenda.domain.repository.AgendamentoRepository;
import com.robsonp.agenda.view.schedule.AgendamentoScheduleEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

@ViewController
public class AgendaMB {
    
    @Inject
    private AgendamentoRepository agendamentoRepository;
    
    private Agendamento agendamento;
    
    private ScheduleModel scheduleModel;

    @Inject
    private MessageContext messageContext;
    
    private List<Recurso> filtroRecursos = new ArrayList<Recurso>();

    public AgendaMB() {
    }
    
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public List<Recurso> getFiltroRecursos() {
        return filtroRecursos;
    }

    public void setFiltroRecursos(List<Recurso> filtroRecursos) {
        this.filtroRecursos = filtroRecursos;
    }

    public ScheduleModel getScheduleModel() {
        if(scheduleModel == null) 
            updateScheduleModel();
        return scheduleModel;
    }

    public void setScheduleModel(ScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        agendamento = ((AgendamentoScheduleEvent) selectEvent.getObject()).getAgendamento();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        agendamento = new Agendamento();
        Date selectedDate = (Date) selectEvent.getObject();
        agendamento.setInicio(selectedDate);
        agendamento.setTermino(selectedDate);
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

    public void updateScheduleModel() {
        List<Agendamento> agendamentos = null;
        if(filtroRecursos.isEmpty())
            agendamentos = agendamentoRepository.getAll();
        else
            agendamentos = agendamentoRepository.getAllForResources(filtroRecursos);
            
        
        scheduleModel = new DefaultScheduleModel();
        for(Agendamento ag : agendamentos){
            AgendamentoScheduleEvent event = new AgendamentoScheduleEvent(ag);
            scheduleModel.addEvent(event);
        }
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
            updateScheduleModel();
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            agendamentoRepository.remove(agendamento.getId());
            messageContext.add("Agendameto removido", SeverityType.INFO);
            updateScheduleModel();
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void refreshAgenda(AjaxBehaviorEvent event) {
        updateScheduleModel();
    }
    
    
}
