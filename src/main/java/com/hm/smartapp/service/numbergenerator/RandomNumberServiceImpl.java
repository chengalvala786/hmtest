package com.hm.smartapp.service.numbergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @author aravind
 *
 */
public class RandomNumberServiceImpl implements NumberPickerService {
	
	private static final long RANDOM_SEED=98765432;
	
	/**
	 * This method takes number of random number to generate and uses SEED to generate the random Integers.
	 * @param  exception
	 * @return List<Integer> 
	 */
	@Override
	public Integer[] generateRandomNumbers( int sizeOfNumbers ) {
		 Integer[] listOfIntegers= new Integer[sizeOfNumbers];
		 Random randomno = new Random();
		 randomno.setSeed(RANDOM_SEED);
		 for (int index = 0 ; index < sizeOfNumbers ; index ++  ){
			 listOfIntegers[index] =  Math.abs(randomno.nextInt());
		 }
		return listOfIntegers;
	}

}
