package com.facturador.danmar.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.common.ErrorRespuestaBean;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.DocumentoEncabezadoForm;

public interface IDummyController {

	@RequestMapping(value = "/DocumentoEncabezado/save", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") DocumentoEncabezadoForm form,BindingResult result, HttpServletRequest request) throws ParseException;
	
	@RequestMapping(value = "/cliente/findAll/{pagina}/{cantRegistros}", method = RequestMethod.GET)
	public @ResponseBody	List<ClienteForm> findAllClientes(@PathVariable Integer pagina,@PathVariable Integer cantRegistros) ;
	
	@RequestMapping(value = "/cliente/searchByFiltro/{filtro}/{pagina}/{cantRegistros}", method = RequestMethod.GET)
	public @ResponseBody List<ClienteForm> searchClientesByFiltro(@PathVariable String filtro,@PathVariable Integer pagina,@PathVariable Integer cantRegistros) ;

	@RequestMapping(value = "/cliente/getById/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo);
	
	@RequestMapping(value = "/articulo/findAll/{pagina}/{cantRegistros}", method = RequestMethod.GET)
	public @ResponseBody	List<ArticuloForm> findAllArticulos(@PathVariable Integer pagina,@PathVariable Integer cantRegistros);
	
	@RequestMapping(value = "/articulo/searchByFiltro/", method = RequestMethod.POST)
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody  String nombre,@RequestBody  Integer pagina,@RequestBody  Integer cantRegistros);

	@RequestMapping(value = "/articulo/searchByFiltros", method = RequestMethod.POST)
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody FiltroArticulo filtro,@RequestBody Integer pagina,@RequestBody Integer cantRegistros) throws ParseException;

	@RequestMapping(value = "/articulo/getById/{nombre}", method = RequestMethod.GET)
	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String nombre) ;
}
