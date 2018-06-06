
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
        String recieved;
	String toSend;

	
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
		super();
		this.s = s;
		this.dis = dis;
		this.dos = dos;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String recieved, toSend;
		try{
			System.out.println("Assigning thread to client : " + s);
			
			while(true){
			toSend="enter you choice.. \n 1.Addition of digits  \n 2.String operations " +
					"\n type exit to terminate";
			dos.writeUTF(toSend);
			recieved =dis.readUTF();
			if(recieved.equals("exit"))
			{
				System.out.println("client requested termination");
				s.close();
				break;	
			}
			
			int ch;
			if(recieved.equals("1"))// i did this bcoz string was not supported in my old java version
				ch=1;
			else
				ch=2;
			switch(ch)
			{
			case 1 :
				this.addDigits();
				break;
			case 2 :
				this.stringOperations();
				break;
			default:
				break;
			}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void addDigits() throws IOException{
		// TODO Auto-generated method stub
		String recieved;
		int sum=0;
		dos.writeUTF("enter number ");
		recieved =dis.readUTF();
		
		int num=Integer.parseInt(recieved);
		
		while(num!=0){
			sum=sum+num%10;
			num=num/10;
		}
		dos.writeUTF(String.valueOf(sum));
		
		
	}

	private void stringOperations() {
		try {
			toSend = "\nEnter strings A & B seperated by space : ";
			dos.writeUTF(toSend);
			recieved = dis.readUTF();
			
			String[] arr = recieved.split(" ");
			String a = arr[0];
			String b = arr[1];
			
			toSend = "";
			
			if(a.equals(b)) {
				toSend = toSend + "\n1. Strings A & B are equal";
			}
			else {
			
                            toSend = toSend + "\n1. Strings A & B are not equal";
			}
			
			toSend = toSend + "\n2. Concatenation = " + a+b;
			
			if(!a.equals(b)) {
				if(a.contains(b)) {
					toSend = toSend + "\n3. B is substring of A";
				}
				else if(b.contains(a)) {
					toSend = toSend + "\n3. A is substring of B";
				}
			}
					
			dos.writeUTF(toSend);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
