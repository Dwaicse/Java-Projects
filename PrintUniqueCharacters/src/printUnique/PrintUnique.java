package printUnique;


import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class PrintUnique {
	
    
    
	public static void uniqueCharacters(String test){
	
	    Vector<String> vec = new Vector<String>();
	    
        for(int x=0;x<test.length();x++)
        {
        	vec.add(Character.toString(test.charAt(x)));
        	for(int y=0;y<test.length();y++)
        	{
        		if(x!=y && test.charAt(x)== test.charAt(y)) {
        			 vec.remove(Character.toString(test.charAt(x)));
        		}
        		
        	}
        }
        
        if(vec.isEmpty())
        {
        	System.out.println("No unique characters");
        }
        else {
        Iterator<String> it = vec.iterator();
        System.out.println("Unique characters:");
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        }
	
	
	}
	
	
	
	public static boolean validateString(String str)
	{
		String[] word = new String[50];
		word = str.split(" ");
		
		for(String w:word)
    	{
    		if(w.matches("^[a-zA-Z]*$")==false)
    		{
    			return false;
    			
    		}
    	}
		return true;
	}
      
    public static void main(String[] args)
    { 
    	Scanner sc = new Scanner(System.in);
          
    	System.out.println("Enter the sentence:");
    	String sentence = sc.nextLine();
    	sc.close();
    	if(validateString(sentence))
    	{
    		uniqueCharacters(sentence);
    	}
    	
    	else
    	{
    		System.out.println("Invalid Sentence");
    	}
    	
    	
    	
    	
    }

}

