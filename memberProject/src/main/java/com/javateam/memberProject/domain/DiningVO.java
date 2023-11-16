package com.javateam.memberProject.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="DINING_TBL")
@Data
public class DiningVO {

	@Id
	@GeneratedValue
	@Column
	private int Id;

	// 객실 명 ex) Standard Twin
	@Column(name="ROOM_NAME")
	private String roomName;
	
	// 그림 파일명 ex) 
	@Column(name="ROOM_PIC")
	private String roomPic;
	
	
	// 객실 자세한 정보 ex) 위치 9층~11층 구성 침실1, 욕실1, 화장실1 침대 더블Bed 1개 객실크기 43.4sqm (약 13.1평) 전망 Seaside View
	@Column(name="ROOM_INFORMATION")
	private String roomInformation;
	
	// 달력 예약일 입실,퇴실
	@JsonFormat(pattern="yyyy-MM-dd")
	@CreationTimestamp
	@Column(name="ROOM_DATE")
	private Date roomDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@CreationTimestamp
	@Column(name="ROOM_DATE2")
	private Date roomDate2;
	
	// 방의 종류 ex) room / dining
	@Column(name="ROOM_KIND")
	private String roomKind;
	
	// 
	
	
	
}
