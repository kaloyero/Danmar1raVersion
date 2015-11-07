package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.ClienteDto;

public interface ClienteService extends PaginacionService<ClienteDto>{

	List<ClienteDto> getAll(); 

	public ClienteDto getById(int numero);
}
