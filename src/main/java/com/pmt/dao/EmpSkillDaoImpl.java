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
import com.pmt.model.Skill;

@Repository(value = "empSkillDaoImpl")
public class EmpSkillDaoImpl implements EmpSkillDao {

	@Autowired
	@Qualifier("namedParamJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int addSkills(int employeeId, Set<EmpSkill> empSkills) {
		String sql = "INSERT INTO employeeskill " + "(es_id, es_emp_id, es_skl_id, es_experience_in_months) "
				+ "VALUES(:es_id,:es_emp_id, :es_skl_id, :es_experience_in_months)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();

		empSkills.forEach(empSkill -> {
			namedParameters.put("es_id", empSkill.getId());
			namedParameters.put("es_emp_id", employeeId);
			namedParameters.put("es_skl_id", empSkill.getSkill().getId());
			namedParameters.put("es_experience_in_months", empSkill.getExperienceInMonths());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

		return empSkills.size();

	}

	@Override
	public int removeSkills(int employeeId, Set<Integer> skillIds) {
		String sql = "DELETE FROM employeeskill WHERE es_emp_id =:es_emp_id && es_skl_id IN (:es_skl_ids)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("es_emp_id", employeeId);
		namedParameters.put("es_skl_ids", skillIds);
		return namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	@Override
	public List<EmpSkill> listSkillsById(int employeeId) {
		String sql = "SELECT * FROM employeeskill INNER JOIN skill ON es_skl_id = skl_id WHERE es_emp_id =:es_emp_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("es_emp_id", employeeId);
		return namedParameterJdbcTemplate.query(sql, namedParameters, new EmpSkillMapper());
	}

	@Override
	public void updateSkillsByEmployeeId(int employeeId, Set<EmpSkill> empSkills) {
		String sql = "UPDATE employeeskill SET es_experience_in_months=:es_experience_in_months "
				+ "WHERE es_emp_id =:es_emp_id && es_skl_id =:es_skl_id";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		empSkills.forEach(empSkill -> {
			namedParameters.put("es_experience_in_months", empSkill.getExperienceInMonths());
			namedParameters.put("es_emp_id", employeeId);
			namedParameters.put("es_skl_id", empSkill.getSkill().getId());
			namedParameterJdbcTemplate.update(sql, namedParameters);
		});

	}

	private static final class EmpSkillMapper implements RowMapper<EmpSkill> {
		public EmpSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpSkill empSkill = new EmpSkill();
			Skill skill = new Skill();
			skill.setId(rs.getInt("skl_id"));
			skill.setName(rs.getString("skl_name"));
			empSkill.setExperienceInMonths(rs.getInt("es_experience_in_months"));
			empSkill.setId(rs.getInt("es_id"));
			empSkill.setSkill(skill);

			return empSkill;
		}
	}

}
