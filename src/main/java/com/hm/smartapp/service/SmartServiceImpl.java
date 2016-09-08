package com.hm.smartapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.smartapp.dao.SortDAO;
import com.hm.smartapp.model.Sortinfo;
import com.hm.smartapp.model.Sortnumber;
import com.hm.smartapp.service.numbergenerator.NumberPickerService;
import com.hm.smartapp.service.sorting.SortingService;

@Qualifier(value="SmartService")
@Service
public class SmartServiceImpl implements SmartService {
	
	private SortDAO sortDAO;
	private NumberPickerService digitPickerService;
	private SortingService sortService;
	
	
	
	public void setSortDAO(SortDAO sortDAO) {
		this.sortDAO = sortDAO;
	}


	public void setDigitPickerService(NumberPickerService digitPickerService) {
		this.digitPickerService = digitPickerService;
	}

	

	public void setSortService(SortingService sortService) {
		this.sortService = sortService;
	}

	

	@Override
	@Transactional
	public Sortinfo createAndSaveSortInfo(int sizeOfNumbers) {
		Integer[] numbers =  digitPickerService.generateRandomNumbers(sizeOfNumbers);
		Integer swaps =0 ; 
		Sortinfo sortInfo = new Sortinfo();
		//Sorting the numbers generated randomly. sortInfo will be passed to capture swaps and sort duration.
		sortService.sort(numbers , sortInfo);
		
		sortInfo.setSizeOfNumbers(sizeOfNumbers);
		
		sortInfo.setSortDate(new Date());
		
		List<Sortnumber> sortedList = new ArrayList<>();
		//Creating DTO to saved the latest sort information. 
		for (Integer number : numbers ){
			Sortnumber sortedItem = new Sortnumber();
			sortedItem.setSortNumber(number);
			sortedItem.setSortinfo(sortInfo);
			sortedList.add(sortedItem);
		}
		sortInfo.setSortnumbers(sortedList);
		this.sortDAO.addSortingInfo(sortInfo);
		return sortInfo;
		
	}
	
	@Override
	@Transactional
	public List<Sortinfo> listPastSorts() {
		return this.sortDAO.listSorts();
	}

	@Override
	@Transactional
	public List<Sortnumber> retriveSortNumbers( int sortId) {
		// TODO Auto-generated method stub
	return this.sortDAO.listNumbers(sortId);
		
		
		
	}
	
	
	
	
	

}
