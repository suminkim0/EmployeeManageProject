package com.thym.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.thym.dto.EmployeeDTO;
import com.thym.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	private EmployeeMapper mapper;

	public EmployeeService(EmployeeMapper mapper) {
		this.mapper = mapper;
	}
	
	public EmployeeDTO login(String eno, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eno", eno);
		map.put("name", name);
		
		return mapper.login(map);
	}

	public List<EmployeeDTO> selectAllEmployee() {
		return mapper.selectAllEmployee();
	}

	public int insertEmployee(EmployeeDTO dto) throws SQLException{
		return mapper.insertEmployee(dto);
	}

	public int deleteEmployee(String eno) {
		return mapper.deleteEmployee(eno);
	}
	
	
	
	
}
