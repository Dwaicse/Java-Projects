package playerdetails;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Player[] pObj = new Player[4];
		pObj[0] = new Player(146,"Athul",16,9876543210l);
		pObj[1] = new Player(135,"Rakshana",16,9956231045l);
		pObj[2] = new Player(168,"Christy",16,9856471230l);
		pObj[3] = new Player(194,"Athulya",16,9768541230l);
		
		
		Scanner sc = new Scanner(System.in);
        PlayerUtility puObj = new PlayerUtility();		
		
		System.out.println("Enter the id to be searched");
		int id = sc.nextInt();
		
		Player result = puObj.findPlayerDetailsById(pObj, id);
		if(result == null)
		{
			System.out.println("No player found");
		}
		else
		{
		System.out.println("Name:" + result.getPlayerName());
		System.out.println("Phone number:"+result.getPhoneNumber());
		}
		
		sc.close();
		
		
		
		
		

	}

}
