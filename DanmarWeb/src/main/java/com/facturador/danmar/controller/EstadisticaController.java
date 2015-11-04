package com.facturador.danmar.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facturador.danmar.dao.KioskoDao;
import com.facturador.danmar.model.Kiosko;


@Controller
public class EstadisticaController {

	@Autowired
	KioskoDao kioskoDao;
	
	@RequestMapping("/kiosko")
	public ModelAndView product(){
		Kiosko p=new Kiosko();

		return new ModelAndView("createKiosko", "kioskoForm", p);
	}
	
	@RequestMapping("/addKiosko")
	@Transactional
	protected String addProduct(Kiosko kiosko, Model model) throws ServletException {

		kioskoDao.insert(kiosko);
		
		model.addAttribute("kioskos",kioskoDao.getAll());
		
		return "listKiosko";
	}
	
}
