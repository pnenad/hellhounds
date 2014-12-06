package com.hellhounds.battlefree.game.abilities;

public class Ability{

    private String name;
    private Payment cost;
    private boolean activated;
    private AbilityType abilityType;
    private int value;

    public Ability(String name, Payment cost, AbilityType at, int value)
    {
        this.name = name;
        this.cost = cost;
        this.activated = false;
        this.abilityType = at;
        this.value = value;
    }
    
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    public Payment getCost(){ return this.cost; }
    public void setCost(Payment cost){ this.cost = cost; }

    public boolean isActivated(){ return this.activated; }
    public void setActivated(boolean activated){ this.activated = activated; }

    public AbilityType getAbilityType(){ return this.abilityType; }
    public void setAbilityType(AbilityType at){ this.abilityType = at; }

    public int getValue(){ return this.value; }
    public void setValue(int value){ this.value = value; }
    
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
}
