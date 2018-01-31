package com.smn.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.smn.bo.EmployeeBO;
import com.smn.dao.EmpDAO;
import com.smn.dto.EmployeeDTO;

//@Named("empService")
@Service("empService")
public class EmpServiceImpl implements EmpService {

	//@Resource
	//@Autowired
	@Inject
	private EmpDAO empDao;
	
	@Override
	public int getEmpCount() {
		 
		return empDao.getEmpCount();
	}

	@Override
	public List<EmployeeDTO> getEmployeeDetailsbyDesig(String desgn) {
		List<EmployeeBO> boList = null;
		List<EmployeeDTO> dtoList = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO = null;
		boList =  empDao.getEmployeeDetailsbyDesig(desgn);
		for (EmployeeBO employeeBO : boList) {
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeBO, employeeDTO);
			dtoList.add(employeeDTO);
		} 
		
		return dtoList;
	}

}
