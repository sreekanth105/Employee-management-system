package com.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String event_name;
	private String event_date;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Events(String event_name, String event_date, byte[] picByte) {
		super();
		this.event_name = event_name;
		this.event_date = event_date;
		this.picByte = picByte;
	}

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

}
