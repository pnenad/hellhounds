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
package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.*;

public class SkeletonAbility extends Ability{

    public SkeletonAbility()
    {
        super("Bone Dagger", new Payment(0, 0, 1, 1),
                new PierceEffect(10, false, false),
                new PierceEffect(10, false, false));
    }
}
