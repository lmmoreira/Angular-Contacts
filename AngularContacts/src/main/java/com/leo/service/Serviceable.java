package com.leo.service;

import java.util.List;

public interface Serviceable<T, E> {

	public List<T> findAll();
    public T findById(E Id);
    public void save(T o);
    public void delete(E Id);
	
}
