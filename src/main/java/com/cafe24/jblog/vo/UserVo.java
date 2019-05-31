package com.cafe24.jblog.vo;

public class UserVo {

	private String id;
	private String name;
	private String password;
	private String reg_date;
	private String grade;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getreg_date() {
		return reg_date;
	}
	public void setreg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", password=" + password + ", reg_date=" + reg_date + ", grade="
				+ grade + "]";
	}
	

	

}
