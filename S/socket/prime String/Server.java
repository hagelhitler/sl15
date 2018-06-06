package com.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			ss = new ServerSocket(786);
			System.out.println("Server Started!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true) {
			try {
				s = ss.accept();
				System.out.println("Client " + s + " connected");
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				
				Thread  t = new ClientHandler(s, dis, dos);
				System.out.println("Assigning thread to : " + s);
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					ss.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
