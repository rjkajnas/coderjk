package com.rjk.mongoDBApp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="jobPost")
public class Post {
	
	private String profile;
	private String desc;
	private int experience;
	private String[] techStack;
	
	public Post() {
		
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String[] getTechStack() {
		return techStack;
	}
	public void setTechStack(String[] techStack) {
		this.techStack = techStack;
	}
	
	

}
