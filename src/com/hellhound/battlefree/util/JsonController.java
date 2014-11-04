import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonController{

	public static void main(String[] args){
		
		JsonMessage message = new JsonMessage();
		
		message.setType(1);
		message.setMessage("TESTING");
		message.getPlayer().setUsername("iEzpeN");
		message.getPlayer().setScore(5255);

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String json = gson.toJson(message);
		System.out.println(json);

		JsonMessage reply = gson.fromJson(new StringReader(json), JsonMessage.class);
		System.out.println(reply.getPlayer().getUsername());
	}

}
