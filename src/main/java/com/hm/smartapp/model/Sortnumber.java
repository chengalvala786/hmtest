package com.journaldev.spring.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the sortnumbers database table.
 * 
 */
@Entity
@Table(name="sortnumbers")
@NamedQuery(name="Sortnumber.findAll", query="SELECT s FROM Sortnumber s")
public class Sortnumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="keygen", strategy="increment")
	@GeneratedValue(generator="keygen")
	private int id;

	@Column(name="sort_number")
	private int sortNumber;

	//bi-directional many-to-one association to Sortinfo
	@ManyToOne
	private Sortinfo sortinfo;

	public Sortnumber() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSortNumber() {
		return this.sortNumber;
	}

	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}

	public Sortinfo getSortinfo() {
		return this.sortinfo;
	}

	public void setSortinfo(Sortinfo sortinfo) {
		this.sortinfo = sortinfo;
	}

}