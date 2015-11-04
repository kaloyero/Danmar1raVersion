package com.facturador.danmar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facturador.danmar.model.Kiosko;

@Controller
@RequestMapping("/kfc/brands")
public class JSONController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	Kiosko getShopInJSON(@PathVariable String name) {

		Kiosko shop = new Kiosko();
		shop.setCode(123);
		shop.setNombre("123");
		shop.setDescription("asdas");

		return shop;

	}

}