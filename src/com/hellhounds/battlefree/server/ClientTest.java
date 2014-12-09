package com.hellhounds.battlefree.server;		
 import java.io.*;	  
 import java.net.*;
 		 
 /**Test class for Client Side*/		
 /**WORKING*/
 class ClientTest {
		
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
				System.out.println("Please write in your name, password and email address, divided by coma (,)");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String args = in.readLine();
				String[] strarray = args.split("\\,", -1);
				//if there is one argument use the method for casual player
				if (strarray.length == 1) {
					String username = strarray[0];
				}
				//else use the method for registration
				else {
					String username = strarray[0];
					String password = strarray[1];
					String email = strarray[2];
				}
			} else {
				//check args
				//if there is one arg call casual player method
				if (argv.length == 1) {
					String username = argv[0];;
				}
				//else use the method for registration
				else {
					String username = argv[0];
					String password = argv[1];
					String email = argv[2];
				}
			}
			String messageIn;
			Socket socket = new Socket("localhost", 8888);
			DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());
			BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outbound.writeBytes("MESSAGE" + '\n');
			System.out.println("*****Message sent, waiting for reply*****");
			messageIn = incoming.readLine();
			System.out.println("*****Message received, printing out*****");
			System.out.println("Server reply: " + messageIn);
			socket.close();
		}
}
