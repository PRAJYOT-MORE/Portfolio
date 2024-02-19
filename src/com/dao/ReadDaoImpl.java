package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pojo.AchievementPojo;
import com.pojo.CoursePojo;
import com.pojo.EducationPojo;
import com.pojo.MessagePojo;
import com.pojo.ProjectPojo;

public class ReadDaoImpl implements ReadDao {

	private static Session session = GetConnection.getSession();
	private static String hql;
	private static ArrayList al;
	@Override
	public ArrayList<CoursePojo> readCourse() {

		hql = "from CoursePojo";
		Query q = session.createQuery(hql);
		List<CoursePojo> l = q.getResultList();
		al = new ArrayList<CoursePojo>(l);
		session.clear();
		return al;
	}

	@Override
	public ArrayList<AchievementPojo> readAchievement() {
		
		hql = "from AchievementPojo";
		Query q = session.createQuery(hql);
		List<AchievementPojo> l = q.getResultList();
		al = new ArrayList<AchievementPojo>(l);
		session.clear();
		return al;
	}

	@Override
	public ArrayList<EducationPojo> readEducation() {
		
		hql = "from EducationPojo";
		Query q = session.createQuery(hql);
		List<EducationPojo> l = q.getResultList();
		al = new ArrayList<EducationPojo>(l);
		session.clear();
		return al;
	}

	@Override
	public ArrayList<MessagePojo> readMessage() {
		
		hql = "from MessagePojo";
		Query q = session.createQuery(hql);
		List<MessagePojo> l = q.getResultList();
		al = new ArrayList<MessagePojo>(l);
		session.clear();
		return al;
	}

	@Override
	public ArrayList<ProjectPojo> readProject() {
		
		hql = "from ProjectPojo";
		Query q = session.createQuery(hql);
		List<ProjectPojo> l = q.getResultList();
		al = new ArrayList<ProjectPojo>(l);
		session.clear();
		return al;
	}

}
