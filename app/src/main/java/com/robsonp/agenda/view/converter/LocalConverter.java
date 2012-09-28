package com.robsonp.agenda.view.converter;

import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Local;
import com.robsonp.agenda.domain.repository.LocalRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="localConverter")
public class LocalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        LocalRepository localRepository = Beans.getReference(LocalRepository.class);
        
        if (string == null)
            return null;
        
        Integer id = new Integer(string);
        return localRepository.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Local) o).getId().toString();
    }
    
}
