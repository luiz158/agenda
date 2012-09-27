package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Objetivo;
import java.util.List;

public interface ObjetivoRepository extends GenericRepository<Objetivo, Integer> {

    public List<Objetivo> getComNomeContendo(String partialName);
    
}
