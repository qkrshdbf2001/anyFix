package com.kitri.project.adExercise;

import java.sql.Date;

public class AdExercise {
	private int num;
	private String f_level;
	private String title;
	private String w_date;
	private String contents;
	private String w_check;

	public AdExercise() {

	}

	public AdExercise(int num, String f_level, String title, String w_date, String contents, String w_check) {
		this.num = num;
		this.f_level = f_level;
		this.title = title;
		this.w_date = w_date;
		this.contents = contents;
		this.w_check = w_check;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getF_level() {
		return f_level;
	}

	public void setF_level(String f_level) {
		this.f_level = f_level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getW_date() {
		return w_date;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getW_check() {
		return w_check;
	}

	public void setW_check(String w_check) {
		this.w_check = w_check;
	}

	@Override
	public String toString() {
		return "AdExercise [num=" + num + ", f_level=" + f_level + ", title=" + title + ", w_date=" + w_date
				+ ", contents=" + contents + ", w_check=" + w_check + "]";
	}

}
