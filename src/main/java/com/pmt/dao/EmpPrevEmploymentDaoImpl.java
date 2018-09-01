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
	public int addPrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "INSERT INTO prevemployment " + "("
				+ "pe_compname, pe_designation, pe_empid, pe_employeecode, pe_enddate, pe_natureofemployment, pe_reasonforleaving, "
				+ "pe_relevantexperienceinmonths, pe_remuneration, pe_startdate, pe_supervisordesignation, pe_supervisoremailid, "
				+ "pe_supervisorname, pe_totalexperienceinmonths" + ") " + "VALUES" + "("
				+ ":pe_compname, :pe_designation, :pe_empid, :pe_employeecode, :pe_enddate, :pe_natureofemployment, :pe_reasonforleaving, "
				+ ":pe_relevantexperienceinmonths, :pe_remuneration, :pe_startdate, :pe_supervisordesignation, :pe_supervisoremailid, "
				+ ":pe_supervisorname, :pe_totalexperienceinmonths" + ")";

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("pe_compname", empPrevEmployment.getCompanyName());
			namedParameters.put("pe_designation", empPrevEmployment.getDesignation());
			namedParameters.put("pe_empid", employeeId);
			namedParameters.put("pe_employeecode", empPrevEmployment.getEmployeeCode());
			namedParameters.put("pe_enddate", empPrevEmployment.getEndDate());
			namedParameters.put("pe_natureofemployment", empPrevEmployment.getNatureOfEmployment());
			namedParameters.put("pe_reasonforleaving", empPrevEmployment.getReasonForLeaving());
			namedParameters.put("pe_relevantexperienceinmonths", empPrevEmployment.getRelevantExperienceInMonths());
			namedParameters.put("pe_remuneration", empPrevEmployment.getRemuneration());
			namedParameters.put("pe_startdate", empPrevEmployment.getStartDate());
			namedParameters.put("pe_supervisordesignation", empPrevEmployment.getSupervisorDesignation());
			namedParameters.put("pe_supervisoremailid", empPrevEmployment.getSupervisorEmailId());
			namedParameters.put("pe_supervisorname", empPrevEmployment.getSupervisorName());
			namedParameters.put("pe_totalexperienceinmonths", empPrevEmployment.getTotalExperienceInMonths());

			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empPrevEmployments.size();
	}

	@Override
	public int updatePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "UPDATE prevemployment " + "SET "
				+ "pe_designation=:pe_designation, pe_employeecode=:pe_employeecode, "
				+ "pe_enddate=:pe_enddate, pe_natureofemployment=:pe_natureofemployment, pe_reasonforleaving=:pe_reasonforleaving, "
				+ "pe_relevantexperienceinmonths=:pe_relevantexperienceinmonths, pe_remuneration=:pe_remuneration, "
				+ "pe_startdate=:pe_startdate, pe_supervisordesignation=:pe_supervisordesignation, "
				+ "pe_supervisoremailid=:pe_supervisoremailid, pe_supervisorname=:pe_supervisorname, pe_totalexperienceinmonths=:pe_totalexperienceinmonths "
				+ "WHERE pe_compname =:pe_compname && pe_empid=:pe_empid && pe_startdate =:pe_oldStartDate";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("pe_designation", empPrevEmployment.getDesignation());
			namedParameters.put("pe_employeecode", empPrevEmployment.getEmployeeCode());
			namedParameters.put("pe_enddate", empPrevEmployment.getEndDate());
			namedParameters.put("pe_natureofemployment", empPrevEmployment.getNatureOfEmployment());
			namedParameters.put("pe_reasonforleaving", empPrevEmployment.getReasonForLeaving());
			namedParameters.put("pe_relevantexperienceinmonths", empPrevEmployment.getRelevantExperienceInMonths());
			namedParameters.put("pe_remuneration", empPrevEmployment.getRemuneration());
			namedParameters.put("pe_startdate", empPrevEmployment.getStartDate());
			namedParameters.put("pe_supervisordesignation", empPrevEmployment.getSupervisorDesignation());
			namedParameters.put("pe_supervisoremailid", empPrevEmployment.getSupervisorEmailId());
			namedParameters.put("pe_supervisorname", empPrevEmployment.getSupervisorName());
			namedParameters.put("pe_totalexperienceinmonths", empPrevEmployment.getTotalExperienceInMonths());
			namedParameters.put("pe_compname", empPrevEmployment.getCompanyName());
			namedParameters.put("pe_empid", employeeId);
			namedParameters.put("pe_oldStartDate", empPrevEmployment.getOldStartDate());

			namedParameterJdbcTemplate.update(sql, namedParameters);

		});
		return empPrevEmployments.size();
	}

	@Override
	public int removePrevEmployments(String employeeId, Set<EmpPrevEmployment> empPrevEmployments) {
		String sql = "DELETE FROM prevemployment WHERE pe_empid =:pe_empid && pe_compname =:pe_compname && pe_startdate =:pe_startdate";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empPrevEmployments.forEach(empPrevEmployment -> {
			namedParameters.put("pe_empid", employeeId);
			namedParameters.put("pe_compname", empPrevEmployment.getCompanyName());
			namedParameters.put("pe_startdate", empPrevEmployment.getStartDate());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empPrevEmployments.size();
	}

	@Override
	public List<EmpPrevEmployment> listPrevEmploymentsByEmployeeId(String employeeId) {
		String sql = "SELECT * FROM prevemployment WHERE pe_empid =:pe_empid";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("pe_empid", employeeId);

		return namedParameterJdbcTemplate.query(sql, namedParameters, new EmpPrevEmploymentRowMapper());

	}

	private static final class EmpPrevEmploymentRowMapper implements RowMapper<EmpPrevEmployment> {

		@Override
		public EmpPrevEmployment mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpPrevEmployment empPrevEmployment = new EmpPrevEmployment();
			empPrevEmployment.setCompanyName(rs.getString("pe_compname"));
			empPrevEmployment.setDesignation(rs.getString("pe_designation"));
			empPrevEmployment.setEmployeeCode(rs.getString("pe_employeecode"));
			empPrevEmployment.setEndDate(rs.getDate("pe_enddate"));
			empPrevEmployment.setNatureOfEmployment(rs.getString("pe_natureofemployment"));
			empPrevEmployment.setReasonForLeaving(rs.getString("pe_reasonforleaving"));
			empPrevEmployment.setRelevantExperienceInMonths(rs.getInt("pe_relevantexperienceinmonths"));
			empPrevEmployment.setRemuneration(rs.getBigDecimal("pe_remuneration"));
			empPrevEmployment.setStartDate(rs.getDate("pe_startdate"));
			empPrevEmployment.setSupervisorDesignation(rs.getString("pe_supervisordesignation"));
			empPrevEmployment.setSupervisorEmailId(rs.getString("pe_supervisoremailid"));
			empPrevEmployment.setSupervisorName(rs.getString("pe_supervisorname"));
			empPrevEmployment.setTotalExperienceInMonths(rs.getInt("pe_totalexperienceinmonths"));
			return empPrevEmployment;
		}

	}

}
