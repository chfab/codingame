package fr.chfab.codingames.temperatures;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Solution {
	
    public static void main(String args[]) {
    	List<Integer> temperatures = getInput( System.in );
    	Integer result = getTemperatureNearestFromZero( temperatures );
        System.out.println( result );
    }
    
    public static List<Integer> getInput( InputStream source ) {
    	Scanner in = new Scanner( source );
        int nbTemperaturesToAnalyse = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String nTemperatures = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

        List<Integer> temps = null;
        if ( nbTemperaturesToAnalyse != 0 ) {
        	 temps = Arrays.stream(nTemperatures.split(" "))
        			 		.map(s->Integer.valueOf(s))
        			 		.collect(Collectors.toList());
        }
        in.close();
        return temps;
    }
    
    public static Integer getTemperatureNearestFromZero( List<Integer> temperatures) {    	
    	if (temperatures == null) {
    		return 0;
    	}
    	
    	int size = temperatures.size();
    	Integer nearestFromZero = Integer.MAX_VALUE;
        for (int i=0; i<size; ++i) {
        	Integer temperature = temperatures.get(i);
        	if ( Math.abs(temperature) == Math.abs(nearestFromZero) ) {
        		nearestFromZero = Math.max(temperature,nearestFromZero);
        	} else if ( Math.abs(temperature) < Math.abs(nearestFromZero) ) {
        		nearestFromZero = temperature;
        	}
        }
    	return nearestFromZero;
    }
}