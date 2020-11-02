package com.dxc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.text.ParseException;
import java.text.SimpleDateFormat;
@Entity
public class IssuedBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int	user_id;
private  int book_number;
private  String book_title;
private String book_author;
private Date issueddob;
private String username;

public IssuedBook() {
	super();
	// TODO Auto-generated constructor stub
}

	
	public IssuedBook(int user_id, int book_number, String book_title, String book_author,String issueddobth,String username) throws ParseException {
	super();
	this.user_id = user_id;
	this.book_number = book_number;
	this.book_title = book_title;
	this.username=username;
	this.book_author = book_author;
	SimpleDateFormat date= new SimpleDateFormat("dd-MM-yyyy");
	issueddob =date.parse(issueddobth);
	

}


public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getBook_number() {
		return book_number;
	}


	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}


	public String getBook_title() {
		return book_title;
	}


	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}


	public String getBook_author() {
		return book_author;
	}


	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}


	public Date getIssueddob() {
		return issueddob;
	}


	public void setIssueddob(Date issueddob) {
		this.issueddob = issueddob;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


@Override
public String toString() {
	return "IssuedBook [user_id=" + user_id + ", book_number=" + book_number + ", book_title=" + book_title
			+ ", book_author=" + book_author + ", issueddob=" + issueddob + "]";
}

}
