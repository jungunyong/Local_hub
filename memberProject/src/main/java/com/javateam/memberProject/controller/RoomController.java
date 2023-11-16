package com.javateam.memberProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.memberProject.service.RoomAndDiningService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RoomController {
	
	@Autowired
	RoomAndDiningService roomAndDiningService;
	
	@GetMapping("/rooms")
	public String rooms(Model model) {
		
		log.info("rooms");
		
		model.addAttribute("rooms", roomAndDiningService.getRandomRooms(3));
		return "rooms";
	} //

	
	@GetMapping("/room")
	public String room(@RequestParam(value="id",defaultValue = "1") int id, Model model) {
		
		log.info("room");
		
		model.addAttribute("room", roomAndDiningService.getRoom(id));
		model.addAttribute("dinings", roomAndDiningService.getRandomDinings(3));
		
		return "room";
	}
	
	   @PostMapping("/reserve")
	   public String reserve(@RequestParam Map<String, Object> map) {
	      log.info("reserve1111");
	      map.forEach((k, v) -> {log.info(k+" = " + v);});
	      
	      return "reserve";
	}
	
}
