package com.pmt.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.model.EmpEducation;
import com.pmt.model.Employee;

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
	public void updateEmpEducation(EmpEducation empEducation) {
	}

	@Override
	public List<EmpEducation> listEmpEducations() {
		return null;
	}

	@Override
	public EmpEducation getEmpEducationById(String id) {
		return null;
	}

	@Override
	public void removeEmpEducation(String id) {
	}

}
