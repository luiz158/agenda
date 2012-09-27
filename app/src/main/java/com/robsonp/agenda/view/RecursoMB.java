package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Recurso;
import com.robsonp.agenda.domain.repository.RecursoRepository;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class RecursoMB {
    
    @Inject
    private RecursoRepository recursoRepository; 
    
    private Recurso recurso;
    
    @Inject
    private MessageContext messageContext;
    
    public List<Recurso> getList(){
        return recursoRepository.getAll();
    }

    public Recurso getRecurso() {
        if(recurso == null) {
            recurso = new Recurso();
        }
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    
    @Transactional
    public void salvar(){
        try {
            recursoRepository.store(recurso);
            messageContext.add("Recurso adicionado.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            recursoRepository.remove(recurso.getId());
            messageContext.add("Recurso removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void criarRecurso(){
        recurso = new Recurso();
    }
    
    public List<Recurso> filtrarPorNome(String partialName){
        return recursoRepository.getComNomeContendo(partialName);
    }
    
    public void onRowSelect(SelectEvent event){
        recurso = (Recurso) event.getObject();
    }
}
