package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;

public interface ArticuloManager {

	public List<ArticuloForm> getAll(int pagina, int cantRegistros);

	public ArticuloForm getById(String articulo);   
	    
	public  List<ArticuloForm> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros);
	
	public  List<ArticuloForm> searchByNombre(String nombre,int pagina, int cantRegistros);
	
}   
	    
