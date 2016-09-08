package com.hm.smartapp.dao;

import java.util.List;

import com.hm.smartapp.model.Sortinfo;
import com.hm.smartapp.model.Sortnumber;

public interface SortDAO {
	public boolean addSortingInfo(Sortinfo sortInfo);
	public List<Sortinfo> listSorts();
	public List<Sortnumber> listNumbers(int sortId);
	
	
}
