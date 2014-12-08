package com.hellhounds.battlefree.game;

import com.hellhounds.battlefree.game.units.Unit;
import java.util.Random;

public class Player{

    private String username;
    private boolean loss;
    private Unit unit1;
    private Unit unit2;
    private Unit unit3;
    private int gold;
    private int steel;
    private int crystal;

    public Player(String username, Unit unit1, Unit unit2, Unit unit3)
    {
        this.username = username;
        this.loss = false;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
        initUnits();
        generateResource();
    }

    private void initUnits()
    {
        Unit[] units = getUnits();
        for(Unit unit : units)
            unit.setOwner(this);
    }

    public void generateResource()
    {
        Random rand = new Random();
        Unit[] units = getUnits();

        for(Unit unit : units)
        {
            if(unit.isAlive())
            {
                switch(rand.nextInt(3))
                {
                    case 0:
                        this.gold++;
                        System.out.format("%s got one GOLD resource\n", 
                                          this.username);
                        break;

                    case 1:
                        this.steel++;
                        System.out.format("%s got one STEEL resource\n", 
                                          this.username);
                        break;

                    case 2:
                        this.crystal++;
                        System.out.format("%s got one CRYSTAL resource\n", 
                                          this.username);
                        break;

                }
            }
        }
    }

    public void generateResource(int times)
    {
        Random rand = new Random();
        for(int i = 0; i < times; i++)
        {
            switch(rand.nextInt(3))
            {
                case 0:
                    this.gold++;
                    System.out.format("%s got one GOLD resource\n", 
                                      this.username);
                    break;

                case 1:
                    this.steel++;
                    System.out.format("%s got one STEEL resource\n", 
                                      this.username);
                    break;

                case 2:
                    this.crystal++;
                    System.out.format("%s got one CRYSTAL resource\n", 
                                      this.username);
                    break;
            }
        }
    }

    public void addResource(String type, int amount)
    {
        switch(type)
        {
            case "GOLD":
                this.gold = this.gold + amount;
                break;

            case "STEEL":
                this.steel = this.steel + amount;
                break;

            case "CRYSTAL":
                this.crystal = this.crystal + amount;
                break;

            default:
                System.out.println("Not a valid resource: " + type);
        }
    }

    public int removeResource(String type, int amount)
    {
        switch(type)
        {
            case "GOLD":
                if(this.gold > 0 && this.gold >= amount)
                {
                    this.gold = this.gold - amount;
                    return amount;
                } break;

            case "STEEL":
                if(this.steel > 0 && this.steel >= amount)
                {
                    this.steel = this.steel - amount;
                    return amount;
                } break;

             case "CRYSTAL":
                if(this.crystal > 0 && this.crystal >= amount)
                {
                    this.crystal = this.crystal - amount;
                    return amount;
                } break;

             default:
                System.out.println("Not a valid resource: " + type);
                return 0;
           }
        return 0;
    }

    public Unit[] getUnits()
    {
        Unit[] units = {unit1, unit2, unit3};
        return units;
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

    public boolean getLoss(){ return loss; }
    public void setLoss(boolean loss){ this.loss = loss; }
}
