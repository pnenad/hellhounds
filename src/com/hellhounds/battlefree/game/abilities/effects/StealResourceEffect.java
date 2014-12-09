package com.hellhounds.battlefree.game.abilities.effects;

import com.hellhounds.battlefree.game.units.Unit;
import java.util.ArrayList;
import java.util.Random;

public class StealResourceEffect extends Effect{

    private ArrayList<String> resourceList;
    
    public StealResourceEffect(int value)
    {
        super(EffectType.STEAL, value);
        resourceList = new ArrayList<String>();
        resourceList.add("STEEL");
        resourceList.add("GOLD");
        resourceList.add("CRYSTAL");
    }

    @Override
    public void applyEffect(Unit source)
    {
        Random rand = new Random();
        Unit[] targets = getTargets();
        int index = rand.nextInt(resourceList.size());
        String resource = resourceList.get(index);

        if(resourceList.size() > 0)
        {
            for(Unit target : targets)
            {
                int stolenResource = target.getOwner().removeResource(resource,
                                     getNumericalValue());
                
                if(stolenResource > 0)
                {
                    source.getOwner().addResource(resource, stolenResource);

                    System.out.format("%s's %s stole %d %s from %s\n",
                                      source.getOwner().getUsername(),
                                      source.getName(),
                                      stolenResource,
                                      resource,
                                      target.getOwner().getUsername());
                    break;
                }
                else
                {
                    resourceList.remove(index);
                    applyEffect(source);
                }
            }
        }
    }
}


