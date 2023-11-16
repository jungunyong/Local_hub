package com.javateam.memberProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.javateam.memberProject.service.SpecialsService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SpecialsController {
	
	@Autowired
	SpecialsService specialsService;
	
	@GetMapping("/specials")
	public String specialss(Model model) {
		
		log.info("specials");
		
		model.addAttribute("specials", specialsService.getRandomSpecialss(3));
		return "specials";
	} //

	
	@GetMapping("/special")
	public String specials(@RequestParam(value="id",defaultValue = "1") int id, Model model) {
		
		log.info("special");
		
		model.addAttribute("special", specialsService.getSpecials(id));
		
		return "special";
	}
	
//	@GetMapping("/specials")
//	public String specials(@RequestParam(value="id",defaultValue = "1") int id, Model model) {
//		
//		log.info("specials");
//		
//		model.addAttribute("specials", specialsService.getSpecials(id));
//		return "specials";
//	}

//	
//	  @GetMapping("/specials_Type_STD"); public String specials_Type_STD() {
//	  
//	  log.info("specials_Type_STD");
//	  
//	  return "specials_Type_STD";
//	  
//	  }
//	 
}
