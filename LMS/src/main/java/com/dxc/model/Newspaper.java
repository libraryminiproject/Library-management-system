package com.dxc.model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="newspaper")
public class Newspaper {
	@Id
	
	private int pages;
	private String language;
	private String name;
	private int price;
	private Date dob;
	
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
	
	public Newspaper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Newspaper(int pages, String language, String name, int price,String dobth) throws ParseException {
		super();
		this.pages = pages;
		this.price = price;
		this.name = name;
		this.language=language;
		SimpleDateFormat date= new SimpleDateFormat("dd-MM-yyyy");
		dob =date.parse(dobth);
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Newspaper [pages=" + pages + ", language=" + language + ", name=" + name + ", price=" + price + ", dob="
				+ dob + ", date=" + date + "]";
	}
	
	
	
}