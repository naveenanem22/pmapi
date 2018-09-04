package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.EmpAddress;

@Repository(value = "empAddressDaoImpl")
public class EmpAddressDaoImpl implements EmpAddressDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmpAddress> listEmpAddresses(String employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM empaddress WHERE ea_empid =:ea_empid");
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("ea_empid", employeeId);
		return namedParameterJdbcTemplate.query(sql.toString(), namedParameters, new EmpAddressRowMapper());

	}

	@Override
	public void addEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO empaddress ");
		sql.append("(");
		sql.append("ea_empid, ea_city, ea_country, ea_state, ea_pincode, ea_street, ");
		sql.append("ea_addrline1, ea_addrline2, ea_type");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("(");
		sql.append(":ea_empid, :ea_city, :ea_country, :ea_state, :ea_pincode, :ea_street, ");
		sql.append(":ea_addrline1, :ea_addrline2, :ea_type");
		sql.append(")");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empAddresses.forEach(empAddress -> {
			namedParameters.put("ea_empid", employeeId);
			namedParameters.put("ea_city", empAddress.getCity());
			namedParameters.put("ea_country", empAddress.getCountry());
			namedParameters.put("ea_state", empAddress.getState());
			namedParameters.put("ea_pincode", empAddress.getPincode());
			namedParameters.put("ea_street", empAddress.getStreet());
			namedParameters.put("ea_addrline1", empAddress.getAddressLine1());
			namedParameters.put("ea_addrline2", empAddress.getAddressLine2());
			namedParameters.put("ea_type", empAddress.getAddressType());

			namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

		});

	}

	@Override
	public void updateEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE empaddress SET ea_city =:ea_city, ea_country =:ea_country, ");
		sql.append(
				"ea_state =:ea_state, ea_pincode =:ea_pincode, ea_street =:ea_street, ea_addrline1 =:ea_addrline1, ");
		sql.append("ea_addrline2 =:ea_addrline2, ea_type =:ea_type ");
		sql.append("WHERE ea_empid =:ea_empid && ea_type =:oldAddressType");

		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empAddresses.forEach(empAddress -> {
			namedParameters.put("ea_empid", employeeId);
			namedParameters.put("ea_city", empAddress.getCity());
			namedParameters.put("ea_country", empAddress.getCountry());
			namedParameters.put("ea_state", empAddress.getState());
			namedParameters.put("ea_pincode", empAddress.getPincode());
			namedParameters.put("ea_street", empAddress.getStreet());
			namedParameters.put("ea_addrline1", empAddress.getAddressLine1());
			namedParameters.put("ea_addrline2", empAddress.getAddressLine2());
			namedParameters.put("ea_type", empAddress.getAddressType());
			namedParameters.put("oldAddressType", empAddress.getOldAddressType());

			namedParameterJdbcTemplate.update(sql.toString(), namedParameters);

		});

	}

	@Override
	public void removeEmpAddresses(String employeeId, Set<EmpAddress> empAddresses) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM empaddress WHERE ea_empid =:ea_empid && ea_type =:ea_type");
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empAddresses.forEach(empAddress -> {
			namedParameters.put("ea_empid", employeeId);
			namedParameters.put("ea_type", empAddress.getAddressType());

			namedParameterJdbcTemplate.update(sql.toString(), namedParameters);
		});

	}

	private static final class EmpAddressRowMapper implements RowMapper<EmpAddress> {

		@Override
		public EmpAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpAddress empAddress = new EmpAddress();
			empAddress.setAddressLine1(rs.getString("ea_addrline1"));
			empAddress.setAddressLine2(rs.getString("ea_addrline2"));
			empAddress.setAddressType(rs.getString("ea_type"));
			empAddress.setCity(rs.getString("ea_city"));
			empAddress.setCountry(rs.getString("ea_country"));
			empAddress.setPincode(rs.getInt("ea_pincode"));
			empAddress.setState(rs.getString("ea_state"));
			empAddress.setStreet(rs.getString("ea_street"));
			return empAddress;
		}

	}

}
