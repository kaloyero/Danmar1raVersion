package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.ArticuloDao;
import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.dbf.service.ArticuloService;

public class ArticuloServiceImpl implements ArticuloService{

    
	ArticuloDao dao = new ArticuloDao();
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	public List<ArticuloDto> getAll(int pagina, int cantRegistros) {
		return dao.getAll(pagina, cantRegistros);
	}   

	public ArticuloDto getById(String articulo) {
		return dao.getById(articulo);
	}   
	    
	public  List<ArticuloDto> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros) {
		return dao.searchByFiltros(filtro,pagina,cantRegistros);
	}   
	    
	
	
}
