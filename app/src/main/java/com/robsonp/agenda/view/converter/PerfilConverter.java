package com.robsonp.agenda.view.converter;

import br.gov.frameworkdemoiselle.util.Beans;
import com.robsonp.agenda.domain.Perfil;
import com.robsonp.agenda.domain.repository.PerfilRepository;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="perfilConverter")
public class PerfilConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        PerfilRepository perfilRepository = Beans.getReference(PerfilRepository.class);
        
        if (string == null)
            return null;
        
        Integer id = new Integer(string);
        return perfilRepository.get(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Perfil)o).getId().toString();
    }
    
}
