package org.samsung.projectspring.emp.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class EmpMapper implements RowMapper<EmpVO> {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setPhoneNumber(rs.getString(5));
			emp.setHireDate(rs.getDate(6));
			emp.setJobId(rs.getString(7));
			emp.setSalary(rs.getDouble(8));
			emp.setCommissionPct(rs.getDouble(9));
			emp.setManagerId(rs.getInt(10));
			emp.setDepartmentId(rs.getInt(11));
			return emp;
		}
	}
	
	RowMapper<EmpVO> empMapper = new RowMapper<EmpVO>() {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setPhoneNumber(rs.getString(5));
			emp.setHireDate(rs.getDate(6));
			emp.setJobId(rs.getString(7));
			emp.setSalary(rs.getDouble(8));
			emp.setCommissionPct(rs.getDouble(9));
			emp.setManagerId(rs.getInt(10));
			emp.setDepartmentId(rs.getInt(11));
			return emp;
		}
		
	};
	
	@Override
	public int getEmpCount() {
		String sql = "SELECT count(*) FROM employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptId) {
		String sql = "SELECT count(*) FROM employees WHERE department_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {
		String sql = "SELECT * FROM employees";
		return jdbcTemplate.query(sql, empMapper);
	}

	@Override
	public EmpVO getEmpInfo(int empId) {
		String sql = "SELECT * FROM employees WHERE employee_id=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empId);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		String sql = "UPDATE employees set first_name=?, last_name=?,"
		+ "email=?, phone_number=?, hire_date=?, job_id?,"
		+ " salary=?, commission_pct=?, manager_id=?,"
		+ " department_id=? WHERE employee_id=?";
		jdbcTemplate.update(sql,emp.getFirstName(),
				emp.getLastName(), emp.getEmail(), emp.getPhoneNumber(),
				emp.getHireDate(), emp.getJobId(), emp.getSalary(),
				emp.getCommissionPct(), emp.getManagerId(), emp.getDepartmentId(),
				emp.getEmployeeId());
	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "INSERT INTO employees "
		+ "VALUES(?,?,?,?,?,sysdate,?,?,?,?,?)";
		jdbcTemplate.update(sql,emp.getEmployeeId(),
				emp.getFirstName(),
				emp.getLastName(), emp.getEmail(), 
				emp.getPhoneNumber(), emp.getJobId(), emp.getSalary(),
				emp.getCommissionPct(), emp.getManagerId(), emp.getDepartmentId()
				);
	}

	@Override
	public void deleteEmp(int empId) {
		String sql = "DELETE FROM employees WHERE employee_id=?";
		jdbcTemplate.update(sql, empId);
	}

	@Override
	public void deleteJobHistory(int empId) {
		String sql = "DELETE FROM job_history WHERE employee_id=?";
		jdbcTemplate.update(sql, empId);	
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "select department_id as departmentId,"
		+ "department_name as departmentName from departments";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "select job_id as jobId, job_title as jobTitle "
		+ "from jobs";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "select employee_id as managerId, "
		+ "first_name||' '||last_name as managerName "
		+ "from employees "
		+ "where employee_id in "
		+ "(select distinct manager_id from employees)";
		return jdbcTemplate.queryForList(sql);
	}
}
