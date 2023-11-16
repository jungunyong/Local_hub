package com.javateam.memberProject.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javateam.memberProject.domain.SpecialsVO;

public interface SpecialsDAO extends PagingAndSortingRepository<SpecialsVO, Integer>{

	List<SpecialsVO> findAll();
}
