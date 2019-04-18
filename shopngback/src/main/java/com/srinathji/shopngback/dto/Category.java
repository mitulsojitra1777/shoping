package com.srinathji.shopngback.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*
 * create table category( 
    id IDENTITY, 
    name VARCHAR(50), 
    description VARCHAR(255), 
    imageurl VARCHAR(50), 
    active BOOLEAN, 
    CONSTRAINT pk_category_id PRIMARY KEY(id) 
     

);
 * */


@Entity
public class Category {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageurl=" + imageurl
				+ ", active=" + active + "]";
	}

	/**
	 * create our private fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String imageurl;
	private boolean active = true;
}
