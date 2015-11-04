package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.ClienteDao;
import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.service.ClienteService;

public class ClienteServiceImpl implements ClienteService{

    
	ClienteDao dao = new ClienteDao();
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	public List<ClienteDto> getAll(int pagina, int cantRegistros) {
		return dao.getAll(pagina, cantRegistros);
	}   

	public List<ClienteDto> getAll() {
		return dao.getAll();
	}   

	public ClienteDto getById(int numero) {
		return dao.getById(numero);
	}   
	
	
}
