package com.hellhounds.battlefree.server;
//Added basic functionallity for network communication. Simple message exchange between client and server.
import com.hellhounds.battlefree.game.Game;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import com.hellhounds.battlefree.game.Player;
import com.hellhounds.battlefree.game.GameDummy;

public class Server{

private HashMap<Integer, GameDummy> threads;

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
			String[] messageArray = message.split("\\;", -1);
			String threadId = messageArray[0];
			int id = new Integer(threadId.valueOf(threadId)); //parse string to integer
			String command = messageArray[1];
			System.out.println("Received thread id: " + id);
			System.out.println("Received command  : " + command);
			if(command.equals("start")){
				System.out.println("Thread will spawn here!");
				server.createThread("Game Thread");
			}
			else if(command.equals("pause")){
				if(id <= server.getThreads().size() && id > 0){
					server.getThreads().get(id).pauseThread(); //1;pause
				}else{
					System.out.println("No such thread.");
				}
			}
			else if(command.equals("resume")){
				if(id <= server.getThreads().size() && id > 0){
					if(server.getThreads().get(id).isAlive()){
						System.out.println("This thread can be resumed. Status: " + server.getThreads().get(id).getState());
					}
					else{
						System.out.println("This thread cannot be resumed.");
					}
				}else{
					System.out.println("No such thread.");
				}
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
		int l = 1;
		GameDummy t = new GameDummy(l);
		threads.put(l, t);
		System.out.println(threads.get(l).getId());
		System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		t.start();
		//System.out.println("Thread nr." + l + " status: " + threads.get(l).getState());
		}

	private void readMessages(){
	
	}

	private HashMap<Integer, GameDummy> getThreads(){
		return this.threads;
	}

}
