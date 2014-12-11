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
