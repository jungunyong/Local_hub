package com.javateam.memberProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.memberProject.service.RoomAndDiningService;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class DiningController {

	@Autowired
	RoomAndDiningService roomAndDiningService;
	
		@GetMapping("/dinings")
		public String dinings(Model model) {
			
			log.info("dinings");
			
			return "dinings"; 

		} //
		
		@GetMapping("/dining")
		public String dining(@RequestParam(value="id",defaultValue = "1") int id, Model model) {
			
			log.info("dining");
			model.addAttribute("dining", roomAndDiningService.getDining(id));
			/* model.addAttribute("dinings", roomAndDiningService.getRandomDinings(3)); */
			return "dining";
		} //
		
		
	
}
