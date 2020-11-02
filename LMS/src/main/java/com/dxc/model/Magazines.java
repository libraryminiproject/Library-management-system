package com.dxc.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Magazines {
	@Id
	private String name;
	private Date dob;
	private int pages;
	private int price;
	private int rackno;

	public Magazines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magazines(String magazine, String dobth, int rackno,int pages,int price) throws ParseException {
		super();
		this.name=name;
		this.rackno = rackno;
		this.pages=pages;
		this.price=price;
		
		SimpleDateFormat date= new SimpleDateFormat("dd-MM-yyyy");
		dob =date.parse(dobth);
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRackno() {
		return rackno;
	}

	public void setRackno(int rackno) {
		this.rackno = rackno;
	}

	@Override
	public String toString() {
		return "Magazines [name=" + name + ", dob=" + dob + ", pages=" + pages + ", price=" + price + ", rackno="
				+ rackno + "]";
	}

	
	
}