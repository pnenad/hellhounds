package com.hellhounds.battlefree.game.abilities;

import com.hellhounds.battlefree.game.effects.Effect;

public class Ability{

    private String name;
    private Payment cost;
    private boolean activated;
    private Effect primary;
    private Effect secondary;

    public Ability(String name, Payment cost, Effect primary, Effect secondary)
    {
        this.name = name;
        this.cost = cost;
        this.activated = false;
        this.primary = primary;
        this.secondary = secondary;
    }
   
    public boolean checkSpecificPayment(Payment po)
    {
        return this.cost.getGold() == po.getGold() &&
               this.cost.getSteel() == po.getSteel() &&
               this.cost.getCrystal() == po.getCrystal();
    }

    public boolean checkAnyPayment(Payment ap)
    {
        int sumCost = this.cost.getGold() + this.cost.getSteel() +
                      this.cost.getCrystal() + this.cost.getAny();

        int sumPay = ap.getGold() + ap.getSteel() + ap.getCrystal();
        
        return sumCost == sumPay;
    }

    public Effect getPrimary(){ return primary; }
    public void setPrimary(Effect primary){ this.primary = primary; }

    public Effect getSecondary(){ return secondary; }
    public void setSecondary(Effect secondary){ this.secondary = secondary; }

     public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public Payment getCost(){ return this.cost; }
    public void setCost(Payment cost){ this.cost = cost; }

    public boolean isActivated(){ return this.activated; }
    public void setActivated(boolean activated){ this.activated = activated; }
}
