package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.PaginacionDao;
import com.danmar.dbf.dao.impl.ClienteDao;
import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.service.ClienteService;

public class ClienteServiceImpl extends PaginacionServiceImpl<ClienteDto> implements ClienteService{

    
	ClienteDao dao = new ClienteDao();

	protected PaginacionDao<ClienteDto> getDao() {
		return dao;
	}   
	
	public List<ClienteDto> getAll() {
		return dao.getAll();
	}   

	public ClienteDto getById(int numero) {
		return dao.getById(numero);
	}

	
	
}
