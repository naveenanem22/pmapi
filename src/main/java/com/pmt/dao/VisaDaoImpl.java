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
import com.pmt.model.Visa;

@Repository(value = "visaDaoImpl")
public class VisaDaoImpl implements VisaDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void addVisa(Visa visa, String employeeId) {
		String query = "INSERT INTO visa " + "(vsa_id, vsa_empid, vsa_country, vsa_type, vsa_validtill, vsa_validfrom) "
				+ "VALUES (:vsa_id,:vsa_empid,:vsa_country,:vsa_type,:vsa_validtill,:vsa_validfrom)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("vsa_id", visa.getId());
		namedParameters.put("vsa_empid", employeeId);
		namedParameters.put("vsa_country", visa.getCountry());
		namedParameters.put("vsa_type", visa.getVisaType());
		namedParameters.put("vsa_validtill", visa.getValidTill());
		namedParameters.put("vsa_validfrom", visa.getValidFrom());
		namedParameterJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public void updateVisasByEmployeeId(List<Visa> visas, String employeeId) {
		String query = "UPDATE visa "
				+ "SET vsa_country=:vsa_country, vsa_type=:vsa_type,"
				+ "vsa_validtill=:vsa_validtill, vsa_validfrom=:vsa_validfrom "
				+ "WHERE vsa_id =:vsa_id && vsa_empid=:vsa_empid";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		visas.forEach(visa -> {
			namedParameters.put("vsa_country", visa.getCountry());
			namedParameters.put("vsa_type", visa.getVisaType());
			namedParameters.put("vsa_validtill", visa.getValidTill());
			namedParameters.put("vsa_validfrom", visa.getValidFrom());
			namedParameters.put("vsa_empid", employeeId);
			namedParameters.put("vsa_id", visa.getId());
			namedParameterJdbcTemplate.update(query, namedParameters);
		});
		

	}

	@Override
	public List<Visa> listVisasByEmployeeId(String employeeId) {
		String query = "SELECT * FROM visa WHERE vsa_empid =:vsa_empid";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("vsa_empid", employeeId);
		return namedParameterJdbcTemplate.query(query, namedParameters, new VisaMapper());
	}

	@Override
	public Visa getVisaById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeVisa(String employeeId, String visaId) {
		String query = "DELETE FROM visa WHERE vsa_empid =:vsa_empid && vsa_id =:vsa_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("vsa_empid", employeeId);
		namedParameters.put("vsa_id", visaId);
		return namedParameterJdbcTemplate.update(query, namedParameters);
		
	}

	@Override
	public int removeVisas(String employeeId, Set<String> visas) {
		String query =  "DELETE FROM visa WHERE vsa_empid =:vsa_empid && vsa_id IN (:vsa_ids)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("vsa_empid", employeeId);
		namedParameters.put("vsa_ids", visas);
		return namedParameterJdbcTemplate.update(query, namedParameters);
	}

	private static final class VisaMapper implements RowMapper<Visa> {
		public Visa mapRow(ResultSet rs, int rowNum) throws SQLException {
			Visa visa = new Visa();
			visa.setId(rs.getString("vsa_id"));
			visa.setCountry(rs.getString("vsa_country"));
			visa.setValidFrom(rs.getDate("vsa_validfrom"));
			visa.setValidTill(rs.getDate("vsa_validtill"));
			visa.setVisaType(rs.getString("vsa_type"));

			return visa;
		}
	}

}
