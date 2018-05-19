package com.pmt.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.SkillDao;
import com.pmt.model.Skill;

@Transactional(isolation=Isolation.READ_COMMITTED)
@Service(value="skillServiceImpl")
public class SkillServiceImpl implements SkillService {
	
	private static Logger logger = LogManager.getLogger(SkillServiceImpl.class);
	
	@Autowired
	@Qualifier("skillDaoImpl")
	private SkillDao skillDao;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public void addSkill(Skill skill) {
		skillDao.addSkill(skill);
		
	}

	@Override
	@Transactional
	public void updateSkill(Skill skill) {
		
		skillDao.updateSkill(skill);
	}

	@Override
	@Transactional
	public List<Skill> listSkills() {
		
		return skillDao.listSkills();
	}

	@Override
	@Transactional
	public Skill getSkillById(int id) {
		
		return skillDao.getSkillById(id);
	}

	@Override
	@Transactional
	public void removeSkill(int id) {
		
		skillDao.removeSkill(id);
	}

	@Override
	@Transactional
	public Skill getSkillByName(String name) {
		return skillDao.getSkillByName(name);
		
	}

	@Override
	@Transactional
	public List<Skill> getSkillsById(int id) {
		
		return skillDao.getSkillsById(id);
	}

	@Override
	@Transactional
	public List<Skill> getSkillsByName(String name) {
		
		return skillDao.getSkillsByName(name);
	}

	@Override
	@Transactional
	public List<Skill> getSkillsByCategory(String category) {

		return skillDao.getSkillsByCategory(category);
	}

		
	

}
