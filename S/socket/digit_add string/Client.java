
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
		InetAddress host;
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		
		String toSend;
		Scanner sc=new Scanner(System.in);
		
		
		try{
			host=InetAddress.getByName("localhost");
			s=new Socket(host,787);
			dis=new DataInputStream(s.getInputStream());
			dos= new DataOutputStream(s.getOutputStream());
			while(true){
				System.out.println(dis.readUTF());
				toSend=sc.nextLine();//request type
				dos.writeUTF(toSend);//send request
				if(toSend.equals("exit")){
					System.out.println("terminated");
					return;
				}
				System.out.println(dis.readUTF());//display the string 
				toSend=sc.nextLine();//enter values
				dos.writeUTF(toSend);//send values
				System.out.println(dis.readUTF());//print result
				
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sc.close();
		}
		
	}
}
