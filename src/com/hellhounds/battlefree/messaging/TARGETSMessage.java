package com.hellhounds.battlefree.messaging;

/**
 * Message to be sent from a client to the server. Contains
 * the sending players units' actions, with gameID and
 * username for identification.
 */

public class TARGETSMessage extends Message{

    private long gameID;
    private String fromUsername;
    private UnitAction[] actions;

    public TARGETSMessage(long gameID, String fromUsername, UnitAction[] actions)
    {
        super(MessageType.TARGETS);
        this.gameID = gameID;
        this.fromUsername = fromUsername;
        this.actions = actions;
    }

    public long getGameID() { return gameID; }
    public void setGameID(long gameID) { this.gameID = gameID; }

    public String getFromUsername() { return fromUsername; }
    public void setFromUsername(String fromUsername) { this.fromUsername = fromUsername; }

    public UnitAction[] getActions() { return actions; }
    public void setActions(UnitAction[] actions) { this.actions = actions; }
}
