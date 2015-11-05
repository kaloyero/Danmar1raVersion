package com.facturador.danmar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.model.DocumentoEncabezado;

@Repository("documentoEncabezadoDao")
public class DocumentoEncabezadoDaoImpl implements DocumentoEncabezadoDao {

	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(DocumentoEncabezado ent){
		this.sessionFactory.getCurrentSession().save(ent);
	}

	@Transactional
	public List<DocumentoEncabezado> getAll(){
		return this.sessionFactory.getCurrentSession().createQuery("from Kiosko").list();
	}



}
