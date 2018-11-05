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
import com.pmt.model.EmpVisa;

@Repository(value = "visaDaoImpl")
public class EmpVisaDaoImpl implements EmpVisaDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void addVisa(EmpVisa visa, int employeeId) {
		String query = "INSERT INTO employeevisa"
				+ "(empvsa_id, empvsa_emp_id, empvsa_country, empvsa_type, empvsa_valid_till, empvsa_valid_from) "
				+ "VALUES (:empvsa_id,:empvsa_emp_id,:empvsa_country,:empvsa_type,:empvsa_valid_till,:empvsa_valid_from)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("empvsa_id", visa.getId());
		namedParameters.put("empvsa_emp_id", employeeId);
		namedParameters.put("empvsa_country", visa.getCountry());
		namedParameters.put("empvsa_type", visa.getVisaType());
		namedParameters.put("empvsa_valid_till", visa.getValidTill());
		namedParameters.put("empvsa_valid_from", visa.getValidFrom());
		namedParameterJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public void updateVisasByEmployeeId(List<EmpVisa> visas, int employeeId) {
		String query = "UPDATE employeevisa " + "SET empvsa_country=:empvsa_country, empvsa_type=:empvsa_type,"
				+ "empvsa_valid_till=:empvsa_valid_till, empvsa_valid_from=:empvsa_valid_from "
				+ "WHERE empvsa_id =:empvsa_id && empvsa_emp_id=:empvsa_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		visas.forEach(visa -> {
			namedParameters.put("empvsa_country", visa.getCountry());
			namedParameters.put("empvsa_type", visa.getVisaType());
			namedParameters.put("empvsa_valid_till", visa.getValidTill());
			namedParameters.put("empvsa_valid_from", visa.getValidFrom());
			namedParameters.put("empvsa_emp_id", employeeId);
			namedParameters.put("empvsa_id", visa.getId());
			namedParameterJdbcTemplate.update(query, namedParameters);
		});

	}

	@Override
	public List<EmpVisa> listVisasByEmployeeId(int employeeId) {
		String query = "SELECT * FROM employeevisa WHERE empvsa_emp_id =:empvsa_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("empvsa_emp_id", employeeId);
		return namedParameterJdbcTemplate.query(query, namedParameters, new VisaMapper());
	}

	@Override
	public EmpVisa getVisaById(int visaId) {

		return null;
	}

	@Override
	public int removeVisa(int employeeId, int visaId) {
		String query = "DELETE FROM employeevisa WHERE empvsa_emp_id =:empvsa_emp_id && empvsa_id =:empvsa_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("empvsa_emp_id", employeeId);
		namedParameters.put("empvsa_id", visaId);
		return namedParameterJdbcTemplate.update(query, namedParameters);

	}

	@Override
	public int removeVisas(int employeeId, Set<Integer> visas) {
		String query = "DELETE FROM employeevisa WHERE empvsa_emp_id =:empvsa_emp_id && empvsa_id IN (:empvsa_ids)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("empvsa_emp_id", employeeId);
		namedParameters.put("empvsa_ids", visas);
		return namedParameterJdbcTemplate.update(query, namedParameters);
	}

	private static final class VisaMapper implements RowMapper<EmpVisa> {
		public EmpVisa mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVisa visa = new EmpVisa();
			visa.setId(rs.getInt("empvsa_id"));
			visa.setCountry(rs.getString("empvsa_country"));
			visa.setValidFrom(rs.getDate("empvsa_valid_from"));
			visa.setValidTill(rs.getDate("empvsa_valid_till"));
			visa.setVisaType(rs.getString("empvsa_type"));

			return visa;
		}
	}

}
