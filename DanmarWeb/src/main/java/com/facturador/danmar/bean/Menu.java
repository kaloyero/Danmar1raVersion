package com.facturador.danmar.bean;

import java.util.List;

import com.danmar.dbf.dao.impl.ArticuloDao;
import com.danmar.dbf.dto.filtro.FiltroArticulo;

public class Menu {

	
	public static void main(String[] args) {
		ArticuloDao dao = new ArticuloDao();
		System.out.println("abre");
		List ah =dao.getAll(1000,50);
		System.out.println("cierra");
		FiltroArticulo filtro = new FiltroArticulo();
    	
    	filtro.setCc1("C6");
    	filtro.setCc2("23");
    	filtro.setCc3("0710");
    	filtro.setTipo("01");
    	System.out.println("Empieza");
    	dao.searchByFiltros(filtro,1000,50);
    	System.out.println("Termina");
		FiltroArticulo filtro1 = new FiltroArticulo();

    	System.out.println("Empieza");
    	dao.searchByFiltros(filtro1,1000,50);
    	System.out.println("Termina");
    	
	}
	
}
