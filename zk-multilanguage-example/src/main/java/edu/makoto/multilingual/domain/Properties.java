package edu.makoto.multilingual.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Properties implements edu.makoto.multilingual.dao.Entity {

	@Id
	private int id;
	
	private String key;
	
	private String value;
	
	private String language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "key : " + key + "| value: " +value + "| language : " + language +" \n";
	}
}