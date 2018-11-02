package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.EmpEducation;

@Repository(value = "empEducationDaoImpl")
public class EmpEducationDaoImpl implements EmpEducationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void addEmpEducation(EmpEducation empEducation) {
		String query = "INSERT INTO employeeeducation "
				+ "(ee_id, ee_emp_id, ee_qualname, ee_start_date, ee_end_date, ee_score, ee_score_type, ee_institution, ee_specialization) "
				+ "VALUES (:ee_id,:ee_emp_id,:ee_qualname,:ee_start_date,:ee_end_date,:ee_score,:ee_score_type,:ee_institution,:ee_specialization)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("ee_id", empEducation.getId());
		namedParameters.put("ee_emp_id", empEducation.getEmpId());
		namedParameters.put("ee_qualname", empEducation.getQualName());
		namedParameters.put("ee_start_date", empEducation.getQualStartDate());
		namedParameters.put("ee_end_date", empEducation.getQualEndDate());
		namedParameters.put("ee_score", empEducation.getScore());
		namedParameters.put("ee_score_type", empEducation.getScoreType());
		namedParameters.put("ee_institution", empEducation.getInstitution());
		namedParameters.put("ee_specialization", empEducation.getSpecialization());
		namedParameterJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public void updateEmpEducationsByEmployeeId(List<EmpEducation> empEducations, String empId) {
		empEducations.forEach(empEducation -> {
			String sqlUpdateQuery = "UPDATE employeeeducation "
					+ "SET ee_qualname=:ee_qualname, ee_start_date=:ee_start_date,"
					+ "ee_end_date=:ee_end_date, ee_score=:ee_score, ee_score_type=:ee_score_type,"
					+ "ee_institution=:ee_institution, ee_specialization=:ee_specialization "
					+ "WHERE ee_id =:ee_id && ee_emp_id=:ee_emp_id";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("ee_id", empEducation.getId());
			paramMap.put("ee_emp_id", empId);
			paramMap.put("ee_qualname", empEducation.getQualName());
			paramMap.put("ee_start_date", empEducation.getQualStartDate());
			paramMap.put("ee_end_date", empEducation.getQualEndDate());
			paramMap.put("ee_score", empEducation.getScore());
			paramMap.put("ee_score_type", empEducation.getScoreType());
			paramMap.put("ee_institution", empEducation.getInstitution());
			paramMap.put("ee_specialization", empEducation.getSpecialization());
			namedParameterJdbcTemplate.update(sqlUpdateQuery, paramMap);
		});

	}

	@Override
	public List<EmpEducation> listEmpEducationsByEmployeeId(String employeeId) {
		String sqlSelectQuery = "SELECT * FROM employeeeducation WHERE ee_emp_id=:ee_emp_id";

		return namedParameterJdbcTemplate.query(sqlSelectQuery, new MapSqlParameterSource("ee_emp_id", employeeId),
				new EmpEducationMapper());

	}

	@Override
	public EmpEducation getEmpEducationById(String id) {
		return null;
	}

	@Override
	public int removeEmpEducation(String employeeId, String educationId) {
		String sqlDeleteQuery = "DELETE FROM employeeeducation WHERE ee_emp_id=:ee_emp_id && ee_id =:ee_id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ee_id", educationId);
		paramMap.put("ee_emp_id", employeeId);
		return namedParameterJdbcTemplate.update(sqlDeleteQuery, paramMap);
	}

	@Override
	public int removeEmpEducations(String employeeId, Set<String> educationIds) {
		String sqlDeleteQuery = "DELETE FROM employeeeducation WHERE ee_emp_id =:ee_emp_id && ee_id IN (:ee_ids)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ee_ids", educationIds);
		paramMap.put("ee_emp_id", employeeId);
		return namedParameterJdbcTemplate.update(sqlDeleteQuery, paramMap);

	}

	private static final class EmpEducationMapper implements RowMapper<EmpEducation> {
		public EmpEducation mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpEducation empEducation = new EmpEducation();
			empEducation.setEmpId(rs.getString("ee_emp_id"));
			empEducation.setId(rs.getString("ee_id"));
			empEducation.setInstitution(rs.getString("ee_institution"));
			empEducation.setQualStartDate(rs.getDate("ee_start_date"));
			empEducation.setQualEndDate(rs.getDate("ee_end_date"));
			empEducation.setSpecialization(rs.getString("ee_specialization"));
			empEducation.setScore(rs.getFloat("ee_score"));
			empEducation.setScoreType(rs.getString("ee_score_type"));
			empEducation.setQualName(rs.getString("ee_qualname"));

			return empEducation;
		}
	}

}
