package com.robsonp.agenda.view.converter;

import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Projeto;
import com.robsonp.agenda.domain.Recurso;
import com.robsonp.agenda.domain.repository.RecursoRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="recursoConverter")
public class RecursoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        RecursoRepository recursoRepository = Beans.getReference(RecursoRepository.class);
        
        if (string == null)
            return null;
        
        Integer id = new Integer(string);
        return recursoRepository.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Recurso)o).getId().toString();
    }
    
}
