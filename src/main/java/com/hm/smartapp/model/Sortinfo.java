package com.hm.smartapp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sortinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Sortinfo.findAll", query="SELECT s FROM Sortinfo s")
public class Sortinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="keygen", strategy="increment")
	@GeneratedValue(generator="keygen")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sort_date")
	private Date sortDate;

	@Column(name="sort_duration")
	private long sortDuration;

	@Column(name="sort_swaps")
	private int sortSwaps;

	//bi-directional many-to-one association to Sortnumber
	
	@OneToMany(mappedBy="sortinfo" ,cascade=CascadeType.ALL)
	private List<Sortnumber> sortnumbers;
	
	@Column(name="sort_no_cnt")
	private Integer sizeOfNumbers;
	
	

	
	public Sortinfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSortDate() {
		return this.sortDate;
	}

	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}

	public long getSortDuration() {
		return this.sortDuration;
	}

	public void setSortDuration(long sortDuration) {
		this.sortDuration = sortDuration;
	}

	public int getSortSwaps() {
		return this.sortSwaps;
	}

	public void setSortSwaps(int sortSwaps) {
		this.sortSwaps = sortSwaps;
	}

	public List<Sortnumber> getSortnumbers() {
		return this.sortnumbers;
	}

	public void setSortnumbers(List<Sortnumber> sortnumbers) {
		this.sortnumbers = sortnumbers;
	}

	public Sortnumber addSortnumber(Sortnumber sortnumber) {
		getSortnumbers().add(sortnumber);
		sortnumber.setSortinfo(this);

		return sortnumber;
	}

	public Sortnumber removeSortnumber(Sortnumber sortnumber) {
		getSortnumbers().remove(sortnumber);
		sortnumber.setSortinfo(null);

		return sortnumber;
	}
	public Integer getSizeOfNumbers() {
		return sizeOfNumbers;
	}

	public void setSizeOfNumbers(Integer sizeOfNumbers) {
		this.sizeOfNumbers = sizeOfNumbers;
	}

	
	@Transient
	@Override
	public String toString() {
	
		return(" Sort ID " + getId()  + " Date " + getSortDate() + " Duration " +getSortDuration() +" Total Swaps " +getSortSwaps());
	}
	
}