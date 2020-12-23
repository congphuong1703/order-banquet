package com.btl.dattiec.Models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lobby")
public class Lobby {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name= "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "note")
	private String note;

	@Column(name ="price")
	private int price;


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lobby() {
	}

	@Override
	public String toString() {
		return code ;
	}
}
