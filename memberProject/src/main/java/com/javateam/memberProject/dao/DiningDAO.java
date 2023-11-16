package com.javateam.memberProject.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javateam.memberProject.domain.DiningVO;

public interface DiningDAO extends PagingAndSortingRepository<DiningVO, Integer>{

	List<DiningVO> findAll();
}
