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
	public void addPassport(EmpPassport empPassport, int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO employeepassport (epp_id, epp_emp_id, epp_number, epp_date_of_issue, epp_date_of_expiry) ");
		sql.append("VALUES(:epp_id, :epp_emp_id, :epp_number, :epp_date_of_issue, :epp_date_of_expiry)");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_id", empPassport.getId());
		namedParameters.put("epp_emp_id", employeeId);
		namedParameters.put("epp_number", empPassport.getPassportNumber());
		namedParameters.put("epp_date_of_issue", empPassport.getDateOfIssue());
		namedParameters.put("epp_date_of_expiry", empPassport.getDateOfExpiry());

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public EmpPassport getPassport(int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM employeepassport WHERE epp_emp_id =:epp_emp_id");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_emp_id", employeeId);
		return namedParameterJdbcTemplate.query(sql.toString(), namedParameters, new EmpPassportRowMapper()).get(0);

	}

	@Override
	public void updatePassport(EmpPassport empPassport, int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE employeepassport SET epp_number =:epp_number, epp_date_of_issue =:epp_date_of_issue, ");
		sql.append("epp_date_of_expiry =:epp_date_of_expiry ");
		sql.append("WHERE epp_emp_id =:epp_emp_id");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("epp_emp_id", employeeId);
		namedParameters.put("epp_number", empPassport.getPassportNumber());
		namedParameters.put("epp_date_of_issue", empPassport.getDateOfIssue());
		namedParameters.put("epp_date_of_expiry", empPassport.getDateOfExpiry());

		namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

	}

	@Override
	public void removePassport(int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM employeepassport WHERE epp_emp_id =:epp_emp_id");

		Map<String, Object> namedParamerters = new HashMap<String, Object>();

		namedParamerters.put("epp_emp_id", employeeId);

		namedParameterJdbcTemplate.update(sql.toString(), namedParamerters);

	}

	private static final class EmpPassportRowMapper implements RowMapper<EmpPassport> {

		@Override
		public EmpPassport mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpPassport empPassport = new EmpPassport();
			empPassport.setId(rs.getInt("epp_id"));
			empPassport.setPassportNumber(rs.getString("epp_number"));
			empPassport.setDateOfExpiry(rs.getDate("epp_date_of_expiry"));
			empPassport.setDateOfIssue(rs.getDate("epp_date_of_issue"));
			return empPassport;
		}

	}

}
