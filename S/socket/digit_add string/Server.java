

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
public static void main(String[] args) {
	ServerSocket ss=null;
	try{
		ss=new ServerSocket(787);
		System.out.println("server started");
		
			Socket s=ss.accept();
			System.out.println("Client "+s+" connected ");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			Thread t=new ClientHandler(s,dis,dos);
			t.start();
			
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		try{
			ss.close();
		}catch (Exception e1) {
			e1.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
}
