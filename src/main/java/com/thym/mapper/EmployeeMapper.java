package com.thym.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.thym.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO login(Map<String, Object> map);
	List<EmployeeDTO> selectAllEmployee();

}
