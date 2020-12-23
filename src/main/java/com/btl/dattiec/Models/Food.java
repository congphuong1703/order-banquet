package com.btl.dattiec.Models;


import javax.persistence.*;

@Entity
@Table(name ="food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "price")
	private int price;

	@Column(name = "note")
	private String note;


	public Food(String name, String type, int price, String note,String code) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.note = note;
		this.code = code;
	}

	public Food() {
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return code ;
	}
}
