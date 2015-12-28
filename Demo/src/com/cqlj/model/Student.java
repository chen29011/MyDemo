package com.cqlj.model;

public class Student {
	/** 学生ID号 */
	private Integer id;
	/** 学生姓名 */
	private String stuName;
	/** 学生年龄 */
	private Integer age;
	/** 学生性别 */
	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
