package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Usuario;

public interface UsuarioRepository extends GenericRepository<Usuario, Integer> {
    public Usuario getByEmail(String email);
}
