package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.dbf.service.ArticuloService;
import com.danmar.dbf.service.impl.ArticuloServiceImpl;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.mapper.ArticuloMapper;
import com.facturador.danmar.manager.ArticuloManager;

@Service("articuloManager")
public class ArticuloManagerImpl implements ArticuloManager{

    
	protected ArticuloService getService(){
		return new ArticuloServiceImpl();
	}

	protected ArticuloMapper getMapper(){
		return new ArticuloMapper();
	}

	public List<ArticuloForm> getAll(int pagina, int cantRegistros) {
		return getMapper().getFormList(getService().getAll(pagina, cantRegistros));
	}   

	public ArticuloForm getById(String articulo) {
		return getMapper().getForm(getService().getById(articulo));
	}   
	    
	public  List<ArticuloForm> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros) {
		return getMapper().getFormList(getService().searchByFiltros(filtro,pagina,cantRegistros));
	}

	@Override
	public List<ArticuloForm> searchByNombre(String nombre, int pagina,
			int cantRegistros) {
		FiltroArticulo filtro = new FiltroArticulo();
		filtro.setArticulo(nombre);
		return getMapper().getFormList(getService().searchByFiltros(filtro,pagina,cantRegistros));
	}   
	
}
