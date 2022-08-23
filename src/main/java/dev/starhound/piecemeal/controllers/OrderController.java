package dev.starhound.piecemeal.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	@GetMapping("")
	public String thisOrder(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		return "order/order.jsp";
	}
	
	// submit a new order
	@GetMapping("/new")
	public String newOrder(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		return "order/neworder.jsp";
	}
	
	@PostMapping("/new")
	public String submitNewOrder() {
		return "order/neworder.jsp";
	}
	
	// TODO: edit order
	
	// saving previous orders?
	
}
