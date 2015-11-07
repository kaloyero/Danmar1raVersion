package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.PaginacionDao;
import com.danmar.dbf.service.PaginacionService;

public abstract class PaginacionServiceImpl<E> implements PaginacionService<E>{

	protected abstract PaginacionDao<E> getDao();
	
	public List<E> getAll(int pagina, int cantRegistros) {
		return getDao().getAll(pagina, cantRegistros);
	}   
	
}
