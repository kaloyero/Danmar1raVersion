package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;

public interface ArticuloService {

	public List<ArticuloDto> getAll(int pagina, int cantRegistros);
	public ArticuloDto getById(String articulo);
	public  List<ArticuloDto> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros);
}
