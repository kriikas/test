package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TabsController {

	@RequestMapping("/tabsMain")
	public ModelAndView tabsMain(ModelAndView mav) {
		mav.setViewName("tabsMain");
		return mav;
	}
	
	@RequestMapping("/tab/{tab}")
	public ModelAndView tab(ModelAndView mav, @PathVariable("tab") String tab) {
		mav.addObject("tabNum", tab);
		mav.setViewName("tab");
		return mav;
	}
	
}
