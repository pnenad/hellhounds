package com.hellhounds.battlefree.server;
//Added basic functionallity for network communication. Simple message exchange between client and server.
import com.hellhounds.battlefree.game.Game;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import com.hellhounds.battlefree.game.Player;

public class Server{

private HashMap<Long, Thread> threads;

	public Server(){
		threads = new HashMap<>();
		Server server = new Server();
	}
	
	public static void main(String argv[]) throws Exception{
		System.out.println("Starting server...");
		String message;
		ServerSocket socket = new ServerSocket(8888);          
		while(true){
			System.out.println("...server running...");
			Socket conn = socket.accept();
			BufferedReader incoming = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			DataOutputStream outbound = new DataOutputStream(conn.getOutputStream());
			message = incoming.readLine();
			System.out.println("Received: " + message);
			if(message.equals("Nenad")){
				System.out.println("Thread will spawn here!");
			}

			System.out.println("Sending reply: " + message);
			outbound.writeBytes("Reply for message " + message + '\n');
			conn.close();
		}

	}

	/**
	* Method used to spawn a new thread in order to create a new game object. Threads are stored in a HashMap
	* so that we can manage threads and connections
	* @param p1 Player object for player 1
	* @param p2 Player object for player 2
	* @param id Id for game object that is used as key for HashMap
	* */
	private void createClientThread(Player p1, Player p2, Long id){
		Thread t = new Thread(new Game(p1, p2, id));
		threads.put(id, t);
		System.out.println("Thread started: " + threads.get(id).getState());
		t.run();
	}

	private void readMessages(){
	
	}

}
