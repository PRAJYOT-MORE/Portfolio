package com.dao;

import java.util.ArrayList;

import com.pojo.AchievementPojo;
import com.pojo.CoursePojo;
import com.pojo.EducationPojo;
import com.pojo.MessagePojo;
import com.pojo.ProjectPojo;

public interface ReadDao {

	public ArrayList<CoursePojo> readCourse();
	public ArrayList<AchievementPojo> readAchievement();
	public ArrayList<EducationPojo> readEducation();
	public ArrayList<MessagePojo> readMessage();
	public ArrayList<ProjectPojo> readProject();
}
