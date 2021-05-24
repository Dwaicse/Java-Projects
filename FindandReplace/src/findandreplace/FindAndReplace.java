package findandreplace;

import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String sent = sc.nextLine();
		System.out.println("Enter the word to be searched:");
		String searched = sc.next();
		System.out.println("Enter the word to be replaced:");
        String replace = sc.next();
        
        String replaceString = sent.replace(searched, replace);
        System.out.println(replaceString);
        sc.close();
	}

}
