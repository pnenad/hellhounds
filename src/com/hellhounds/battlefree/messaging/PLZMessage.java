package com.hellhounds.battlefree.messaging;

/**
 * Message sent from client to server to request the
 * initialization of a new game.
 */

public class PLZMessage extends Message{

    private String[] units;
    private String username;
    private String opponent;
    private boolean challenge = false;

    public PLZMessage(String username, String[] units)
    {
        super(MessageType.PLZ);
        this.username = username;
        this.units = units;
    }

    public PLZMessage(String username, String opponent, String[] units)
    {
        super(MessageType.PLZ);
        this.username = username;
        this.opponent = opponent;
        this.units = units;
        this.challenge = true;
    }


    public boolean isChallenge() { return challenge; }
    public void setChallenge(boolean challenge) { this.challenge = challenge; }

    public String getOpponent() { return opponent; }
    public void setOpponent(String opponent) { this.opponent = opponent; }

    public String[] getUnits() { return units; }
    public void setUnits(String[] units){ this.units = units; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }
}
