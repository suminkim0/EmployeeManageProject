package com.thym.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thym.dto.EmployeeDTO;
import com.thym.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(String eno, String name, HttpSession session) {
		EmployeeDTO dto = service.login(eno, name);
		session.setAttribute("user", dto);
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public ModelAndView main(ModelAndView view) {
		List<EmployeeDTO> list = service.selectAllEmployee();
		view.addObject("list",list);
		view.setViewName("main");
		return view;
	}
	
	@GetMapping("/employee/register/view")
	public String registerView() {
		return "employee_register";
	}
	
	@PostMapping("/employee/insert")
	public String registerMember(EmployeeDTO dto, HttpSession session,
			HttpServletResponse response) throws IOException {
		System.out.println(dto);
		//모든 데이터가 정상인지 체크
		response.setContentType("text/html;charset=utf-8");
		if(dto.getEno().isEmpty() || dto.getName().isEmpty() || dto.getDepartment().isEmpty()) {
			response.getWriter().println("<script>"
					+ "alert('잘못된 데이터가 있습니다');"
					+ "history.back();"
					+ "</script>");
		}else{
			//DB에 등록 작업 시작
			try {
				service.insertEmployee(dto);
				response.getWriter().println("<script>"
						+ "alert('직원등록 성공, 메인페이지로 이동합니다.');"
						+ "location.href='/main';"
						+ "</script>");
			}catch (Exception e) {
				System.out.println(e);
				response.getWriter().println("<script>"
						+ "alert('직원 등록에 실패하였습니다.\\n데이터를 확인하세요.');"
						+ "history.back();"
						+ "</script>");
			}
		}
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@DeleteMapping("/employee/delete/{eno}")
	public ResponseEntity<String> deleteGrade(@PathVariable String eno){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(eno);
		int result = service.deleteEmployee(eno);
		map.put("resultCode", result);
		if(result == 1)
			map.put("msg", "해당 등급 삭제 완료");
		else
			map.put("msg", "해당 등급 삭제 실패");
		
		return new ResponseEntity(map, HttpStatus.OK);
	}
	
	
}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
