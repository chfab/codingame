import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        Solution solution = new Solution();
        MimeTypeAnalyzer mimeTypeAnalyser = solution.new MimeTypeAnalyzer();
        readMimeType(in, mimeTypeAnalyser, N);
        in.nextLine();
        ArrayList<String> fileNameToAnalyze = new ArrayList<String>();
        readFileName(in, fileNameToAnalyze, Q);
        ArrayList<String> result = mimeTypeAnalyser.analyze(fileNameToAnalyze);

        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        result.stream().forEach(r -> System.out.println( r ));
    }
    
    public static void readMimeType(Scanner in, MimeTypeAnalyzer mimeTypeAnalyser, int n) {
    	for (int i = 0; i < n; i++) {
    		String EXT = in.next(); // file extension
    		String MT = in.next(); // MIME type.
    		mimeTypeAnalyser.addMimeType(EXT, MT);
    	}
    }
    
    public static void readFileName(Scanner in, ArrayList<String> fileNameToAnalyze, int q) {
        for (int i = 0; i < q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            fileNameToAnalyze.add(FNAME);
        }
    }
    
    class MimeTypeAnalyzer {
    	protected HashMap<String,String> mimeTypeMap;
    	
    	public MimeTypeAnalyzer() {
    		mimeTypeMap = new HashMap<String,String>();
    	}
    	
    	public void addMimeType(String ext, String mimeType) {
    		mimeTypeMap.put(ext.toUpperCase(), mimeType);
    	}
    	
    	public String getExtensionFromFilename(String filename) {
    		int indexOfExtension = filename.lastIndexOf('.');
    		String extension = indexOfExtension==-1?"":filename.substring( indexOfExtension+1 );    		
    		return extension;
    	}
    	
    	public ArrayList<String> analyze( ArrayList<String> filenames ) {
    		ArrayList<String> analysisResult = new ArrayList<String>();
    		for (String filename : filenames ) {
    			analysisResult.add( analyze( filename ));
    		}
    		return analysisResult;
    	}
    	
    	public String analyze( String filename ) {
    		String mimeType = "UNKNOWN";
    		String extension = getExtensionFromFilename(filename);
    		if (!extension.isEmpty() && mimeTypeMap.containsKey( extension.toUpperCase() )) {
    			mimeType = mimeTypeMap.get( extension.toUpperCase() );
    		}
    		return mimeType;
    	}
    }
}