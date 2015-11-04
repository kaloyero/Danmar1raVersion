package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danmar.dbf.service.ClienteService;
import com.danmar.dbf.service.impl.ClienteServiceImpl;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.mapper.ClienteMapper;
import com.facturador.danmar.manager.ClienteManager;

@Service("clienteManager")
public class ClienteManagerImpl implements ClienteManager{

	protected ClienteService getService(){
		return new ClienteServiceImpl();
	}

	protected ClienteMapper getMapper(){
		return new ClienteMapper();
	}
	
	public List<ClienteForm> getAll(int pagina, int cantRegistros) {
		return getMapper().getFormList(getService().getAll(pagina, cantRegistros));
	}   

	public List<ClienteForm> getAll() {
		return getMapper().getFormList(getService().getAll());
	}   

	public ClienteForm getById(int numero) {
		return getMapper().getForm(getService().getById(numero));
	}   
	
	
}
