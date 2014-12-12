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
 * Message to be sent from a client to the server. Contains
 * the sending players units' actions, with gameID and
 * username for identification.
 */
public class TargetsMessage extends Message{

    private long gameID;
    private String fromUsername;
    private JsonUnit[] actions;

    public TargetsMessage(long gameID, String fromUsername, JsonUnit[] actions)
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

    public JsonUnit[] getActions() { return actions; }
    public void setActions(JsonUnit[] actions) { this.actions = actions; }
}
