package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class UpdateDaoImpl implements UpdateDao {

	private static Session session = GetConnection.getSession();
	private static String sql, hql;
	
	@Override
	public int updateCourseName(String name, int id) {
		
		sql = "update Course set name = :name where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("name", name);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateCourseDescription(String description, int id) {
		
		sql = "update Course set description = :description where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("description", description);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;		
	}

	@Override
	public int updateAchievementTitle(String title, int id) {
		
		sql = "update Achievement set title = :title where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("title", title);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateAchievementDescription(String description, int id) {
		
		sql = "update Achievement set description = :description where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("description", description);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateAchievementYear(int year, int id) {
		
		sql = "update Achievement set year = :year where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("year", year);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateEducationLevel(String level, int year) {
		
		sql = "update Education set level = :level where year = :year";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("level", level);
		q.setParameter("year", year);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateEducationDescription(String description, int year) {
		
		sql = "update Education set description = :description where year = :year";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("description", description);
		q.setParameter("year", year);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int updateEducationScore(String score, int year) {
		
		sql = "update Education set score = :score where year = :year";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("score", score);
		q.setParameter("year", year);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}
}