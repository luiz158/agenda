package com.robsonp.agenda.view.converter;

import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Objetivo;
import com.robsonp.agenda.domain.repository.ObjetivoRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="objetivoConverter")
public class ObjetivoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ObjetivoRepository objetivoRepository = Beans.getReference(ObjetivoRepository.class);
        
        if (string == null)
            return null;
        
        Integer id = new Integer(string);
        return objetivoRepository.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Objetivo)o).getId().toString();
    }
    
}
