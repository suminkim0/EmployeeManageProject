package com.thym.mapper;

import java.util.Map;

import com.thym.dto.EmployeeDTO;

public interface EmployeeMapper {

	EmployeeDTO login(Map<String, Object> map);

}
