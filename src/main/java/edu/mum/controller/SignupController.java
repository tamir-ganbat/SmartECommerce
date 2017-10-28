
package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCredentialsService userCredentialsService;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String display(@ModelAttribute("signup") User user, Model model) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("signup") User user, BindingResult bindingResult,
			RedirectAttributes redirectAttribute, Model model) {
		// System.out.println("------------------------");
		if (bindingResult.hasErrors())
			return "signup";

		if (userCredentialsService.findByUsername(user.getUserCredentials().getUsername()) == null) {
			userService.save(user);
		} else {
			model.addAttribute("error", "Username already exists, please write a different username");
			return "signup";
		}

		redirectAttribute.addFlashAttribute(user);

		return "redirect:/login";
	}

}