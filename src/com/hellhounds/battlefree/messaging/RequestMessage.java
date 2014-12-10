package com.hellhounds.battlefree.messaging;

/**
 * Message sent from client to server to request the
 * initialization of a new game.
 */

public class RequestMessage extends Message{

    private String username;
    private String opponent;
    private boolean challenge = false;
    private JsonUnit[] units;

    public RequestMessage(String username, JsonUnit[] units)
    {
        super(MessageType.REQUEST);
        this.username = username;
        this.units = units;
    }

    public RequestMessage(String username, String opponent, JsonUnit[] units)
    {
        super(MessageType.REQUEST);
        this.username = username;
        this.opponent = opponent;
        this.units = units;
        this.challenge = true;
    }


    public boolean isChallenge() { return challenge; }
    public void setChallenge(boolean challenge) { this.challenge = challenge; }

    public String getOpponent() { return opponent; }
    public void setOpponent(String opponent) { this.opponent = opponent; }

    public JsonUnit[] getUnits() { return units; }
    public void setUnits(JsonUnit[] units){ this.units = units; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }
}
