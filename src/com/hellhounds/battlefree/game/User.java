package com.hellhounds.battlefree.game;

import java.util.HashMap;

/**
 * This class is not used at the moment, will be needed
 * to let a user have multiple active games at the same time.
 */
public class User{
    
    private String username;
    private final HashMap<Integer, Game> activeGames;

    public User(String username)
    {
        this.username = username;
        this.activeGames = new HashMap<Integer, Game>();
    }
 
    public HashMap<Integer, Game> getActiveGames(){ return this.activeGames; }

    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }
}
