package com.facturador.danmar.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.model.Kiosko;

@Repository("kioskoDao")
public class KioskoDao {

	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insert(Kiosko product){
		this.sessionFactory.getCurrentSession().save(product);
	}

	@Transactional
	public List<Kiosko> getAll(){
		return this.sessionFactory.getCurrentSession().createQuery("from Kiosko").list();
	}

}
