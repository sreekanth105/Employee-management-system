package com.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timetableId;
	private String stream;
	private String batch;
	private String name;

	public int getTimetableId() {
		return timetableId;
	}

	public void setTimetableId(int timetableId) {
		this.timetableId = timetableId;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Timetable(String stream, String batch, String name) {
		super();
		this.stream = stream;
		this.batch = batch;
		this.name = name;
	}

	public Timetable() {
		super();
		// TODO Auto-generated constructor stub
	}

}
