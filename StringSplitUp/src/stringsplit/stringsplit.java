package stringsplit;

import java.util.Scanner;

public class stringsplit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		sc.close();
		String[] words = st.split("[:,]");
		for(String w:words)
		{
			System.out.println(w);
		}

	}

}
