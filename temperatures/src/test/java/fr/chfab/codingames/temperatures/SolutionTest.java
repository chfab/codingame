package fr.chfab.codingames.temperatures;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest 
{
    public SolutionTest()
    {
    }

    @Test
    public void should_return_0_when_no_temperature_provided()
    {
    	int expected = 0;
    	int result   = Solution.getTemperatureNearestFromZero( null );
    	
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void should_return_1_when_temperatures_are_1_minus2_minus8_4_5()
    {
    	List<Integer> temperatures = new ArrayList<Integer>();
    	temperatures.add(  1 );
    	temperatures.add( -2 );
    	temperatures.add( -8 );
    	temperatures.add(  4 );
    	temperatures.add(  5 );
    	
    	int expected = 1;
    	int result   = Solution.getTemperatureNearestFromZero( temperatures );
    	
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void should_return_minus5_when_temperatures_are_minus12_minus5_minus137()
    {
    	List<Integer> temperatures = new ArrayList<Integer>();
    	temperatures.add( -12 );
    	temperatures.add( -5 );
    	temperatures.add( -137 );
    	
    	int expected = -5;
    	int result   = Solution.getTemperatureNearestFromZero( temperatures );
    	
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void should_return_5_when_temperatures_are_42_minus5_12_21_5_24()
    {
    	List<Integer> temperatures = new ArrayList<Integer>();
    	temperatures.add(  42 );
    	temperatures.add( -5  );
    	temperatures.add(  12 );
    	temperatures.add(  21 );
    	temperatures.add(  5  );
    	temperatures.add(  24 );
    	
    	int expected = 5;
    	int result   = Solution.getTemperatureNearestFromZero( temperatures );
    	
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void should_return_5_when_temperatures_are_42_5_12_21_minus5_24()
    {
    	List<Integer> temperatures = new ArrayList<Integer>();
    	temperatures.add(  42 );
    	temperatures.add(  5  );
    	temperatures.add(  12 );
    	temperatures.add(  21 );
    	temperatures.add( -5  );
    	temperatures.add(  24 );
    	
    	int expected = 5;
    	int result   = Solution.getTemperatureNearestFromZero( temperatures );
    	
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void should_return_2_when_temperatures_are_minus5_minus4_minus2_12_minus40_4_2_18_11_5()
    {
    	List<Integer> temperatures = new ArrayList<Integer>();
    	temperatures.add( -5  );
    	temperatures.add( -4  );
    	temperatures.add( -2  );
    	temperatures.add(  12 );
    	temperatures.add( -40 );
    	temperatures.add(  4  );
    	temperatures.add(  2  );
    	temperatures.add(  18 );
    	temperatures.add(  11 );
    	temperatures.add(  5  );
    	
    	int expected = 2;
    	int result   = Solution.getTemperatureNearestFromZero( temperatures );
    	
        assertThat(result).isEqualTo(expected);
    }
}
