package v1_tests;

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper; 

public class PDFTest {
    public static void main( String[] args ) throws IOException
    {
    	boolean approvedDoc = false;
    	
    	PDDocument document = PDDocument.load(new File("notes2.pdf"));
	    PDFTextStripper stripper = new PDFTextStripper();
	    
	    String text = stripper.getText(document);
	    String[] textLines = text.split("\n");
	    
	    ArrayList<Integer> notes = new ArrayList<>();
	    Pattern p = Pattern.compile("([0-9])");
	    int i = 0;
	    for(String line : textLines) {
	    	Matcher m = p.matcher(line);
	    	if(i > 8) {
		    	if(m.find() && !line.contains("UE") && !line.contains("Moyenne")) {
		    		line = line.substring(line.length()-6,line.length()-4);
		    		notes.add(Integer.parseInt(line));
		    	}
	    	}
	    	i++;
	    }
    	document.close();
    	System.out.println(notes);
    }
}