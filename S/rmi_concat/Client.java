import java.rmi.*;
import java.util.Scanner;
public class Client 
{
public static void main(String args[])
    	{
		try
        		{
            			Scanner s = new Scanner(System.in);
            			System.out.println("Enter the server address :");
            			String server = s.nextLine();
            		        	ServerInterface si = (ServerInterface)Naming.lookup("rmi://"+server+"/Server");
            			System.out.println("Enter First String :");
            			String first = s.nextLine();
           	 		System.out.println("Enter Second String :");
            			String second = s.nextLine();
            			System.out.println("Concatenated string :"+si.concat(first, second));
       		 }
        		catch(Exception e)
        		{
			System.out.println(e);
        		}
	}
}












