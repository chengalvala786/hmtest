package com.hm.smartapp.service;

import java.util.List;

import com.hm.smartapp.model.Sortinfo;
import com.hm.smartapp.model.Sortnumber;

public interface SmartService {

	public Sortinfo createAndSaveSortInfo(int sizeOfNumbers);
	public List<Sortinfo> listPastSorts(); 
	public List<Sortnumber> retriveSortNumbers( int sortId);
	
	
}
