package com.pmt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Skill;

@Repository(value="skillDaoImpl")
public class SkillDaoImpl implements SkillDao{

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addSkill(Skill skill) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(skill);
		
	}

	@Override
	public void updateSkill(Skill skill) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(skill);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> listSkills() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Skill> skillList = session.createQuery("from Skill").list();
		return skillList;
	}

	@Override
	public Skill getSkillById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Skill skill  = (Skill) session.load(Skill.class, new Integer(id));		
		return skill;
		
	}

	@Override
	public void removeSkill(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Skill skill = (Skill) session.load(Skill.class, new Integer(id));
		if(null!=skill){
			session.delete(skill);
		}
		
	}

	@Override
	public Skill getSkillByName(String name) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Skill AS sk WHERE sk.name = :skillname");
		query.setParameter("skillname", name);
		Skill skill = (Skill) query.list().get(0);
		System.out.println(skill.getId());
		System.out.println(skill.getName());
		System.out.println(skill.getDescription());
		
		return skill;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkillsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Skill AS sk WHERE sk.id = :skillid");
		query.setParameter("skillid", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkillsByName(String name) {
	
        name = "%"+name+"%";
        Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Skill AS sk WHERE sk.name like :skillname");
		query.setParameter("skillname", name);		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkillsByCategory(String category) {
		category = "%"+category+"%";
		Session session =  this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Skill AS sk WHERE sk.category like :skillcategory");
		query.setParameter("skillcategory", category);
		return query.list();
	}

}
