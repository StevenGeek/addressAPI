package com.service.address.orm.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="city_name")
	private String cityName;

	private String grade;

	@Column(name="parent_id")
	private String parentId;

	@Column(name="simple_spell")
	private String simpleSpell;

	private String spell;

	public City() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSimpleSpell() {
		return this.simpleSpell;
	}

	public void setSimpleSpell(String simpleSpell) {
		this.simpleSpell = simpleSpell;
	}

	public String getSpell() {
		return this.spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", grade=" + grade + ", parentId=" + parentId
				+ ", simpleSpell=" + simpleSpell + ", spell=" + spell + "]";
	}

}