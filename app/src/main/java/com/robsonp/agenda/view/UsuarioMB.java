package com.robsonp.agenda.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.robsonp.agenda.domain.Usuario;
import com.robsonp.agenda.domain.repository.UsuarioRepository;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang.StringUtils;
import org.primefaces.event.SelectEvent;

@ViewController
public class UsuarioMB {
    
    @Inject
    private UsuarioRepository usuarioRepository;
    
    private Usuario usuario;

    @Inject
    private MessageContext messageContext;
    
    public List<Usuario> getList(){
        return usuarioRepository.getAll();
    }
    
    public Usuario getUsuario() {
        if(usuario == null)
            usuario = new Usuario();
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getPerfis(){
        if(usuario == null || usuario.getPerfis().isEmpty())
            return "Nenhum perfil vinculado";
        return StringUtils.join(usuario.getPerfis(), ",");
    }
    
    @Transactional
    public void salvar(){
        try{
            usuarioRepository.store(usuario);
            messageContext.add("Adicionado com sucesso", SeverityType.INFO);
        }catch(Exception e){
            messageContext.add(e.getMessage(), SeverityType.ERROR);
        }
    }
    
    public void onRowSelect(SelectEvent event) {
        usuario = (Usuario) event.getObject();
    }
    
    public void novo(){
        usuario = new Usuario();    
    }
}
