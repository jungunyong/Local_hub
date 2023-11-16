package com.javateam.memberProject.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javateam.memberProject.domain.RoomVO;

public interface RoomDAO extends PagingAndSortingRepository<RoomVO, Integer>{

	List<RoomVO> findAll();
}
