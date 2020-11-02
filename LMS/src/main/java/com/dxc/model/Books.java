package com.dxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int bookid;
	private String name;
	private String author;
	private String category;
	private int price;
	private int rackno;
	private int quantity;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookid, String name, String author, String category, int price, int rackno, int quantity) {
		super();
		this.bookid = bookid;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.rackno = rackno;
		this.quantity = quantity;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", name=" + name + ", author=" + author + ", category=" + category+", price=" + price
				+ ", rackno=" + rackno + ", quantity=" + quantity + "]";
	}
	
	
}