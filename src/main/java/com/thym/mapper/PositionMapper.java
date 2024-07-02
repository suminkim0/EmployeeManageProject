package com.thym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thym.dto.PositionDTO;

@Mapper
public interface PositionMapper {

	List<PositionDTO> selectAllPosition();

}
