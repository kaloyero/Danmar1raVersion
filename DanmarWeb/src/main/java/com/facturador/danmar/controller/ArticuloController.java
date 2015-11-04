package com.facturador.danmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.manager.ArticuloManager;


@Controller
public class ArticuloController {

//	@Autowired
//	ArticuloManager articuloManager;
	
//	@RequestMapping(value = "/articulo/findAll", method = RequestMethod.GET)
//	public @ResponseBody	List<ArticuloForm> findAllArticulos() {
//		return getArticulos();
//	}
//	
//	@RequestMapping(value = "/articulo/searchByFiltro/{filtro}", method = RequestMethod.GET)
//	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@PathVariable String filtro) {
//		return getArticulos();
//	}
//
//	@RequestMapping(value = "/articulo/searchByFiltros/{filtro}", method = RequestMethod.GET)
//	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@PathVariable FiltroArticulo filtro) {
//		return getArticulos();
//	}
//
//	@RequestMapping(value = "/articulo/getById/{id}", method = RequestMethod.GET)
//	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String id) {
//		return getArticulo("C6","23","0710", "Solen.Arr.Indiel Chev.C-20","SOL.APL.CHEV.P.UP");
//	}

	
}
