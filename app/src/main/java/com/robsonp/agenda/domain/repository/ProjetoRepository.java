package com.robsonp.agenda.domain.repository;

import com.robsonp.agenda.domain.Projeto;
import java.util.List;

public interface ProjetoRepository {
    public List<Projeto> getAll();
    public void add(Projeto projeto);
    public Projeto get(Integer id);
    public void remove(Integer id);

    public List<Projeto> getComNomeContendo(String partialName);
}
