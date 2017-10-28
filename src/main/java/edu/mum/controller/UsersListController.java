package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.User;
import edu.mum.service.UserService;

@Controller
public class UsersListController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/usersList", method=RequestMethod.GET)
	public String getOrderDetail(Model model) {
		List<User> users = userService.findAll();
		if(users == null || users.isEmpty())
			return "redirect: products";
		model.addAttribute("users",userService.findAll());
		return "usersList";
	}
}
