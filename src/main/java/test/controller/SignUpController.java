package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

	@RequestMapping(value="/signup")
	public ModelAndView signUp(ModelAndView mav) {
		mav.setViewName("signup");
		return mav;
	}
	
}
