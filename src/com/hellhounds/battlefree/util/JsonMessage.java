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

import com.google.gson.annotations.SerializedName;

public class JsonMessage{

	private int type;
	private String message;
	private Player player;
	private Game game;


	public JsonMessage()
	{ 
		player = new Player();
		game = new Game();

	}

	// Type
	public void setType(int command){ this.type = command; }
	public int getType(){ return this.type;	}

	// Message
	public void setMessage(String message){	this.message = message;	}
	public String getMessage(){ return this.message; }

	// Player
	public void setPlayer(Player player){ this.player = player; }
	public Player getPlayer(){ return this.player; }
}
