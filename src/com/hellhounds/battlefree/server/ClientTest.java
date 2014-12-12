package com.hellhounds.battlefree.server;		
 import java.io.*;	  
 import java.net.*;
 		 
 /**Test class for Client Side*/		
 /**WORKING*/
 class ClientTest {
	 String username;
	 String password;
	 String email;
		
//Constructor		
public ClientTest(){		

}		
		
//main method		
       	public static void main(String argv[]) throws Exception {
			//create an instance of client
			ClientTest test = new ClientTest();
			//check arguments
			//if there are no arguments, show this message and take arguments from shell
			if (argv.length == 0) {
				//System.out.println("Please write in your name, password and email address, divided by coma (,)");

				//To run a thread on the server, type in an thread id and command start - 1;start
				//To pause a running thread type in thread id and command pause - 1;pause
				//Tp resume a running thread type in thread id and command resume - 1;resume
				System.out.println("Please enter your command in following format: threadid;command");
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
			//uncomment next line to run on Linux lab pc
			Socket socket = new Socket("158.36.166.82", 8888);
			//uncomment next line to run on localhost
			//Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
			DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());
			BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outbound.writeBytes(test.username + '\n');
			System.out.println("Message with command '" + test.username + "' is sent.");
			System.out.println("*****Message sent, waiting for reply*****");
			messageIn = incoming.readLine();
			System.out.println("*****Message received, printing out*****");
			System.out.println("Server reply: " + messageIn);
			socket.close();
		}


}
