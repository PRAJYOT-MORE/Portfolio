package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.pojo.AchievementPojo;
import com.pojo.CoursePojo;
import com.pojo.EducationPojo;
import com.pojo.MessagePojo;
import com.pojo.ProjectPojo;

public class GetConnection {

	public static Session getSession() {
		
		Configuration cfg = new Configuration();
		
		Properties p = new Properties();
		p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		p.put(Environment.URL, "jdbc:mysql://localhost:3306/MyPortfolio");
		p.put(Environment.USER, "root");
		p.put(Environment.PASS, "");
		p.put(Environment.SHOW_SQL, true);
		p.put(Environment.HBM2DDL_AUTO, "update");
		
		cfg.setProperties(p);
		
		// Add your annotated class
		cfg.addAnnotatedClass(AchievementPojo.class);
		cfg.addAnnotatedClass(EducationPojo.class);
		cfg.addAnnotatedClass(CoursePojo.class);
		cfg.addAnnotatedClass(MessagePojo.class);
		cfg.addAnnotatedClass(ProjectPojo.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		return session;
	}
	
	public static Connection getCon() throws SQLException {
		
		MysqlDataSource ds = new MysqlDataSource();
		
		ds.setUrl("jdbc:mysql://localhost:3306/MyPortfolio");
		ds.setUser("root");
		ds.setPassword("");
		
		Connection con = ds.getConnection();
		
		return con;
	}
}
