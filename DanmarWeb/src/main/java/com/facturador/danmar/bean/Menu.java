package com.facturador.danmar.bean;

import com.danmar.dbf.dao.ClienteDao;

public class Menu {

	
	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		dao.getAll();
	}
	
}
