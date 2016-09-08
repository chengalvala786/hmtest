package com.hm.smartapp.service.sorting;

import com.hm.smartapp.model.Sortinfo;

public class InsertionSortServiceImpl implements SortingService{
	
	public  void sort(Integer[] ar, Sortinfo sortInfo) {
		//Prefered nano time for reason that if the size of the array is less then time taken will be negligable,
		long sortStartTime = System.nanoTime();
		
		int size =  ar.length;
		if (size <= 1) {
			sortInfo.setSortSwaps(0);
		  }
		  int shifts = 0;
		  for (int i = 1; i < size; i++) {
		    int moveMe = ar[i];
		    int j = i;
		    while (j > 0 && moveMe < ar[j - 1]) {
		      ar[j] = ar[j - 1];
		      --j;
		      ++shifts;
		    }
		    ar[j] = moveMe;
		  }
		  
		  //setting the sorts sort shifts
		  sortInfo.setSortSwaps(shifts);
		  long sortEndTime = System.nanoTime();
		  //setting the sort duration in nano seconds. 
		  sortInfo.setSortDuration(sortEndTime - sortStartTime);
		  
		  
		}
	
	
	
	
	

}
