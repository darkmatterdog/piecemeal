package dev.starhound.piecemeal.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.starhound.piecemeal.models.Group;
import dev.starhound.piecemeal.models.GroupOrder;
import dev.starhound.piecemeal.models.LoginUser;
import dev.starhound.piecemeal.models.User;
import dev.starhound.piecemeal.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// landing page (dashboard+info if logged in)
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "misc/landing.jsp";
		}
		
		// adds group and order info to dash
		if(((User) session.getAttribute("user")).getGroup() == null) {
			model.addAttribute("group", null);
			model.addAttribute("order", null);
		}
		else {
			Group userGroup = ((User) session.getAttribute("user")).getGroup();
			model.addAttribute("group", userGroup);
			
			GroupOrder groupOrder = userGroup.getCurrentOrder();
			model.addAttribute("order", groupOrder);
		}		
		return "misc/dashboard.jsp";
	}
	
	
	// login
	@GetMapping("/login")
	public String loginPage(Model model, @ModelAttribute("loginUser") LoginUser loginUser, HttpSession session) {
		return "user/login.jsp";
	}
	
	@PostMapping("/login")
	public String submitLogin(Model model, @Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session) {
		User user = userService.login(loginUser, result);
		if(result.hasErrors() || user == null) {
			return "user/login.jsp";
		}
		session.setAttribute("user", user);
		return "redirect:/";
	}
	
	
	
	
	// register
	@GetMapping("/register")
	public String registerPage(Model model, @ModelAttribute("newUser") User newUser) {
		return "user/register.jsp";
	}
	
	@PostMapping("/register")
	public String submitRegistration(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session) {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			return "user/register.jsp";
		}
		session.setAttribute("user", user);
		return "redirect:/login";
	}
	
	// account details
	@GetMapping("/account")
	public String myAccount(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		return "user/account.jsp";
	}
	
	
	
	// logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}
	
	
	
	
	
	// about piecemeal
	@GetMapping("/about")
	public String aboutPiecemeal() {
		return "misc/about.jsp";
	}
	
}
