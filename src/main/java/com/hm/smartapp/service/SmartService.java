package com.journaldev.spring.smart.service;

import java.util.List;

import com.journaldev.spring.model.Sortinfo;
import com.journaldev.spring.model.Sortnumber;

public interface SmartService {

	public Sortinfo createAndSaveSortInfo(int sizeOfNumbers);
	public List<Sortinfo> listPastSorts(); 
	public List<Sortnumber> retriveSortNumbers( int sortId);
	
	
}
