package com.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.fileprocessing.FileUploadDelete;

public class InsertDaoImpl implements InsertDao {

	private static Session session = GetConnection.getSession();
	private static String sql;
	@Override
	public int insertCourse(int id, String name, String description) {
		
		sql = "insert into Course(id, description, name) values(:id, :description, :name)";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("id", id);
		q.setParameter("name", name);
		q.setParameter("description", description);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int insertAchievement(int id, int year, String title, String description) {
		
		sql = "insert into Achievement(id, year, title, description) values(:id, :year, :title, :description)";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("id", id);
		q.setParameter("year", year);
		q.setParameter("title", title);
		q.setParameter("description", description);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int insertEducation(int year, String level, String description, String score) {
		
		sql = "insert into Education(year, description, level, score) values(:year, :description, :level, :score)";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("year", year);
		q.setParameter("level", level);
		q.setParameter("description", description);
		q.setParameter("score", score);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int insertMessage(String name, String email, String description) {
		
		sql = "insert into Message(email, description, name) values(:email, :description, :name)";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("name", name);
		q.setParameter("email", email);
		q.setParameter("description", description);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int insertProject(int id, String uniquefilename, HttpServletRequest request) {
		
		try {
			Connection con = GetConnection.getCon();
			con.setAutoCommit(false);
			
			sql = "insert into Project(id, filename) values(?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setString(2, uniquefilename);
			
			int row = ps.executeUpdate();
			if(row == 1) {
				if(new FileUploadDelete().uploadFile(request, uniquefilename)) {
					con.commit();	
					return 1;
				}
				else {
					con.rollback();
					return 0;
				}	
			} else
				return 0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
}