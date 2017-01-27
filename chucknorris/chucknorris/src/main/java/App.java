import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        Solution s = new Solution();
        
        ChuckNorrisEncoder chuckNorrisEncoder = s.new ChuckNorrisEncoder();
        String answer = chuckNorrisEncoder.encode(MESSAGE);

        System.out.println( answer );
    }
    
    class ChuckNorrisEncoder {
    	public ChuckNorrisEncoder() {
    	}

    	public String encode(String input) {
    		String binaryString = convertToBinaryString( input );
    		String unaryString  = encodeBinaryString ( binaryString ) ;
    		return unaryString;
    	}
    	
    	protected String encodeBinaryString(String binaryString) {
    		StringBuffer result = new StringBuffer();
    		int i=0;
    		int len = binaryString.length(); 
    		do {
    			int n = getRepeatChar( binaryString, i );
    			Bloc b = new Bloc( binaryString.charAt(i), n );
    			result.append( b.toString() ).append( " " );
    			i+=n;
    		} while (i < len);
    		
    		return result.toString().trim();
    	}
    	
    	protected String convertToBinaryString(String string) {
    		String res = "";
    		char[] arrayString = string.toCharArray();
    		for(char c : arrayString) {
    			res += convertToBinaryString( c );
    		}
    		return res;
    	}	

    	protected String convertToBinaryString( char c ) {
    		char res[] = new char[7];
    		byte mask = 0x01;
    		int value = (int)c;
    		for (int i=0; i<7; i++ ) {
    			mask = (byte) (1 << i);
    			res[6-i] = (value & mask) == mask?'1':'0';
    		}
    		return new String(res);
    	}
    	
    	protected String getBloc(char zeroOrOne, int n) {
    		Bloc b = new Bloc(zeroOrOne,n);
    		return b.toString();
    	}

    	protected int getRepeatChar(String input, int from) {
    		char charToRepeat = input.charAt(from);
    		int end = from + 1;
    		while (end<input.length() && input.charAt(end) == charToRepeat) {
    			end++;
    		}
    		return end-from;
    	}
    }
    	
	class Bloc {
		public static final char BLOC_TYPE_0 = '0';
		public static final char BLOC_TYPE_1 = '1';
		
		protected int  n;
		private   char type;
		public Bloc(char type, int n) {
			this.n = n;
			this.type = type;
		}
		
		public final String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append('0');
			if (this.type == BLOC_TYPE_0){
				buf.append('0');				
			}
			buf.append(' ');
			for (int i=0; i<n; i++) {
				buf.append('0');
			}
			return buf.toString();
		}
	}
}