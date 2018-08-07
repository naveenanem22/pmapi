package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String query = "INSERT INTO EDUCATION "
				+ "(edu_id, edu_empid, edu_qualname, edu_startdate, edu_enddate, edu_score, edu_scoreType, edu_institution, edu_specialization) "
				+ "VALUES (:eduid,:empid,:qualName,:startdate,:enddate,:score,:scoreType,:institution,:specialization)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("eduid", empEducation.getId());
		namedParameters.put("empid", empEducation.getEmpId());
		namedParameters.put("qualName", empEducation.getQualName());
		namedParameters.put("startdate", empEducation.getQualStartDate());
		namedParameters.put("enddate", empEducation.getQualEndDate());
		namedParameters.put("score", empEducation.getScore());
		namedParameters.put("scoreType", empEducation.getScoreType());
		namedParameters.put("institution", empEducation.getInstitution());
		namedParameters.put("specialization", empEducation.getSpecialization());
		namedParameterJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public void updateEmpEducationsByEmployeeId(List<EmpEducation> empEducations, String empId) {
		empEducations.forEach(empEducation -> {
			String sqlUpdateQuery = "UPDATE education "
					+ "SET edu_qualname=:edu_qualname, edu_startdate=:edu_startdate,"
					+ "edu_enddate=:edu_enddate, edu_score=:edu_score, edu_scoreType=:edu_scoreType,"
					+ "edu_institution=:edu_institution, edu_specialization=:edu_specialization "
					+ "WHERE edu_id =:edu_id && edu_empid=:edu_empid";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("edu_id", empEducation.getId());
			paramMap.put("edu_empid", empId);
			paramMap.put("edu_qualname", empEducation.getQualName());
			paramMap.put("edu_startdate", empEducation.getQualStartDate());
			paramMap.put("edu_enddate", empEducation.getQualEndDate());
			paramMap.put("edu_score", empEducation.getScore());
			paramMap.put("edu_scoreType", empEducation.getScoreType());
			paramMap.put("edu_institution", empEducation.getInstitution());
			paramMap.put("edu_specialization", empEducation.getSpecialization());
			namedParameterJdbcTemplate.update(sqlUpdateQuery, paramMap);
		});

	}

	@Override
	public List<EmpEducation> listEmpEducationsByEmployeeId(String employeeId) {
		String sqlSelectQuery = "SELECT * FROM education WHERE edu_empid=:edu_empid";

		return namedParameterJdbcTemplate.query(sqlSelectQuery, new MapSqlParameterSource("edu_empid", employeeId),
				new EmpEducationMapper());

	}

	@Override
	public EmpEducation getEmpEducationById(String id) {
		return null;
	}

	@Override
	public void removeEmpEducation(String id) {
	}

	private static final class EmpEducationMapper implements RowMapper<EmpEducation> {
		public EmpEducation mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpEducation empEducation = new EmpEducation();
			empEducation.setEmpId(rs.getString("edu_empid"));
			empEducation.setId(rs.getString("edu_id"));
			empEducation.setInstitution(rs.getString("edu_institution"));
			empEducation.setQualStartDate(rs.getDate("edu_startdate"));
			empEducation.setQualEndDate(rs.getDate("edu_enddate"));
			empEducation.setSpecialization(rs.getString("edu_specialization"));
			empEducation.setScore(rs.getFloat("edu_score"));
			empEducation.setScoreType(rs.getString("edu_scoreType"));
			empEducation.setQualName(rs.getString("edu_qualname"));

			return empEducation;
		}
	}

}
