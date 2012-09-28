package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Local;
import com.robsonp.agenda.domain.repository.LocalRepository;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class LocalMB {
    
    private Local local;
    
    @Inject 
    private MessageContext messageContext;
    
    @Inject
    private LocalRepository localRepository;

    public List<Local> getList(){
        return localRepository.getAll();
    }
    
    public Local getLocal() {
        if (local == null) {
            local = new Local();
        }
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Transactional
    public void salvar() {
        try {
            localRepository.store(local);
            messageContext.add("Local salvo com sucesso", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("ERRO: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    @Transactional
    public void remover() {
        try {
            localRepository.remove(local.getId());
            messageContext.add("Local removido com sucesso", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("ERRO: " + e.getMessage(), SeverityType.ERROR);
        }
    }

    public List<Local> filtrarPorNome(String partialName) {
        return localRepository.getComNomeContendo(partialName);
    }
    
    public void novo() {
        local = new Local();
    }
    
    public void onRowSelect(SelectEvent event) {
        local = (Local) event.getObject();
    }
}
    