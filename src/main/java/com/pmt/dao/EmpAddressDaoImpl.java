package com.pmt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pmt.custom.exceptions.InternalServerException;
import com.pmt.model.IndividualAddress;

@Repository(value = "empAddressDaoImpl")
public class EmpAddressDaoImpl implements EmpAddressDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final Logger logger = LogManager.getLogger(EmpAddressDaoImpl.class);

	@Override
	public List<IndividualAddress> getEmployeeAddressesByEmployeeId(int employeeId) {
		logger.debug("Getting addresses for the employee with Id:" + employeeId);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM individualaddress WHERE ia_id IN ");
		sql.append("(");
		sql.append("SELECT empaddr_ia_id FROM employeeaddress WHERE empaddr_emp_id =:empaddr_emp_id");
		sql.append(")");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("empaddr_emp_id", employeeId);

		return namedParameterJdbcTemplate.query(sql.toString(), paramMap, new PersonalAddressRowMapper());
	}

	@Override
	public boolean addEmployeeAddress(IndividualAddress employeeAddress, int employeeId) {
		logger.debug("Adding address for the employee with Id:" + employeeId);
		logger.debug("address entity: " + employeeAddress);
		KeyHolder addressKey = new GeneratedKeyHolder();
		String[] keyColumnNames = new String[1];
		keyColumnNames[0] = "ia_id";
		int numberOfRowsAffected = 0;

		StringBuilder sqlCreateAddress = new StringBuilder();
		sqlCreateAddress.append("INSERT INTO individualaddress ");
		sqlCreateAddress.append("(");
		sqlCreateAddress.append("ia_street_name, ia_building_number, ia_city, ia_state, ");
		sqlCreateAddress.append("ia_country, ia_postal_code, ia_addr_line_1, ia_addr_line_2, ");
		sqlCreateAddress.append("ia_addr_line_3, ia_addr_type");
		sqlCreateAddress.append(")");
		sqlCreateAddress.append("VALUES ");
		sqlCreateAddress.append("(");
		sqlCreateAddress.append(":ia_street_name, :ia_building_number, :ia_city, :ia_state, ");
		sqlCreateAddress.append(":ia_country, :ia_postal_code, :ia_addr_line_1, :ia_addr_line_2, ");
		sqlCreateAddress.append(":ia_addr_line_3, :ia_addr_type");
		sqlCreateAddress.append(")");

		StringBuilder sqlCreateMapping = new StringBuilder();
		sqlCreateMapping.append("INSERT INTO employeeaddress ");
		sqlCreateMapping.append("(");
		sqlCreateMapping.append("empaddr_ia_id, empaddr_emp_id");
		sqlCreateMapping.append(")");
		sqlCreateMapping.append("VALUES ");
		sqlCreateMapping.append("(");
		sqlCreateMapping.append(":empaddr_ia_id, :empaddr_emp_id");
		sqlCreateMapping.append(")");

		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("ia_street_name", employeeAddress.getStreetName())
				.addValue("ia_building_number", employeeAddress.getBuildingNumber())
				.addValue("ia_city", employeeAddress.getCity()).addValue("ia_state", employeeAddress.getState())
				.addValue("ia_country", employeeAddress.getCountry())
				.addValue("ia_postal_code", employeeAddress.getPostalCode())
				.addValue("ia_addr_line_1", employeeAddress.getAddressLine1())
				.addValue("ia_addr_line_2", employeeAddress.getAddressLine2())
				.addValue("ia_addr_line_3", employeeAddress.getAddressLine3())
				.addValue("ia_addr_type", employeeAddress.getAddressType());

		try {
			if (namedParameterJdbcTemplate.update(sqlCreateAddress.toString(), paramSource, addressKey,
					keyColumnNames) == 1) {
				logger.debug("Address Record id: " + addressKey.getKey().intValue());
				SqlParameterSource paramSourceCreateMapping = new MapSqlParameterSource()
						.addValue("empaddr_ia_id", addressKey.getKey().intValue()).addValue("empaddr_emp_id", employeeId);

				numberOfRowsAffected = namedParameterJdbcTemplate.update(sqlCreateMapping.toString(),
						paramSourceCreateMapping);

			}
		} catch (InvalidDataAccessApiUsageException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		if (numberOfRowsAffected == 1)
			return true;
		else
			throw new InternalServerException("Unexpected error occured while adding address to the employee.");
	}

	@Override
	public boolean updateEmployeeAddress(IndividualAddress employeeAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	private final class PersonalAddressRowMapper implements RowMapper<IndividualAddress> {

		@Override
		public IndividualAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
			IndividualAddress personalAddress = new IndividualAddress();
			personalAddress.setAddressLine1(rs.getString("ia_addr_line_1"));
			personalAddress.setAddressLine2(rs.getString("ia_addr_line_2"));
			personalAddress.setAddressLine3(rs.getString("ia_addr_line_3"));
			personalAddress.setAddressType(rs.getString("ia_addr_type"));
			personalAddress.setBuildingNumber(rs.getString("ia_building_number"));
			personalAddress.setCity(rs.getString("ia_city"));
			personalAddress.setCountry(rs.getString("ia_country"));
			personalAddress.setId(rs.getInt("ia_id"));
			personalAddress.setPostalCode(rs.getInt("ia_postal_code"));
			personalAddress.setState(rs.getString("ia_state"));
			personalAddress.setStreetName(rs.getString("ia_street_name"));

			return personalAddress;
		}

	}

}
