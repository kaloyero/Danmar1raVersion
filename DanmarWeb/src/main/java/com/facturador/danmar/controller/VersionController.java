package com.facturador.danmar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.facturador.danmar.model.Kiosko;
import com.facturador.danmar.service.UserService;

@Controller
public class VersionController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/getVersion")
	public ModelAndView getVersion(){
		return new ModelAndView("version");
	}
	
	@RequestMapping(value = "/getTestList", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
		List<Kiosko> kioskos = new ArrayList<Kiosko>();
		
		Kiosko k1 = new Kiosko(12,"k1","prueba 1");
		Kiosko k2 = new Kiosko(13,"k2","prueba 2");
		Kiosko k3 = new Kiosko(14,"k3","prueba 3");
		Kiosko k4 = new Kiosko(15,"k4","prueba 4");
		Kiosko k5 = new Kiosko(16,"k5","prueba 5");
		Kiosko k6 = new Kiosko(17,"k6","prueba 6");
		
		kioskos.add(k1);
		kioskos.add(k2);
		kioskos.add(k3);
		kioskos.add(k4);
		kioskos.add(k5);
		kioskos.add(k6);
		
		model.addObject("lista", kioskos);
		model.setViewName("testView");

		return model;

	}
	
	@RequestMapping(value="/pruebaJson", method = RequestMethod.GET, headers="Accept=*/*",  produces="application/json")
	//@Produces(MediaType.TEXT_HTML)  
	public @ResponseBody Kiosko getShopInJSON(HttpServletRequest request) {

		Kiosko k1 = new Kiosko(12,"k1","prueba 1");
		
		return k1;

	}

	@RequestMapping(value = "/jojo", method = RequestMethod.GET)
	public @ResponseBody
	Kiosko getShopInJSON() {

		Kiosko shop = new Kiosko();
		shop.setCode(123);
		shop.setNombre("123");
		shop.setDescription("asdas");

		return shop;

	}
	
}
