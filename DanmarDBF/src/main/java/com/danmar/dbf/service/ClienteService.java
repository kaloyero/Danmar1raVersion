package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.ClienteDto;

public interface ClienteService {

	List<ClienteDto> getAll(int pagina, int cantRegistros);
	
	List<ClienteDto> getAll(); 

	public ClienteDto getById(int numero);
}
