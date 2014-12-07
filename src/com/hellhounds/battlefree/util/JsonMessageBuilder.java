/*
 * Copyright 2014 Hellhounds
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
package com.hellhounds.battlefree.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * TODO: Describe this class
 */
public class JsonMessageBuilder{
	
	private JsonMessage msg;
	private GsonBuilder builder;
	private Gson gson;

	public JsonMessageBuilder()
	{
		msg = new JsonMessage();
		//PrettyPrinting only to check if JSON-string is correct
		builder = new GsonBuilder();//.setPrettyPrinting();
		gson = builder.create();
	}

	/**
	 * Returns a JSON-String that will represent a connect
	 * or disconnect message to the server.
	 *
	 * @param type If true the player wants to connect to the server,
	 * if false the player wants to disconnect from the server.
	 * @param username The player that wants to (dis)connect
	 * @return Complete connect or disconnect json string.
	 */
	public String connect(boolean type, String username)
	{
		msg = new JsonMessage();
		if(type)
			msg.setType(1);
		else
			msg.setType(0);

		msg.getPerson().setUsername(username);
		
		return gson.toJson(msg);
	}
	
	/**
	 * 
	 */
	public String register(String username, String password, String email)
	{
		msg = new JsonMessage();
		msg.setType(2);
		msg.getPerson().setUsername(username);
		
		if(password != null)
			msg.getPerson().setPassword(password);
		if(email != null)
			msg.getPerson().setEmail(email);

		return gson.toJson(msg);
	}
	
	public String getMessage(JsonMessage jsm){
		return gson.toJson(jsm);
	}
	
}
