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
 import java.io.*;	  
 import java.net.*;
 		 
 /**Test class for Client Side*/		
 /**WORKING*/
 class Client {
	 String username;
	 String password;
	 String email;
		
//Constructor		
public Client(){

}		
		
//main method		
       	public static void main(String argv[]) throws Exception {
			//create an instance of client
			Client test = new Client();
			//check arguments
			//if there are no arguments, show this message and take arguments from shell
			if (argv.length == 0) {
				System.out.println("Please write in your name, password and email address, divided by coma (,)");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String args = in.readLine();
				String[] strarray = args.split("\\,", -1);
				//if there is one argument use the method for casual player
				if (strarray.length == 1) {
					test.username = strarray[0];
				}
				//else use the method for registration
				else {
					test.username = strarray[0];
					test.password = strarray[1];
					test.email = strarray[2];
				}
			} else {
				//check args
				//if there is one arg call casual player method
				if (argv.length == 1) {
					test.username = argv[0];;
				}
				//else use the method for registration
				else {
					test.username = argv[0];
					test.password = argv[1];
					test.email = argv[2];
				}
			}
			String messageIn;
			//Server running on Static IP (datalab)
			Socket socket = new Socket("158.36.166.82", 8888);
			DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());
			BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outbound.writeBytes(test.username + '\n');
			System.out.println("*****Message sent, waiting for reply*****");
			messageIn = incoming.readLine();
			System.out.println("*****Message received, printing out*****");
			System.out.println("Server reply: " + messageIn);
			socket.close();
		}
}
