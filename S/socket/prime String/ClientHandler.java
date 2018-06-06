package com.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {

	final Socket s;
	final DataInputStream dis;
	final DataOutputStream dos;
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
		
		while (true) {
			try {
				toSend = "\n\n----- Menu -----\n1. Check prime number\n2. String Operations\nType Exit to terminate";
				dos.writeUTF(toSend);
				recieved = dis.readUTF();
				
				if (recieved.equals("Exit") || recieved.equals("exit")) {
					System.out.println("\nClient typed Exit");
					s.close();
					break;
				}
				
				switch (recieved) {
				case "1": 
					this.prime();
					break;
					
				case "2": 
					this.stringOperations();
					break;

				default:
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
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

	private void prime() {
		try {
			toSend = "\nEnter number to check prime or not : ";
			dos.writeUTF(toSend);
			recieved = dis.readUTF();
			int n = Integer.parseInt(recieved);
			int flag = 1;
			
			if(n==1) {
				dos.writeUTF("\nNumber " + n + " is composite number.");
				return;
			}
			
			for (int i = 2; i < n/2; i++) {
				flag = n%i;
				
				if(flag==0) {
					dos.writeUTF("\nNumber " + n + " is not prime.");
					return;
				}
			}
			
			dos.writeUTF("\nNumber " + n + " is prime.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
