package com.hellhounds.battlefree.game;

public class Game{

    private Player player1;
    private Player player2;
    private long gameID;
    private int roundNr;
    // 0 = Active game, 1 = player 1 won, 2 = player 2 won
    private int winStatus;

    public Game(Player player1, Player player2, long gameID)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.gameID = gameID;
        this.roundNr = 0;
        this.winStatus = 0;
    }

    public Player getPlayer1() { return player1; }
    public void setPlayer1(Player player1){ this.player1 = player1; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2){ this.player2 = player2; }

    public long getGameID() { return gameID; }
    public void setGameID(long gameID){ this.gameID = gameID; }

    public int getRoundNr() { return roundNr; }
    public void setRoundNr(int roundNr){ this.roundNr = roundNr; }

    public int getWinStatus() { return winStatus; }
    public void setWinStatus(int winStatus){ this.winStatus = winStatus; }
}
