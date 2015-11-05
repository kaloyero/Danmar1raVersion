package com.facturador.danmar.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.common.ErrorRespuestaBean;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.manager.ArticuloManager;
import com.facturador.danmar.manager.ClienteManager;
import com.facturador.danmar.manager.DocumentoEncabezadoManager;
import com.facturador.danmar.manager.TarjetaManager;


@Controller
public class DummyPostaController implements IDummyController{

	
	@Autowired
	ArticuloManager articuloManager;
	
	@Autowired
	TarjetaManager tarjetaManager;
	
	@Autowired
	ClienteManager clienteManager;

	@Autowired
	DocumentoEncabezadoManager documentoEncabezadoManager;
	
	@RequestMapping("/Probando")
	public ModelAndView getVersion(){
		return new ModelAndView("version");
	}

	@Override
	public List<ClienteForm> findAllClientes(Integer pagina,
			Integer cantRegistros) {
		return clienteManager.getAll();
	}


	@Override
	public List<ClienteForm> searchClientesByFiltro(String filtro,
			Integer pagina, Integer cantRegistros) {
		return clienteManager.getAll();
	}
	
	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo) {
		return clienteManager.getById(codigo);
	}
	
	public @ResponseBody	List<ArticuloForm> findAllArticulos(@PathVariable Integer pagina,@PathVariable Integer cantRegistros) {
		return articuloManager.getAll(pagina, cantRegistros);
	}
	
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody  String nombre,@RequestBody  Integer pagina,@RequestBody  Integer cantRegistros) {
		return articuloManager.searchByNombre(nombre, pagina, cantRegistros);
	}

	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody FiltroArticulo filtro,@RequestBody Integer pagina,@RequestBody Integer cantRegistros) throws ParseException{
		return articuloManager.searchByFiltros(filtro, pagina, cantRegistros);
	}

	
	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String nombre) {
		return articuloManager.getById(nombre);
	}

	@Override
	public ErrorRespuestaBean guardar(DocumentoEncabezadoForm form,
			BindingResult result, HttpServletRequest request)
			throws ParseException {
		return documentoEncabezadoManager.save(form);
	}

	@RequestMapping(value = "/documento/prueba", method = RequestMethod.GET)
	public @ResponseBody	String guardarPrueba() {
		DocumentoEncabezadoForm form = new DocumentoEncabezadoForm();
		
		documentoEncabezadoManager.save(form);
		return ("OK");
	}


	
}
