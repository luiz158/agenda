package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Recurso;
import java.util.List;

public interface RecursoRepository extends GenericRepository<Recurso, Integer> {

    public List<Recurso> getComNomeContendo(String partialName);
    
}
