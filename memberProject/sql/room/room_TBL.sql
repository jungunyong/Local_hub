 CREATE TABLE ROOM_TBL 
   ("ID" NUMBER(10) PRIMARY KEY, 
	"ROOM_NAME" NVARCHAR2(30), 
	"ROOM_PIC" VARCHAR2(100 BYTE), 
	"ROOM_INFORMATION" NVARCHAR2(300), 
	"ROOM_DATE" DATE, 
	"ROOM_DATE2" DATE, 
	"ROOM_KIND" VARCHAR2(20 BYTE) NOT NULL);