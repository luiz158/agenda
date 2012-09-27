package com.robsonp.agenda.domain.repository;

import java.util.List;

public interface GenericRepository<T, K> {
    public List<T> getAll();
    public void store(T beans);
    public T get(K id);
    public void remove(K id);
}
