import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Solution solution ;
    Solution.MimeTypeAnalyzer mimeTypeAnalyser;

    public AppTest()
    {
        solution = new Solution();
        mimeTypeAnalyser = solution.new MimeTypeAnalyzer();
    }

    @Test
    public void should_return_html_when_extension_is_html() {
    	String result = mimeTypeAnalyser.getExtensionFromFilename("test.html");
    	
    	assertThat(result).isEqualTo("html");
    }

    @Test
    public void should_return_textSlashhtml_when_analyze_testDothtml() {
    	mimeTypeAnalyser.addMimeType("html", "text/html");
    	String result = mimeTypeAnalyser.analyze("test.html");
    	
    	assertThat(result).isEqualTo("text/html");
    }

    @Test
    public void should_return_UNKNOWN_when_analyze_testDothtml() {
    	mimeTypeAnalyser.addMimeType("html", "text/html");
    	String result = mimeTypeAnalyser.analyze("test.png");
    	
    	assertThat(result).isEqualTo("UNKNOWN");
    }

    @Test
    public void should_return_UNKNOWN_when_analyze_a() {
    	mimeTypeAnalyser.addMimeType("html", "text/html");
    	String result = mimeTypeAnalyser.analyze("a");
    	
    	assertThat(result).isEqualTo("UNKNOWN");
    }
    

    @Test
    public void should_return_UNKNOWN_when_analyze_file_with_no_extension() {
    	mimeTypeAnalyser.addMimeType("pdf", "application/pdf");
    	String result = mimeTypeAnalyser.analyze("pdf");
    	
    	assertThat(result).isEqualTo("UNKNOWN");
    }
}
