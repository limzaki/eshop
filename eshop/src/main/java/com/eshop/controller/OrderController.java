package com.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.ProductDB;
import com.eshop.dao.UserDB;
import com.eshop.model.Cart;
import com.eshop.model.Invoice;
import com.eshop.model.LineItem;
import com.eshop.model.Product;
import com.eshop.model.User;


@Controller
public class OrderController {

	@RequestMapping("/order/*")
	public String createOrder(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		if (requestURI.endsWith("/addItem")) {
			addItem(request);
		} else if (requestURI.endsWith("/updateItem")) {
			updateItem(request);
		} else if (requestURI.endsWith("/removeItem")) {
			removeItem(request);
		} else if (requestURI.endsWith("/processUser")) {
			processUser(request);
			displayInvoice(request);
			return "invoice";
		} else if (requestURI.endsWith("/checkUser")) {
			return "user";
		}
		return "cart";
	}
	private void displayInvoice(HttpServletRequest request) {

        HttpSession session = request.getSession();        
        User user = (User) session.getAttribute("user");       
        Cart cart = (Cart) session.getAttribute("cart");

        java.util.Date today = new java.util.Date();

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setInvoiceDate(today);
        invoice.setLineItems(cart.getItems());
        
        session.setAttribute("invoice", invoice);
     
    }
	 private String processUser(HttpServletRequest request) {
	        
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String phoneNumber = request.getParameter("phone");
	        String address = request.getParameter("address");
	        
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");
	        if (user == null) {
	            user = new User();
	        }
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            UserDB.insert(user);
	        session.setAttribute("user", user);

	        return "invoice";
	    }
	private void addItem(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		String productCode = request.getParameter("productCode");
		Product product = ProductDB.selectProduct(productCode);
		if (product != null) {
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			cart.addItem(lineItem);
		}
		session.setAttribute("cart", cart);

	}

	private void updateItem(HttpServletRequest request) {
		String quantityString = request.getParameter("quantity");
		String productCode = request.getParameter("productCode");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int quantity;
		try {
			quantity = Integer.parseInt(quantityString);
			if (quantity < 0)
				quantity = 1;
		} catch (NumberFormatException ex) {
			quantity = 1;
		}
		Product product = ProductDB.selectProduct(productCode);
		if (product != null && cart != null) {
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			lineItem.setQuantity(quantity);
			if (quantity > 0)
				cart.addItem(lineItem);
			else
				cart.removeItem(lineItem);
		}

	}

	private void removeItem(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String productCode = request.getParameter("productCode");
		Product product = ProductDB.selectProduct(productCode);
		if (product != null && cart != null) {
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			cart.removeItem(lineItem);
		}

	}
}
