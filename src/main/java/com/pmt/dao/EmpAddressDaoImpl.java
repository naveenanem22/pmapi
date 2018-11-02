package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pmt.model.PersonalAddress;

@Repository(value = "empAddressDaoImpl")
public class EmpAddressDaoImpl implements EmpAddressDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<PersonalAddress> getEmployeeAddressesByEmployeeId(int employeeId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM personaladdress WHERE paddr_id IN ");
		sql.append("(");
		sql.append("SELECT empaddr_paddr_id FROM employeeaddress WHERE empaddr_emp_id =:empaddr_emp_id");
		sql.append(")");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("empaddr_emp_id", employeeId);

		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new PersonalAddressRowMapper());
	}

	@Override
	public boolean addEmployeeAddress(PersonalAddress employeeAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployeeAddress(PersonalAddress employeeAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	private final class PersonalAddressRowMapper implements RowMapper<PersonalAddress> {

		@Override
		public PersonalAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
			PersonalAddress personalAddress = new PersonalAddress();
			personalAddress.setAddressLine1(rs.getString("paddr_addr_line_1"));
			personalAddress.setAddressLine2(rs.getString("paddr_addr_line_2"));
			personalAddress.setAddressLine3(rs.getString("paddr_addr_line_3"));
			personalAddress.setAddressType(rs.getString("paddr_addr_type"));
			personalAddress.setBuildingNumber(rs.getString("paddr_building_number"));
			personalAddress.setCity(rs.getString("paddr_city"));
			personalAddress.setCountry(rs.getString("paddr_country"));
			personalAddress.setId(rs.getInt("paddr_id"));
			personalAddress.setPostalCode(rs.getInt("paddr_postal_code"));
			personalAddress.setState(rs.getString("paddr_state"));
			personalAddress.setStreetName(rs.getString("paddr_street_name"));

			return personalAddress;
		}

	}

}
