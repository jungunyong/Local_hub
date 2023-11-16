package com.javateam.memberProject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.memberProject.dao.DiningDAO;
import com.javateam.memberProject.dao.RoomDAO;
import com.javateam.memberProject.domain.DiningVO;
import com.javateam.memberProject.domain.RoomVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoomAndDiningService {
	
	@Autowired
	RoomDAO roomDAO;

	@Autowired
	DiningDAO diningDAO;
	
	/**
	 * 임의의 방 선정
	 * @param limit 출력되는 방의 수
	 * @return
	 */
	public List<RoomVO> getRandomRooms(int limit) {
		
		ArrayList<RoomVO> rooms = (ArrayList)roomDAO.findAll();
		
		log.info("방 전체 갯수 : " + rooms.size());
		
		Collections.shuffle(rooms);
		
		log.info("확인 :" + rooms.get(0));
		
		return rooms.subList(0, limit);
	}
	
	/**
	 * 임의의 방 선정
	 * @param limit 출력되는 방의 수
	 * @return
	 */
	public List<DiningVO> getRandomDinings(int limit) {
		
		ArrayList<DiningVO> dinings = (ArrayList)diningDAO.findAll();
		
		log.info("방 전체 갯수 : " + dinings.size());
		
		Collections.shuffle(dinings);
		
		log.info("확인 :" + dinings.get(0));
		
		return dinings.subList(0, limit);
	}
	
	@Transactional(readOnly = true)
	public RoomVO getRoom(int id) {
		
		return roomDAO.findById(id).get();
		
	}
	
	@Transactional(readOnly = true)
	public DiningVO getDining(int id) {
		DiningVO diningVO = diningDAO.findById(id).get();
		diningVO.setRoomInformation(this.parseRoomInfo(diningVO.getRoomName(), diningVO.getRoomInformation())); 
		return diningVO;
		
	}
	
	private String parseRoomInfo(String name, String roomInfo) {
			
		// 띄워쓰기 처리 : 4칸 띄워쓰기 => 띄워쓰기 후 CSS indent
		roomInfo = roomInfo.replaceAll("    ", "<br><span style='text-indent:20px'>&nbsp;</span>");
		
		// 제목 뒤에서 줄바꿈 
		int titlePos = roomInfo.lastIndexOf(name) + name.length()+1;
		StringBuilder sb = new StringBuilder(roomInfo);
		sb.insert(titlePos, "<br><br>");
		
	
		// 띄워쓰기 처리 : 2칸 띄워쓰기 => &nbsp;
		roomInfo = roomInfo.replaceAll("  ", "<br>-&nbsp;");
		
//		int dotPos = sb.indexOf("."); 
//		sb.insert(dotPos+1, "<br><br>");
		
		// 문의 및 예약 뒤에 띄어쓰기 처리
		if (sb.lastIndexOf("문의 및 예약")!= -1) {
			int questPos = sb.lastIndexOf("문의 및 예약")+"문의 및 예약".length();
			sb.insert(questPos, "<br>");
		}
		
		// 특정일 안내 뒤에 띄어쓰기 처리
		if (sb.lastIndexOf("특정일 안내")!= -1) {
			sb.insert(sb.lastIndexOf("특정일 안내"), "<br><br>");	
			int specPos = sb.lastIndexOf("특정일 안내")+"특정일 안내".length();
			sb.insert(specPos, "<br>");
		}
//    	-&nbsp;* => &nbsp;*

		// 리턴에 체이닝 (.에 띄어쓰기 두번) (-&nbsp;*을 &nbsp;*로 바꿈)
		return sb.toString().replace(".",".<br><br>").replace("-&nbsp;*", "&nbsp;*");
		
	} //

}
	
	/*
	 * public List<RoomVO> getRooms() {
	 * 
	 * 
	 * }
	 */
	
	
