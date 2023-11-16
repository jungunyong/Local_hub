package com.javateam.memberProject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.memberProject.dao.SpecialsDAO;
import com.javateam.memberProject.domain.SpecialsVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpecialsService {
	
	@Autowired
	SpecialsDAO specialsDAO;
	
	/**
	 * 임의의 방 선정
	 * @param limit 출력되는 방의 수
	 * @return
	 */
	public List<SpecialsVO> getRandomSpecialss(int limit) {
		
		ArrayList<SpecialsVO> specialss = (ArrayList)specialsDAO.findAll();
		
		log.info("방 전체 갯수 : " + specialss.size());
		
		Collections.shuffle(specialss);
		
		log.info("확인 :" + specialss.get(0));
		
		return specialss.subList(0, limit);
	}
	
	@Transactional(readOnly = true)
	public SpecialsVO getSpecials(int id) {
		
		return specialsDAO.findById(id).get();
		
	}

}