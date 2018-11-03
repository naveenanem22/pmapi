package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.EmpPrevEmployment;

@Repository(value = "empPrevEmploymentDaoImpl")
public class EmpPrevEmploymentDaoImpl implements EmpPrevEmploymentDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int addPrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "INSERT INTO employeeprevemployment " + "("
				+ "epe_id, epe_company_name, epe_designation, epe_emp_id, epe_employee_code, "
				+ "epe_end_date, epe_nature_of_employment, epe_reason_for_leaving, "
				+ "epe_relevant_experience_in_months, epe_remuneration, epe_start_date, epe_supervisor_designation, epe_supervisor_emailid, "
				+ "epe_supervisor_name, epe_total_experience_in_months" + ") " + "VALUES" + "("
				+ ":epe_id, :epe_company_name, :epe_designation, :epe_emp_id, :epe_employee_code, :epe_end_date, :epe_nature_of_employment, :epe_reason_for_leaving, "
				+ ":epe_relevant_experience_in_months, :epe_remuneration, :epe_start_date, :epe_supervisor_designation, :epe_supervisor_emailid, "
				+ ":epe_supervisor_name, :epe_total_experience_in_months" + ")";

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("epe_id", empPrevEmployment.getId());
			namedParameters.put("epe_company_name", empPrevEmployment.getCompanyName());
			namedParameters.put("epe_designation", empPrevEmployment.getDesignation());
			namedParameters.put("epe_emp_id", employeeId);
			namedParameters.put("epe_employee_code", empPrevEmployment.getEmployeeCode());
			namedParameters.put("epe_end_date", empPrevEmployment.getEndDate());
			namedParameters.put("epe_nature_of_employment", empPrevEmployment.getNatureOfEmployment());
			namedParameters.put("epe_reason_for_leaving", empPrevEmployment.getReasonForLeaving());
			namedParameters.put("epe_relevant_experience_in_months", empPrevEmployment.getRelevantExperienceInMonths());
			namedParameters.put("epe_remuneration", empPrevEmployment.getRemuneration());
			namedParameters.put("epe_start_date", empPrevEmployment.getStartDate());
			namedParameters.put("epe_supervisor_designation", empPrevEmployment.getSupervisorDesignation());
			namedParameters.put("epe_supervisor_emailid", empPrevEmployment.getSupervisorEmailId());
			namedParameters.put("epe_supervisor_name", empPrevEmployment.getSupervisorName());
			namedParameters.put("epe_total_experience_in_months", empPrevEmployment.getTotalExperienceInMonths());

			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empPrevEmployments.size();
	}

	@Override
	public int updatePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "UPDATE employeeprevemployment " + "SET "
				+ "epe_designation=:epe_designation, epe_employee_code=:epe_employee_code, "
				+ "epe_end_date=:epe_end_date, epe_nature_of_employment=:epe_nature_of_employment, epe_reason_for_leaving=:epe_reason_for_leaving, "
				+ "epe_relevant_experience_in_months=:epe_relevant_experience_in_months, epe_remuneration=:epe_remuneration, "
				+ "epe_start_date=:epe_start_date, epe_supervisor_designation=:epe_supervisor_designation, "
				+ "epe_supervisor_emailid=:epe_supervisor_emailid, epe_supervisor_name=:epe_supervisor_name, epe_total_experience_in_months=:epe_total_experience_in_months "
				+ "WHERE epe_id =:epe_id && epe_emp_id=:epe_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("epe_id", empPrevEmployment.getId());
			namedParameters.put("epe_designation", empPrevEmployment.getDesignation());
			namedParameters.put("epe_employee_code", empPrevEmployment.getEmployeeCode());
			namedParameters.put("epe_end_date", empPrevEmployment.getEndDate());
			namedParameters.put("epe_nature_of_employment", empPrevEmployment.getNatureOfEmployment());
			namedParameters.put("epe_reason_for_leaving", empPrevEmployment.getReasonForLeaving());
			namedParameters.put("epe_relevant_experience_in_months", empPrevEmployment.getRelevantExperienceInMonths());
			namedParameters.put("epe_remuneration", empPrevEmployment.getRemuneration());
			namedParameters.put("epe_start_date", empPrevEmployment.getStartDate());
			namedParameters.put("epe_supervisor_designation", empPrevEmployment.getSupervisorDesignation());
			namedParameters.put("epe_supervisor_emailid", empPrevEmployment.getSupervisorEmailId());
			namedParameters.put("epe_supervisor_name", empPrevEmployment.getSupervisorName());
			namedParameters.put("epe_total_experience_in_months", empPrevEmployment.getTotalExperienceInMonths());
			namedParameters.put("epe_company_name", empPrevEmployment.getCompanyName());
			namedParameters.put("epe_emp_id", employeeId);

			namedParameterJdbcTemplate.update(sql, namedParameters);

		});
		return empPrevEmployments.size();
	}

	@Override
	public int removePrevEmployments(int employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "DELETE FROM employeeprevemployment WHERE epe_id =:epe_id && epe_emp_id =:epe_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("epe_emp_id", employeeId);	
			namedParameters.put("epe_id", empPrevEmployment.getId());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empPrevEmployments.size();
	}

	@Override
	public List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(int employeeId) {
		String sql = "SELECT * FROM employeeprevemployment WHERE epe_emp_id =:epe_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epe_emp_id", employeeId);

		return namedParameterJdbcTemplate.query(sql, namedParameters, new EmpPrevEmploymentRowMapper());

	}

	private static final class EmpPrevEmploymentRowMapper implements RowMapper<EmpPrevEmployment> {

		@Override
		public EmpPrevEmployment mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpPrevEmployment empPrevEmployment = new EmpPrevEmployment();

			empPrevEmployment.setCompanyName(rs.getString("epe_company_name"));
			empPrevEmployment.setDesignation(rs.getString("epe_designation"));
			empPrevEmployment.setEmployeeCode(rs.getString("epe_employee_code"));
			empPrevEmployment.setEndDate(rs.getDate("epe_end_date"));
			empPrevEmployment.setId(rs.getInt("epe_id"));
			empPrevEmployment.setNatureOfEmployment(rs.getString("epe_nature_of_employment"));
			empPrevEmployment.setReasonForLeaving(rs.getString("epe_reason_for_leaving"));
			empPrevEmployment.setRelevantExperienceInMonths(rs.getInt("epe_relevant_experience_in_months"));
			empPrevEmployment.setRemuneration(rs.getBigDecimal("epe_remuneration"));
			empPrevEmployment.setStartDate(rs.getDate("epe_start_date"));
			empPrevEmployment.setSupervisorDesignation(rs.getString("epe_supervisor_designation"));
			empPrevEmployment.setSupervisorEmailId(rs.getString("epe_supervisor_emailid"));
			empPrevEmployment.setSupervisorName(rs.getString("epe_supervisor_name"));
			empPrevEmployment.setTotalExperienceInMonths(rs.getInt("epe_total_experience_in_months"));
			return empPrevEmployment;
		}

	}

}
