package com.danmar.dbf.dao;

import java.util.List;

public interface IPaginacionDao<E> {
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	public List<E> getAll(int pagina, int cantRegistros);

}
