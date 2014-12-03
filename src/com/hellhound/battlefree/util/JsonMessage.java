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

package src.com.hellhound.battlefree.util;

import com.google.gson.annotations.SerializedName;

public class JsonMessage{

	private int type;
	private String message;
	private Player player;

	public JsonMessage()
	{ 
		player = new Player();
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

	protected class Player
	{
		private String username;
		private String password;
		private String email;
		private int score;
		@SerializedName("played_games")
		private int playedGames;

		public Player(){}
		
		// Username
		public void setUsername(String username){ this.username = username; }
		public String getUsername(){ return this.username; }
		
		// Password
		public void setPassword(String password){ this.password = password; }
		public String getPassword(){ return this.password; }

		// Email
		public void setEmail(String email){ this.email = email; }
		public String getEmail(){ return this.email; }

		// Score
		public void setScore(int score){ this.score = score; }
		public int getScore() {	return this.score; }

		// Played Games
		public void setPlayedGames(int playedGames){ this.playedGames = playedGames; }
		public int getPlayedGames(){ return this.playedGames; }
	}

	protected class Game
	{
		//TODO: What should this class contain?
	}
}
