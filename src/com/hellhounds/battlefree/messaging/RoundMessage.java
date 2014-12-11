package com.hellhounds.battlefree.messaging;

/**
 * Message sent from server to clients, notifying
 * about the end of a game or the start of a new round.
 */
public class RoundMessage extends Message{

    private long gameID;
    private int gameStatus;
    private JsonPlayer user, opponent;

    public RoundMessage(long gameID, int gameStatus, JsonPlayer user, JsonPlayer opponent)
    {
        super(MessageType.ROUND);
        this.gameID = gameID;
        this.gameStatus = gameStatus;
        this.user = user;
        this.opponent = opponent;
    }

    public long getGameID() {
        return gameID;
    }

    public void setGameID(long gameID) {
        this.gameID = gameID;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public JsonPlayer getUser() {
        return user;
    }

    public void setUser(JsonPlayer user) {
        this.user = user;
    }

    public JsonPlayer getOpponent() {
        return opponent;
    }

    public void setOpponent(JsonPlayer opponent) {
        this.opponent = opponent;
    }
}
