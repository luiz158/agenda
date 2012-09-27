package com.robsonp.agenda.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import com.robsonp.agenda.domain.Usuario;
import com.robsonp.agenda.domain.repository.UsuarioRepository;
import java.util.List;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Integer> implements UsuarioRepository {

    @Override
    public List<Usuario> getAll() {
        return findAll();
    }

    @Override
    public void store(Usuario bean) {
        
        if (bean.getId() == null) {
            insert(bean);
        } else {
            update(bean);
        }
    }

    @Override
    public Usuario get(Integer id) {
        return load(id);
    }

    @Override
    public void remove(Integer id) {
        remove(id);
    }

    @Override
    public Usuario getByEmail(String email) {
        List<Usuario> resultList = createQuery("select this from Usuario this where this.email = :email")
                .setParameter("email", email)
                .getResultList();
        
        if(resultList.isEmpty())
            return null;
        
        return resultList.get(0);
    }
}
