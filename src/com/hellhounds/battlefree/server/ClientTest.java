package com.hellhounds.battlefree.server;
import java.io.*; 
import java.net.*; 
import com.hellhounds.battlefree.util.*;

/**Test class for Client Side*/
/**WORKING*/
class ClientTest { 
private JsonMessage message;

//Constructor
public ClientTest(){
	message = new JsonMessage();
}

//main method
       	public static void main(String argv[]) throws Exception  {
		//create an instance of client
		ClientTest test = new ClientTest();
		//check arguments
		//if there are no arguments, show this message and take arguments from shell
		if(argv.length == 0){
			System.out.println("Please write in your name, password and email address, divided by coma (,)");
			BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
			String args = in.readLine();
			String[] strarray = args.split("\\,", -1);
			//if there is one argument use the method for casual player
			if(strarray.length == 1){
				String username = strarray[0];
				test.createPlayer(username);
			}
			//else use the method for registration		
			else{
				String username = strarray[0];
				String password = strarray[1];
				String email = strarray[2];
				test.createPlayerPass(username, password, email);
			}
		}
		else{
			//check args
			//if there is one arg call casual player method
			if(argv.length == 1){
				String username = argv[0];
				test.createPlayer(username);
			}
			//else use the method for registration          
			else{
				String username = argv[0];
				String password = argv[1];
				String email = argv[2];
				test.createPlayerPass(username, password, email);			
			}
		}
		String messageIn;   
		Socket socket = new Socket("localhost", 8888);   
		DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());   
		BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
		JsonMessageBuilder jmb = new JsonMessageBuilder();
		//Construct a json string and send it to the server
		outbound.writeBytes(jmb.getMessage(test.getMessage())+'\n');
		System.out.println("*****Message sent, waiting for reply*****");
		messageIn = incoming.readLine();
		System.out.println("*****Message received, printing out*****");
		System.out.println("Server reply: " + messageIn);   
		socket.close();  
	}
	
	/**A method that returns a JsonMessage object that is used to construct a Json string*/
	private JsonMessage getMessage(){
		return this.message;
	}
	
	/**Create player if only one parameter is given*/
	private void createPlayer(String username){
		message.setPlayer(new Player(username));
		System.out.println("Casual player data: "+username);
	}
	
	/**Create player method if multiple parameters are given
	@param String username Player's desired username
	@param String password Player's desired password
	@param String email Player's email address */
	private void createPlayerPass(String username, String password, String email){
		System.out.println("Competitive player data: "+username+" "+password+" "+email);
		message.setPlayer(new Player(username, password, email));
	}

}

