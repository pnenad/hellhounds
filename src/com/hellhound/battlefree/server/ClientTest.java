import java.io.*; 
import java.net.*; 

/**Test class for Client Side*/
/**WORKING*/
class ClientTest { 
       	public static void main(String argv[]) throws Exception  {
	     	String messageOut;   
		String messageIn;   
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));   
		Socket socket = new Socket("localhost", 6789);   
		DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());   
		BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
		messageOut = input.readLine();   
		outbound.writeBytes(messageOut + '\n');   
		messageIn = incoming.readLine();   
		System.out.println("FROM SERVER: " + messageIn);   
		socket.close();  
	}
}

