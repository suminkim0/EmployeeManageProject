package com.thym.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thym.dto.PositionDTO;
import com.thym.mapper.PositionMapper;

@Service
public class PositionService {
	private PositionMapper mapper;

	public PositionService(PositionMapper mapper) {
		this.mapper = mapper;
	}

	public List<PositionDTO> selectAllPosition() {
		return mapper.selectAllPosition();
	}
	
	
	

}
