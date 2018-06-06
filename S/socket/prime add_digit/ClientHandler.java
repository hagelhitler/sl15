


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	
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
			toSend="enter you choice.. \n 1.Addition of digits  \n 2.Find given number is prime or no " +
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
				this.checkprime();
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
//		String[] arr=recieved.split(" ");
//		
//		for(int i=0;i<arr.length; i++)
//			sum=sum+Integer.parseInt(arr[i]);
//		dos.writeUTF(String.valueOf(sum));
//		
		/*
		 *  static int getSum(int n)
    {    
        int sum = 0;
         
        while (n != 0)
        {
            sum = sum + n % 10;
            n = n/10;
        }
     
    return sum;
    }*/
		
		
	}

	private void checkprime() throws IOException{
		// TODO Auto-generated method stub
		String recieved;
		int num;
		dos.writeUTF("enter number ");
		recieved =dis.readUTF();
		num=Integer.parseInt(recieved);
		String result=null;
		if(num<=1)
		{
			result="number is not prime";
			dos.writeUTF(result);
			return;
		}
		
			
		for(int i=2;i<num;i++){
			
			if(num%i==0)
			{result="number is not prime";
			dos.writeUTF(result);
			return;
		}
				
			
			
		}
		result="number is prime";
		dos.writeUTF(result);
		
		/*
		 *  if (n <= 1)
            return false;
      
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
      
        return true;*/
//		dos.writeUTF("enter a and b ");
//		recieved =dis.readUTF();
//		
//		String[] arr=recieved.split(" ");
//		
//		
//		int a=Integer.parseInt(arr[0]);
//		int b=Integer.parseInt(arr[1]);
//		
//			
//		dos.writeUTF(String.valueOf(a-b));
		
	}
	
	

}
