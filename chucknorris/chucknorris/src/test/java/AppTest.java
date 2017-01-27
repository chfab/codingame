import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AppTest {

	private Solution solution;
	private Solution.ChuckNorrisEncoder chuckNorrisEncoder ;

    public AppTest( )
    {
    	solution = new Solution();
    	chuckNorrisEncoder = solution.new ChuckNorrisEncoder();
    }

    @Test
    public void should_return_0_000_when_bloc1_and_n3()
    {
    	String result = chuckNorrisEncoder.getBloc('1',3);
    	assertThat( result ).isEqualTo("0 000");
    }
    
    @Test
    public void should_return_00_00000_when_bloc0_and_n5()
    {
    	String result = chuckNorrisEncoder.getBloc('0',5);
    	assertThat( result ).isEqualTo("00 00000");
    }
    
    @Test
    public void should_return_0_0_00_0000_0_00_when_1000011() {
    	String result = chuckNorrisEncoder.encodeBinaryString("1000011");;
    	assertThat( result ).isEqualTo("0 0 00 0000 0 00");    	
    }
    
    @Test
    public void should_return_3_when_input_10001_from1() {
       	int result = chuckNorrisEncoder.getRepeatChar("10001",1);
    	assertThat( result ).isEqualTo(3);
    }
    
    @Test 
    public void should_return_1000011_when_inout_C() {
    	String result = chuckNorrisEncoder.convertToBinaryString("C");
    	assertThat( result ).isEqualTo("1000011");
    }
    
    @Test 
    public void should_return_10000111000011_when_inout_CC() {
    	String result = chuckNorrisEncoder.convertToBinaryString("CC");
    	assertThat( result ).isEqualTo("10000111000011");
    }
    
    @Test
    public void should_return_0_0_00_0000_0_00_when_C() {
    	String result = chuckNorrisEncoder.encode("C");;
    	assertThat( result ).isEqualTo("0 0 00 0000 0 00");    	
    }
    
    @Test
    public void should_return_0_0_00_0000_0_00_when_Percent() {
    	String result = chuckNorrisEncoder.encode("%");;
    	assertThat( result ).isEqualTo("00 0 0 0 00 00 0 0 00 0 0 0");    	
    }
}
