package com.smn.service;

import java.util.List;

import com.smn.dto.EmployeeDTO;

public interface EmpService {
	
	public int getEmpCount();
	public List<EmployeeDTO> getEmployeeDetailsbyDesig(String desgn);

}