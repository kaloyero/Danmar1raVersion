package com.danmar.dbf.service;

import java.util.List;

public interface PaginacionService <E> {
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	List<E> getAll(int pagina, int cantRegistros);
}
