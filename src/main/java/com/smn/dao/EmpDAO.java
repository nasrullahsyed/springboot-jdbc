package com.smn.dao;

import java.util.List;

import com.smn.bo.EmployeeBO;

public interface EmpDAO {

	public int getEmpCount();
	public List<EmployeeBO> getEmployeeDetailsbyDesig(String desgn);
}
