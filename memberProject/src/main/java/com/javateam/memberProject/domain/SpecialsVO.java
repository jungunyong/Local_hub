
  package com.javateam.memberProject.domain;
  
  
  import javax.persistence.Column; 
  import javax.persistence.Entity; 
  import javax.persistence.GeneratedValue; 
  import javax.persistence.Id; 
  import javax.persistence.Table;

import lombok.Data;
  
  @Entity
  @Table(name="SPECIALS_TBL")
  @Data
  public class SpecialsVO {
  
  @Id
  @GeneratedValue
  @Column 
  private int Id;
  
  // 객실 명 ex) Standard Twin
  
  @Column(name="SPECIALS_NAME") 
  private String specialsName;
  
  // 그림 파일명 ex)
  
  @Column(name="SPECIALS_PIC") 
  private String specialsPic;
  
 
  // 객실 자세한 정보 ex) 위치 9층~11층 구성 침실1, 욕실1, 화장실1 침대 더블Bed 1개 객실크기 43.4sqm (약
  // 13.1평) 전망 Seaside View
  
  @Column(name="SPECIALS_INFORMATION") 
  private String specialsInformation;
  
  }
  
