package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Sortinfo;
import com.journaldev.spring.model.Sortnumber;

public interface SortDAO {
	public boolean addSortingInfo(Sortinfo sortInfo);
	public List<Sortinfo> listSorts();
	public List<Sortnumber> listNumbers(int sortId);
	
	
}
