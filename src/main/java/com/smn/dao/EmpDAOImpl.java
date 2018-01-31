package com.smn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.smn.bo.EmployeeBO;

//@Named("empDAO")
@Repository("empDAO")
public class EmpDAOImpl implements EmpDAO {

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public int getEmpCount() {
		final String SQL = "SELECT COUNT(*) FROM EMP"; 
		return jdbcTemplate.queryForObject(SQL, Integer.class);
	}

	@Override
	public List<EmployeeBO> getEmployeeDetailsbyDesig(String desgn) {
		final String SQL = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB = ?";
		 List<EmployeeBO> empBOList = new ArrayList<EmployeeBO>();
		 jdbcTemplate.query(SQL, new EmpRowCallBackHandler(empBOList),desgn);
		 
		return empBOList;
	}
	
	private static class EmpRowCallBackHandler implements RowCallbackHandler{

		private List<EmployeeBO> empBoList = null;
		
		public EmpRowCallBackHandler(List<EmployeeBO> list){
			empBoList = list;
		}
		
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			 
			System.out.println("Process Row...!!!!");
			EmployeeBO empBo = new EmployeeBO();
			empBo.setEmpno(rs.getInt(1));
			empBo.setEname(rs.getString(2));
			empBo.setJob(rs.getString(3));
			empBo.setSalary(rs.getInt(4));
			empBoList.add(empBo);
		}
	}
}
