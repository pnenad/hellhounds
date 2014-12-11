/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
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
