package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		InetAddress ip;
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		String toSend;
		Scanner sc;
		
		try {
			ip = InetAddress.getByName("localhost");
			s = new Socket(ip, 786);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			sc = new Scanner(System.in);
			while(true) {
				System.out.println(dis.readUTF());
				toSend = sc.nextLine();
				dos.writeUTF(toSend);
				
				if(toSend.equals("Exit") || toSend.equals("exit")) {
					System.out.println("Terminated");
					s.close();
					break;
				}
				
				System.out.println(dis.readUTF());
				dos.writeUTF(sc.nextLine());
				System.out.println(dis.readUTF());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
