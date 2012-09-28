package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Projeto;
import com.robsonp.agenda.domain.repository.ProjetoRepository;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

@ViewController
public class ProjetoMB {
    
    @Inject
    private ProjetoRepository projetoRepository; 
    
    private Projeto projeto;
    
    @Inject
    private MessageContext messageContext;
    
    public List<Projeto> getList(){
        return projetoRepository.getAll();
    }

    public Projeto getProjeto() {
        if(projeto == null) {
            projeto = new Projeto();
        }
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    @Transactional
    public void salvar(){
        try {
            projetoRepository.add(projeto);
            messageContext.add("Projeto adicionado.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    @Transactional
    public void excluir(){
        try {
            projetoRepository.remove(projeto.getId());
            messageContext.add("Projeto removido.", SeverityType.INFO);
        } catch (Exception e) {
            messageContext.add("Erro: " + e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public List<Projeto> filtrarPorNome(String partialName){
        return projetoRepository.getComNomeContendo(partialName);
    }
    
    public void onRowSelect(SelectEvent event) {
        projeto = (Projeto) event.getObject();
    }
    
    public void novo(){
        projeto = new Projeto();
    }
}
