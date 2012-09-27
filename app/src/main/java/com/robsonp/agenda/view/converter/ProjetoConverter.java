package com.robsonp.agenda.view.converter;

import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Projeto;
import com.robsonp.agenda.domain.repository.ProjetoRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="projetoConverter")
public class ProjetoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ProjetoRepository projetoRepository = Beans.getReference(ProjetoRepository.class);
        
        if (string == null)
            return null;
        
        Integer id = new Integer(string);
        return projetoRepository.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Projeto)o).getId().toString();
    }
    
}
