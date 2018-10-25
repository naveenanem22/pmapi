package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pmt.model.Employee;

@Repository(value = "employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void addEmployee(Employee employee, int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO employee (emp_id, emp_firstname, emp_lastname, emp_gender, emp_dob, emp_maritalstatus, emp_createddate, emp_updateddate)\r\n"
						+ "VALUES (:emp_id,:emp_firstname,:emp_lastname,:emp_gender,:emp_dob,:emp_maritalstatus,:emp_createddate,:emp_updateddate);");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("emp_id", 123456);
		namedParameters.put("emp_firstname", employee.getFirstName());
		namedParameters.put("emp_lastname", employee.getLastName());
		namedParameters.put("emp_gender", employee.getGender());
		namedParameters.put("emp_dob", employee.getDob());
		namedParameters.put("emp_maritalstatus", employee.getMaritalStatus());
		namedParameters.put("emp_createddate", employee.getCreatedDate());
		namedParameters.put("emp_updateddate", employee.getUpdatedDate());

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public void updateEmployee(Employee employee, int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE employee SET ");
		sql.append("emp_firstname =:emp_firstname,");
		sql.append("emp_lastname =:emp_lastname,");
		sql.append("emp_gender =:emp_gender,");
		sql.append("emp_dob =:emp_dob,");
		sql.append("emp_maritalstatus =:emp_maritalstatus,");
		sql.append("emp_updateddate =:emp_updateddate ");
		sql.append("WHERE emp_id =:emp_id");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("emp_firstname", employee.getFirstName());
		namedParameters.put("emp_lastname", employee.getLastName());
		namedParameters.put("emp_gender", employee.getGender());
		namedParameters.put("emp_dob", employee.getDob());
		namedParameters.put("emp_maritalstatus", employee.getMaritalStatus());
		namedParameters.put("emp_updateddate", employee.getUpdatedDate());
		namedParameters.put("emp_id", employeeId);

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public List<Employee> listEmployees() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM employee");
		return namedParameterJdbcTemplate.query(sql.toString(), new EmployeeRowMapper());

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM employee WHERE emp_id =:emp_id");
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("emp_id", employeeId);

		return namedParameterJdbcTemplate.query(sql.toString(), namedParameters, new EmployeeRowMapper()).get(0);
	}

	@Override
	public void removeEmployee(int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM employee WHERE emp_id =:emp_id");
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("emp_id", employeeId);

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	private static final class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setCreatedDate(rs.getTimestamp("emp_createddate").toLocalDateTime());
			employee.setDob(rs.getDate("emp_dob"));
			employee.setFirstName(rs.getString("emp_firstname"));
			employee.setGender(rs.getString("emp_gender"));
			employee.setId(rs.getInt("emp_id"));
			employee.setLastName(rs.getString("emp_lastname"));
			employee.setMaritalStatus(rs.getString("emp_maritalstatus"));
			employee.setUpdatedDate(rs.getTimestamp("emp_updateddate").toLocalDateTime());
			return employee;
		}

	}

}
