package edu.mum.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;
//import edu.mum.service.UserService;

@Controller
@SessionAttributes("first")
public class LoginController {

//	@Autowired
//	private UserService userService;

	@Autowired
	private UserCredentialsService usercredentialsservice;

	@RequestMapping(value = { "", "/login", "/logout" }, method = RequestMethod.GET)
	public String first(Principal principal) {
		if (principal != null) {
			return "redirect: products";
		}
		return "login";
	}

	// @RequestMapping(value={"","/login"}, method = RequestMethod.GET)
	// public String first() {
	// return "login";
	// }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") User user, Model model) {
		// loginService.save(login);
		model.addAttribute("user", user);
		// System.out.println("------------------");
		return "welcome";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model, Principal principal, HttpSession session) {

		if (principal == null) {
			return "redirect: login";
		}

		UserCredentials credentials = usercredentialsservice.findByUsername(principal.getName());

		if (principal.getName().equals(credentials.getUsername())) {
			// System.out.println("------------------------------------------");
			// System.out.println( principal.getName());
			// System.out.println( "true");
			//
			// System.out.println( credentials.getUser().getId());
			if (credentials.getUser() != null)
				session.setAttribute("userId", credentials.getUser().getId());
			else
				session.setAttribute("userId", 0);

			session.setAttribute("userRole", credentials.getAuthority().get(0).getAuthority());
		}

		// model.addAttribute("users" , credentials.getUser().getId());
		model.addAttribute("first", principal.getName());
		return "redirect:/products";
	}
}
