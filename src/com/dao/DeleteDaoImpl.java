package com.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.fileprocessing.FileUploadDelete;


public class DeleteDaoImpl implements DeleteDao {

	private static Session session = GetConnection.getSession();
	private static String sql;
	
	@Override
	public int deleteCourse(int id) {
		
		sql = "delete from Course where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int deleteAchievement(int id) {
		
		sql = "delete from Achievement where id = :id";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("id", id);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int deleteEducation(int year) {
		
		sql = "delete from Education where year = :year";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("year", year);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int deleteMessage(String email) {
		
		sql = "delete from Message where email = :email";
		NativeQuery q = session.createNativeQuery(sql);
		q.setParameter("email", email);
		Transaction t = session.beginTransaction();
		int row = q.executeUpdate();
		t.commit();
		
		return row;
	}

	@Override
	public int deleteProject(HttpServletRequest request, String filename) {
		
		try {
			Connection con = GetConnection.getCon();
			con.setAutoCommit(false);
			
			sql = "delete from Project where filename = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, filename);
			
			int row = ps.executeUpdate();
			if(row == 1) {
				if(new FileUploadDelete().deleteFile(request, filename)) {
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