package com.hellhound.battlefree.util;

public class Player {
        private String username;
	private String password;
	private String email;
	private int score;
	//@SerializedName("played_games")
	private int playedGames;

	public Player(){
	}	
	public Player(String username){
		this.username  = username;
	}
	public Player(String username, String pasword, String email){
		this.username = username;
		this.password = password;
		this.email = email;
	}
							                 
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
	public int getScore() { return this.score; }
	// Played Games
	public void setPlayedGames(int playedGames){ this.playedGames = playedGames; }
	public int getPlayedGames(){ return this.playedGames;}
 }	
