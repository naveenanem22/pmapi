package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.EmpPassport;

@Repository(value = "empPassportDaoImpl")
public class EmpPassportDaoImpl implements EmpPassportDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void addPassport(EmpPassport empPassport, String employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO emppassport (epp_empid, epp_number, epp_dateofissue, epp_dateofexpiry) ");
		sql.append("VALUES(:epp_empid, :epp_number, :epp_dateofissue, :epp_dateofexpiry)");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_empid", employeeId);
		namedParameters.put("epp_number", empPassport.getPassportNumber());
		namedParameters.put("epp_dateofissue", empPassport.getDateOfIssue());
		namedParameters.put("epp_dateofexpiry", empPassport.getDateOfExpiry());

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public EmpPassport getPassport(String employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM emppassport WHERE epp_empid =:epp_empid");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_empid", employeeId);
		return namedParameterJdbcTemplate.query(sql.toString(), namedParameters, new EmpPassportRowMapper()).get(0);

	}

	@Override
	public void updatePassport(EmpPassport empPassport, String employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE emppassport SET epp_number =:epp_number, epp_dateofissue =:epp_dateofissue, ");
		sql.append("epp_dateofexpiry =:epp_dateofexpiry ");
		sql.append("WHERE epp_empid =:epp_empid");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_empid", employeeId);
		namedParameters.put("epp_number", empPassport.getPassportNumber());
		namedParameters.put("epp_dateofissue", empPassport.getDateOfIssue());
		namedParameters.put("epp_dateofexpiry", empPassport.getDateOfExpiry());

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public void removePassport(String employeeId, String passportNumber) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM emppassport WHERE epp_number =:epp_number && epp_empid =:epp_empid");

		Map<String, Object> namedParamerters = new HashMap<String, Object>();
		namedParamerters.put("epp_number", passportNumber);
		namedParamerters.put("epp_empid", employeeId);

		namedParameterJdbcTemplate.update(sql.toString(), namedParamerters);

	}

	private static final class EmpPassportRowMapper implements RowMapper<EmpPassport> {

		@Override
		public EmpPassport mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpPassport empPassport = new EmpPassport();
			empPassport.setPassportNumber(rs.getString("epp_number"));
			empPassport.setDateOfExpiry(rs.getDate("epp_dateofexpiry"));
			empPassport.setDateOfIssue(rs.getDate("epp_dateofissue"));
			return empPassport;
		}

	}

}
