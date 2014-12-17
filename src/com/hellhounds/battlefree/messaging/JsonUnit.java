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

import com.hellhounds.battlefree.game.units.Unit;

/**
 * Simplified unit class for ease of sending through Json messages
 */
public class JsonUnit {

    private String unitName;
    private int health;
    private boolean activated = false;
    private Target[] primaryTargets;
    private Target[] secondaryTargets;

    public JsonUnit(Unit unit)
    {
        this.unitName = unit.getName();
        this.health = unit.getMaxHealth();
        this.activated = unit.getAbility().isActivated();
        this.primaryTargets = null;
        this.secondaryTargets = null;
    }

    public JsonUnit(Unit unit, Target[] pTargets, Target[] sTargets)
    {
        this.unitName = unit.getName();
        this.health = unit.getMaxHealth();
        this.activated = unit.getAbility().isActivated();
        this.primaryTargets = pTargets;
        this.secondaryTargets = sTargets;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Target[] getPrimaryTargets() {
        return primaryTargets;
    }

    public void setPrimaryTargets(Target[] primaryTargets) {
        this.primaryTargets = primaryTargets;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Target[] getSecondaryTargets() {
        return secondaryTargets;
    }

    public void setSecondaryTargets(Target[] secondaryTargets) {
        this.secondaryTargets = secondaryTargets;
    }
}
