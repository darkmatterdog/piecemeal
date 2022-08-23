package dev.starhound.piecemeal.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.starhound.piecemeal.models.Group;
import dev.starhound.piecemeal.models.User;

@Controller
@RequestMapping("/group")
public class GroupController {

	@GetMapping("")
	public String myGroup(Model model, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		else if(((User) session.getAttribute("user")).getGroup() == null) {
			model.addAttribute("group", null);
			return "group/group.jsp";
		}
		else {
			Group userGroup = ((User) session.getAttribute("user")).getGroup();
			model.addAttribute("group", userGroup);
			return "group/group.jsp";
		}
	}
	
	@GetMapping("/settings")
	public String groupSettings() {
		return "group/groupsettings.jsp";
	}
	
	@PostMapping("/adduser")
	public String addToGroup() {
		// TODO: confirm if leaving existing group; assign new admin if owner
		
		return "group/";
	}
	
}
