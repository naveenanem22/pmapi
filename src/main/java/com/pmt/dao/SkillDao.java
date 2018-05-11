package com.pmt.dao;

import java.util.List;

import com.pmt.model.Skill;

public interface SkillDao {
	
	public void addSkill(Skill skill);
    public void updateSkill(Skill skill);
    public List<Skill> listSkills();
    public Skill getSkillById(int id);
    public List<Skill> getSkillsById(int id);
    public Skill getSkillByName(String name);
    public List<Skill> getSkillsByName(String name);
    public void removeSkill(int id);
    public List<Skill> getSkillsByCategory(String category);
	
}
