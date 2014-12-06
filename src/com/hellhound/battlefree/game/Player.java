package com.hellhound.battlefree.game;

import com.hellhound.battlefree.game.units.Unit;

public class Player{

    private String username;
    private Unit unit1;
    private Unit unit2;
    private Unit unit3;
    private int gold;
    private int steel;
    private int crystal;

    public Player(String username)
    {
        this.username = username;
    }

    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }

    public Unit getUnit1() { return unit1; }
    public void setUnit1(Unit unit1){ this.unit1 = unit1; }

    public Unit getUnit2() { return unit2; }
    public void setUnit2(Unit unit2){ this.unit2 = unit2; }

    public Unit getUnit3() { return unit3; }
    public void setUnit3(Unit unit3){ this.unit3 = unit3; }

    public int getGold() { return gold; }
    public void setGold(int gold){ this.gold = gold; }

    public int getSteel() { return steel; }
    public void setSteel(int steel){ this.steel = steel; }

    public int getCrystal() { return crystal; }
    public void setCrystal(int crystal){ this.crystal = crystal; }

    @Override
    public String toString()
    {
        return "Username: " + username +
               "\nPlayer Resource: " +
               "\n\t\tGold: " + gold +
               "\n\t\tSteel: " + steel +
               "\n\t\tCrystal: " + crystal +
               "\n\nUnit1 --> " + unit1.toString() +
               "\n\nUnit2 --> " + unit2.toString() +
               "\n\nUnit3 --> " + unit3.toString();
    }
}
