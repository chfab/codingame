import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private Solution ASCIIArtSolution;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest()
    {
    	setup();
    }

    public void setup() {
    	ASCIIArtSolution = new Solution();

    	ASCIIArtSolution.setLetterLength( 4 );
    	ASCIIArtSolution.setLetterHeight( 5 );

    	ASCIIArtSolution.setAlphabetForRow( 0, " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ");
    	ASCIIArtSolution.setAlphabetForRow( 1, "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ");
    	ASCIIArtSolution.setAlphabetForRow( 2, "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ");
    	ASCIIArtSolution.setAlphabetForRow( 3, "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ");
    	ASCIIArtSolution.setAlphabetForRow( 4, "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ");
    }

    @Test
    public void should_BeginIndex_equalTo_0_when_letter_is_A() {
    	int result = ASCIIArtSolution.getBeginIndexForLetter('A');
    	
    	assertThat( result ).isEqualTo( 0 );
    }
    
    @Test
    public void should_EndIndex_equalTo_3_when_letter_is_A() {
    	int result = ASCIIArtSolution.getEndIndexForLetter('A');
    	
    	assertThat( result ).isEqualTo( 3 );
    }
    

    @Test
    public void should_BeginIndex_equalTo_0_when_letter_is_D() {
    	int result = ASCIIArtSolution.getBeginIndexForLetter('D');
    	
    	assertThat( result ).isEqualTo( 12 );
    }
    
    @Test
    public void should_EndIndex_equalTo_3_when_letter_is_D() {
    	int result = ASCIIArtSolution.getEndIndexForLetter('D');
    	
    	assertThat( result ).isEqualTo( 15 );
    }
    
    @Test
    public void should_return_SpaceSharpSpaceSpace_when_A_and_Row0()
    {    	
    	String result = ASCIIArtSolution.getSubstringForARowAndLetter(0,'A');
    	
        assertThat( result ).isEqualTo(" #  ");
    }
      
    @Test
    public void should_return_SharpSharpSpaceSpace_when_D_and_Row0()
    {    	
    	String result = ASCIIArtSolution.getSubstringForARowAndLetter(0,'D');
    	
        assertThat( result ).isEqualTo("##  ");
    }
    
    @Test
    public void should_return_SharpSharpSharpSpace_when_QuestionMark_and_Row0()
    {    	
    	String result = ASCIIArtSolution.getSubstringForARowAndLetter(0,'?');
    	
        assertThat( result ).isEqualTo("### ");
    }

    @Test
    public void should_return_SharpSharpSpaceSpace_when_P_and_Row2()
    {    	
    	String result = ASCIIArtSolution.getSubstringForARowAndLetter(2,'P');
    	
        assertThat( result ).isEqualTo("##  ");
    }

}
