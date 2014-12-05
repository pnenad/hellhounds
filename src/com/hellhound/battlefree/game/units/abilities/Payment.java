package com.hellhound.battlefree.game.units.abilities;

public class Payment{
    
    private int gold;
    private int steel;
    private int crystal;
    private int any;

    public Payment()
    {
       this.gold = 0;
       this.steel = 0;
       this.crystal = 0;
       this.any = 0;
    }

    public Payment(int gold, int steel, int crystal, int any)
    {
        this.gold = gold;
        this.steel = steel;
        this.crystal = crystal;
        this.any = any;
    }

    public int getGold(){ return this.gold; }
    public void setGold(int gold){ this.gold = gold; }

    public int getSteel(){ return this.steel; }
    public void setSteel(int steel){ this.steel = steel; }

    public int getCrystal(){ return this.crystal; }
    public void setCrystal(int crystal){ this.crystal = crystal; }

    public int getAny(){ return this.any; }
    public void setAny(int any){ this.any = any; }

    @Override
    public String toString()
    {
        return "Payment: " +
               "\n\tGold: " + getGold() +
               "\n\tSteel: " + getSteel() +
               "\n\tCrystal: " + getCrystal() +
               "\n\tAny: " + getAny();
    }
}
