/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.server;
//Added basic functionallity for network communication. Simple message exchange between client and server.

import java.io.*;
import java.net.*;
import java.util.HashMap;

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
			//if command is start create a new thread and assign it id 1
			if(command.equals("start")){
				System.out.println("Thread will spawn here!");
				server.createThread(id);
				System.out.println("This thread is: " + server.getThreads().get(id).getState());
			}
			//if command is pause find and pause the thread
			else if(command.equals("pause")){
				if(id <= server.getThreads().size() && id > 0){
					server.getThreads().get(id).pauseThread();
					System.out.println("This thread is: " + server.getThreads().get(id).getState());
				}else{
					System.out.println("No such thread.");
				}
			}
			//iif command is stop find the thread and terminate it
			else if(command.equals("stop")){
                                if(id <= server.getThreads().size() && id > 0){
                                        if(server.getThreads().get(id).isAlive()){
						server.getThreads().get(id).stop();						
						System.out.println("This thread is: " + server.getThreads().get(id).getState());
					} else {
						System.out.println("This thread cannot be stopped");
					}						
                                }else{
                                        System.out.println("No such thread.");
                                }
                        }
			//if command is resume find and resume the thread
			else if(command.equals("resume")){
				if(id <= server.getThreads().size() && id > 0){
					if(server.getThreads().get(id).isAlive()){
						server.getThreads().get(id).resumeThread();
						System.out.println("Thread status: " + server.getThreads().get(id).getState());
					}else{
						System.out.println("This thread cannot be resumed.");
					}
				}else{
					System.out.println("No such thread.");
				}
			}
			//if command is quit and id is 0 then stop server
			else if(id==0 && command.equals("quit")){
				server.stopServer();
			}
			else {
				System.out.println("Unknown command");
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
	
	/**
	* Method for spawning and tracking threads running on server
	* @param s Used for thread name
	* @param i Used for thread id
	* */
	private void createThread(int i) throws InterruptedException{
		GameDummy t = new GameDummy(i);
		threads.put(i, t);
		System.out.println(threads.get(i).getId());
		System.out.println("Thread nr." + i + " status: " + threads.get(i).getState());
		t.start();
	}
	
	/**Method that returns a map with all the running threads on server
	* @return HashMap with all the running threads */
	private HashMap<Integer, GameDummy> getThreads(){
		return this.threads;
	}
	
	/**Method that stops the server*/
	private void stopServer(){
		System.out.println("Stoping server");
		System.exit(0);
	}

}
