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
 * Simplified player object to be sent through a JSON message
 */
public class JsonPlayer {

    private String username;
    private int gold, steel, crystal;
    private JsonUnit[] units;

    public JsonPlayer(String username, JsonUnit[] units, int gold, int steel, int crystal)
    {
        this.username = username;
        this.units = units;
        this.gold = gold;
        this.steel = steel;
        this.crystal = crystal;
    }
}
