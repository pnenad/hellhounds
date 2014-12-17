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
import com.hellhounds.battlefree.game.Player;
import com.hellhounds.battlefree.game.effects.Effect;
import com.hellhounds.battlefree.game.units.Unit;

/**
 * Class for serializing game information about players
 * into sendable (via network) Json strings.
 **/
public class Serializer {

    private Gson gson;

    public Serializer()
    {
        gson = new GsonBuilder().create();
    }

    public String getJsonMessage(Message message)
    {
        return gson.toJson(message);
    }

    public JsonPlayer generateJsonPlayer(Player player)
    {
        JsonUnit[] jsonUnits = new JsonUnit[player.getUnits().length];
        int index = 0;

        for(Unit unit : player.getUnits())
        {
            jsonUnits[index++] = generateJsonUnit(unit);
        }

        return new JsonPlayer(player.getUsername(), jsonUnits, player.getGold(), player.getSteel(), player.getCrystal());
    }

    public JsonUnit generateJsonUnit(Unit source)
    {
        Effect primary = source.getAbility().getPrimary();
        Effect secondary = source.getAbility().getSecondary();
        
        Target[] pTargets = generateJsonTargets(source, primary.getTargets());
        Target[] sTargets = generateJsonTargets(source, secondary.getTargets());

        return new JsonUnit(source, pTargets, sTargets);
    }

    private Target[] generateJsonTargets(Unit source, Unit[] units)
    {
        Target[] targets = new Target[units.length];
        int index = 0;

        for(Unit target : units)
        {
            targets[index++] = new Target(
                    target.getOwner().getUsername(),
                    target.getName());
        }

        return targets;
    }
}
