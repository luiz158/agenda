package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Local;
import java.util.List;

public interface LocalRepository extends GenericRepository<Local, Integer> {

    public List<Local> getComNomeContendo(String partialName);
    
        
}
