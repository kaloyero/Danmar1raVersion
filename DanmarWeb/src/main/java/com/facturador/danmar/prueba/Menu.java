package com.facturador.danmar.prueba;

import com.danmar.dbf.dao.impl.ClienteDao;


public class Menu {

	public static void main(String[] args) {
		ClienteDao dao =  new ClienteDao();
		dao.getAll();
	}
}
