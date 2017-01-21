import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
	
	private String[] alphabet;
	private int      letterLength;
	private int      letterHeight;
	
    public static void main(String args[]) {
        Solution s = new Solution();

        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        
        s.setLetterLength( L );
        s.setLetterHeight( H );
        
        in.nextLine();
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            s.setAlphabetForRow(i, ROW);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        s.displayASCIIArt( T.toUpperCase() );
    }
    
    public void setAlphabetForRow(int row, String alphabetRow) {
    	if (alphabet == null) {
    		alphabet = new String[ getLetterHeight() ];
    	}
    	alphabet[row] = alphabetRow;
    }
    
    private boolean isRegularChar( char c ) {
    	return  (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
    
    public int getBeginIndexForLetter( char letter ) {
    	if ( isRegularChar( letter) ) {
      		int asciicode = (int) letter ;
    		return (asciicode-65) * (getLetterLength());
    	} else {
    		return alphabet[0].length() - getLetterLength();
    	}
    }

    public int getEndIndexForLetter( char letter ) {
    	if ( isRegularChar( letter) ) {
    		int asciicode = (int) letter;
    		return (asciicode-65) * getLetterLength() 
    				+ getLetterLength() 
    				- 1;
    	}  else {
    		return alphabet[0].length() - 1;
    	}
    }
    	
    
    public String getSubstringForARowAndLetter(int row, char letter) {
    	int beginIndex = getBeginIndexForLetter( letter );
    	int endIndex   = getEndIndexForLetter(   letter );
    	
    	return alphabet[row].substring(beginIndex,endIndex+1);
    }
    
	public int getLetterLength() {
		return letterLength;
	}

	public void setLetterLength(int letterLength) {
		this.letterLength = letterLength;
	}

	public int getLetterHeight() {
		return letterHeight;
	}

	public void setLetterHeight(int letterHeight) {
		this.letterHeight = letterHeight;
	}
	
	public void displayASCIIArt( String text ) {
		int H = getLetterHeight();
		for (int h=0; h<H; ++h) {
			String s = "";
			for (char c : text.toCharArray() ) {
				s += getSubstringForARowAndLetter( h, c);
			}
			System.out.println( s );
		}
	}
}