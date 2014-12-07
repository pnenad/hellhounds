package com.hellhounds.battlefree.server;
//Added basic functionallity for network communication. Simple message exchange between client and server.
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server{

//private ArrayList<Thread> threads;

	public Server(){
		//threads = new ArrayList<>();
		Server server = new Server();
	}
	
	public static void main(String argv[]) throws Exception{
		String message;          
		ServerSocket socket = new ServerSocket(8888);          
		while(true){             
			Socket conn = socket.accept();             
			BufferedReader incoming = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			DataOutputStream outbound = new DataOutputStream(conn.getOutputStream());             
			message = incoming.readLine();     
			System.out.println("Received: " + message);      
			outbound.writeBytes("Reply for message " + message + '\n');          
			conn.close();
		}

	}
	/**	
	private void createClientThread(Socket s, String id){
		threads.add(new Thread(new Client(s), id));
	}

	private void readMessages(){
	
	}
	*/
}
