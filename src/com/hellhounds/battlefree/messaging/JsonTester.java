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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hellhounds.battlefree.game.Game;
import com.hellhounds.battlefree.game.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class JsonTester {

    public static void main(String[] args)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        HashMap<Long, Game> games = new HashMap<>();

        JsonUnit unit1 = new JsonUnit("Archer", 100, false, null, null);
        JsonUnit unit2 = new JsonUnit("Defender", 100, false,  null, null);
        JsonUnit unit3 = new JsonUnit("Barbarian", 100, false,  null, null);

        JsonUnit[] units = {unit1, unit2, unit3};

        RequestMessage rm = new RequestMessage("Mannebind", units);
        String json = new Serializer().getJsonMessage(rm);

        Message head = gson.fromJson(json, Message.class);
        MessageType type = head.getType();
        MessageHandler messageHandler = new MessageHandler();

        Message body = null;

        Player opponent = null;

        switch (type)
        {
            case TARGETS:
                body = (TargetsMessage) gson.fromJson(json, TargetsMessage.class);
                break;
            case REQUEST:
                opponent = messageHandler.handleRequest((RequestMessage) gson.fromJson(json, RequestMessage.class), opponent, games);
                break;
            default:
                body = gson.fromJson(json, Message.class);
        }

        JsonUnit punit1 = new JsonUnit("Mushroom", 100, false, null, null);
        JsonUnit punit2 = new JsonUnit("Vampire", 100, false,  null, null);
        JsonUnit punit3 = new JsonUnit("Golem", 100, false,  null, null);

        JsonUnit[] punits = {punit1, punit2, punit3};

        RequestMessage prm = new RequestMessage("iEzpeN", punits);

        Message pmessage = gson.fromJson(new Serializer().getJsonMessage(prm), Message.class);
        MessageType ptype = pmessage.getType();


        switch (ptype)
        {
            case TARGETS:
                body = (TargetsMessage) gson.fromJson(json, TargetsMessage.class);
                break;
            case REQUEST:
                opponent = messageHandler.handleRequest((RequestMessage) gson.fromJson(new Serializer().getJsonMessage(prm), RequestMessage.class), opponent, games);
                break;
            default:
                body = gson.fromJson(json, Message.class);
        }


    }
}
