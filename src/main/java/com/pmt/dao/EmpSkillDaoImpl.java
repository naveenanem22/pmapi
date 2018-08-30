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

import com.pmt.model.EmpSkill;

@Repository(value = "empSkillDaoImpl")
public class EmpSkillDaoImpl implements EmpSkillDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int addSkills(String employeeId, Set<EmpSkill> empSkills) {
		String sql = "INSERT INTO empskill " + "(es_empid, es_sklid, es_experienceinmonths) "
				+ "VALUES(:es_empid, :es_sklid, :es_experienceinmonths)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();

		empSkills.forEach(empSkill -> {
			namedParameters.put("es_empid", employeeId);
			namedParameters.put("es_sklid", empSkill.getSkillId());
			namedParameters.put("es_experienceinmonths", empSkill.getExperienceInMonths());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empSkills.size();

	}

	@Override
	public int removeSkills(String employeeId, Set<String> skillIds) {
		String sql = "DELETE FROM empskill WHERE es_empid =:es_empid && es_sklid IN (:es_sklids)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("es_empid", employeeId);
		namedParameters.put("es_sklids", skillIds);
		return namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	@Override
	public List<EmpSkill> listSkillsById(String employeeId) {
		String sql = "SELECT * FROM empskill INNER JOIN skill ON es_sklid = skl_id WHERE es_empid =:es_empid";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("es_empid", employeeId);
		return namedParameterJdbcTemplate.query(sql, namedParameters, new EmpSkillMapper());
	}

	@Override
	public void updateSkillsByEmployeeId(String employeeId, Set<EmpSkill> empSkills) {
		String sql = "UPDATE empskill SET es_experienceinmonths=:es_experienceinmonths "
				+ "WHERE es_empid =:es_empid && es_sklid =:es_sklid";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empSkills.forEach(empSkill -> {
			namedParameters.put("es_experienceinmonths", empSkill.getExperienceInMonths());
			namedParameters.put("es_empid", employeeId);
			namedParameters.put("es_sklid", empSkill.getSkillId());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

	}

	private static final class EmpSkillMapper implements RowMapper<EmpSkill> {
		public EmpSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpSkill empSkill = new EmpSkill();
			empSkill.setExperienceInMonths(rs.getInt("es_experienceinmonths"));
			empSkill.setSkillId(rs.getString("es_sklid"));
			empSkill.setSkillName(rs.getString("skl_name"));

			return empSkill;
		}
	}

}
