package com.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.ProductDB;
import com.eshop.model.Product;


@Controller
public class CatalogController {
	
	@RequestMapping("/product/*")
	public String showProduct(HttpServletRequest request) {
		
		String productCode = request.getRequestURI();
		System.out.println(productCode);
        if (productCode != null) {
            productCode = productCode.substring(15,19);
            System.out.println(productCode);
            Product product = ProductDB.selectProduct(productCode);
            HttpSession session = request.getSession();
            session.setAttribute("product", product);
        }        
        return productCode + "/productLP";
	}


}
