package com.facturador.danmar.bean;

import java.util.List;

import com.danmar.dbf.dao.impl.ClienteDao;

public class Menu {

	
	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		List ah =dao.getAll();
		System.out.println("");
	
	}
	
}
