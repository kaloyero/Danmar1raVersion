package com.facturador.danmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.manager.ArticuloManager;
import com.facturador.danmar.manager.ClienteManager;
import com.facturador.danmar.manager.TarjetaManager;


@Controller
public class DummyPostaController {

	
	@Autowired
	ArticuloManager articuloManager;
	
	@Autowired
	TarjetaManager tarjetaManager;
	
	@Autowired
	ClienteManager clienteManager;
	
	@RequestMapping("/Probando")
	public ModelAndView getVersion(){
		return new ModelAndView("version");
	}


	/**
	 * Busca todos los clientes disponibles
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cliente/findAll", method = RequestMethod.GET)
	public @ResponseBody	List<ClienteForm> findAllClientes() {
		return clienteManager.getAll();
	}
	
	@RequestMapping(value = "/cliente/searchByFiltro/{filtro}", method = RequestMethod.GET)
	public @ResponseBody List<ClienteForm> searchClientesByFiltro(@PathVariable String filtro) {
		return clienteManager.getAll();
	}

	@RequestMapping(value = "/cliente/getById/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo) {
		return clienteManager.getById(codigo);
	}
	
	@RequestMapping(value = "/articulo/findAll", method = RequestMethod.GET)
	public @ResponseBody	List<ArticuloForm> findAllArticulos(@PathVariable Integer pagina,@PathVariable Integer cantRegistros) {
		return articuloManager.getAll(pagina, cantRegistros);
	}
	
	@RequestMapping(value = "/articulo/searchByFiltro/{nombre}", method = RequestMethod.GET)
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@PathVariable String nombre,@PathVariable Integer pagina,@PathVariable Integer cantRegistros) {
		return articuloManager.searchByNombre(nombre, pagina, cantRegistros);
	}

	@RequestMapping(value = "/articulo/searchByFiltros/{filtro}", method = RequestMethod.GET)
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@PathVariable FiltroArticulo filtro,@PathVariable Integer pagina,@PathVariable Integer cantRegistros) {
		return articuloManager.searchByFiltros(filtro, pagina, cantRegistros);
	}

	@RequestMapping(value = "/articulo/getById/{nombre}", method = RequestMethod.GET)
	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String nombre) {
		return articuloManager.getById(nombre);
	}
	
}
