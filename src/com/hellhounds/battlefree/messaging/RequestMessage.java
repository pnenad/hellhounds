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
