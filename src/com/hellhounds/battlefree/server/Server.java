package com.hellhounds.battlefree.server;
//Added basic functionallity for network communication. Simple message exchange between client and server.

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server{

private HashMap<Long, GameDummy> threads;

	public Server(){
		threads = new HashMap<>();
		//Server server = new Server();
	}
	
	public static void main(String argv[]) throws Exception{
		System.out.println("Starting server...");
		String message;
		ServerSocket socket = new ServerSocket(8888);
		Server server = new Server();
		while(true){
			System.out.println("...server running...");
			Socket conn = socket.accept();
			BufferedReader incoming = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			DataOutputStream outbound = new DataOutputStream(conn.getOutputStream());
			message = incoming.readLine();
			System.out.println("Received: " + message);
			if(message.equals("start")){
				System.out.println("Thread will spawn here!");
				try {
					server.createThread("Nenad");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(message.equals("pause")){
				server.getThreads().get(1).pauseThread();
			}
			else if(message.equals("resume")){
				server.getThreads().get(1).resumeThread();
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
	/**
	private void createClientThread(Player p1, Player p2, Long id){
		Thread t = new Game(p1, p2, id));
		threads.put(id, t);
		System.out.println("Thread started: " + threads.get(id).getState());
		t.run();
	}
	*/

	private void createThread(String s) throws InterruptedException{
		long l = 1;
		GameDummy t = new GameDummy(l);
		threads.put(l, t);
		System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		threads.get(l).start();
		System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		threads.get(l).run();
		System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		//threads.get(l).pauseThread();
		//System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		//threads.get(l).resumeThread();
		//System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		}

	private void readMessages(){
	
	}

	private HashMap<Long, GameDummy> getThreads(){
		return this.threads;
	}

}
