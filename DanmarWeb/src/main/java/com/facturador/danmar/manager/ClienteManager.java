package com.facturador.danmar.manager;

import java.util.List;

import com.facturador.danmar.form.ClienteForm;

public interface ClienteManager {

	List<ClienteForm> getAll(int pagina, int cantRegistros);
	
	List<ClienteForm> getAll(); 

	ClienteForm getById(int numero);
}
