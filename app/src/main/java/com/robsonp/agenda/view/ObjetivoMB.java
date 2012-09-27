package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Objetivo;
import com.robsonp.agenda.domain.repository.ObjetivoRepository;
import java.util.List;
import javax.inject.Inject;

@ViewController
public class ObjetivoMB {
    
    private Objetivo objetivo;

    @Inject
    private MessageContext messageContext;
    
    @Inject
    private ObjetivoRepository objetivoRepository; 
    
    public Objetivo getObjetivo() {
        if(objetivo == null)
            objetivo = new Objetivo();
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    @Transactional
    public void salvar(){
        try {
            objetivoRepository.store(objetivo);
            messageContext.add("Objetivo salvo com sucesso", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("ERRO: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void remover(){
        try {
            objetivoRepository.remove(objetivo.getId());
            messageContext.add("Objetivo removido com sucesso", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("ERRO: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public List<Objetivo> filtrarPorNome(String partialName){
        return objetivoRepository.getComNomeContendo(partialName);
    }
    
    @Transactional
    public void salvar(boolean injetarNaAgenda){
        try {
            objetivoRepository.store(objetivo);
            if(injetarNaAgenda) {
                AgendaMB agendaMB = Beans.getReference(AgendaMB.class);
                if(objetivo.getId() != null && agendaMB.getAgendamento() != null) {
                    agendaMB.getAgendamento().setObjetivo(objetivo);
                }
            }
            messageContext.add("Objetivo salvo com sucesso", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("ERRO: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void novoObjetivo(){
        objetivo = new Objetivo();
    }
}
