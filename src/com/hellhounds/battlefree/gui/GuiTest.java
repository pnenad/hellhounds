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
package com.hellhounds.battlefree.gui;

import com.hellhounds.battlefree.game.units.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by furai on 11.12.14.
 */
public class GuiTest {

    private JFrame mainFrame;
    private JLabel leftLabel;
    private JLabel centerLabel;
    private JLabel rightLabel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JPanel rightPanel;
    private JLabel[] selectedUnits;
    private JLabel unit1;
    private JLabel unit2;
    private JLabel unit3;
    private Box leftBox;
    private Box rightBox;
    private JPanel opponentUnits;
    private Box opponentBox;

    public GuiTest(){
        makeGUI();
    }

    public static void main(String[] argv){
        GuiTest gui = new GuiTest();
        gui.showMenu();
    }

    private void makeGUI(){

        //create main frame (window)
        mainFrame = new JFrame("Open Warfare");
        mainFrame.setSize(640,480);
        mainFrame.setLayout(new GridLayout(1,3));

        //create close (x) listener
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //create labels
        leftLabel = new JLabel("Please 3 units:");
        centerLabel = new JLabel("Selected Units\n");
        rightLabel = new JLabel("Play and Log:\n");

        //create left container
        leftPanel = new JPanel();
        //leftPanel.setLayout(new FlowLayout());
        //leftPanel.add(leftLabel);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

        //crete center container
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(centerLabel);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

        //create right
        rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());
        rightPanel.add(rightLabel);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

        //initialize labels for units
        unit1 = new JLabel("", JLabel.LEFT);
        unit2 = new JLabel("", JLabel.LEFT);
        unit3 = new JLabel("", JLabel.LEFT);

        //create panel for opponents chosen units
        opponentUnits = new JPanel();
        opponentUnits.setLayout(new FlowLayout());

        //crete vertical box for chose units
        opponentBox = new Box(1);
        opponentBox.createVerticalBox();
        opponentBox.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        opponentBox.add(new JLabel("Opponent's units:"));
        opponentBox.add(new JLabel("Unit 1"));
        opponentBox.add(new JLabel("Unit 2"));
        opponentBox.add(new JLabel("Unit 3"));
        opponentUnits.add(opponentBox);

        //create vertical box for units container
        leftBox = new Box(1);
        leftBox.createVerticalBox();
        leftBox.add(leftLabel);

        //create vertical box for play container
        rightBox = new Box(1);
        rightBox.createVerticalBox();
        rightBox.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.gray));
        rightBox.add(rightLabel);
        rightBox.add(new JButton("Play"));
        rightBox.add(opponentUnits);
        rightPanel.add(rightBox);
        rightPanel.add(opponentBox);

        //add components to main frame and make it visible
        mainFrame.add(leftPanel);
        mainFrame.add(centerPanel);
        mainFrame.add(rightPanel);
        mainFrame.setVisible(true);
    }

    private void showMenu(){
        //create units on the left panel
        for(final Unit u : getAllUnits()){
            final JRadioButton button = new JRadioButton(u.getName());
            button.setText(u.getName());
            String source = "../../../../"+u.getName()+".png";
            button.setToolTipText("<html><img src=\"" + GuiTest.class.getResource(source) + "\" />" +
                    "<br/>" +
                    "<p>This is the " +
                    u.getName() + "<br/>Ability: " +
                    u.getAbility().getName() +
                    "<br/>Primary effect: " +
                    u.getAbility().getPrimary().getType() +
                    "<br/>Value: " +
                    u.getAbility().getPrimary().getNumericalValue() +
                    "<br/>Secondary effect: " +
                    u.getAbility().getSecondary().getType() +
                    "<br/>Value: " +
                    u.getAbility().getSecondary().getNumericalValue());

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (button.isSelected()) {
                        for (JLabel l : getSelectedUnits()) {
                            if (l.getText().equals("")) {
                                l.setText("Selected unit is " + u.getName());
                                break;
                            }
                        }
                    }
                }
            });
            leftBox.add(button);
            for(JLabel l : getSelectedUnits()){
                centerPanel.add(l);
            }
        }

        leftPanel.add(leftBox);
        mainFrame.add(leftPanel);
        mainFrame.add(centerPanel);
        mainFrame.add(rightPanel);
        mainFrame.setVisible(true);
    }

    private Unit[] getAllUnits(){
        Unit[] units = {new Archer(), new Barbarian(), new Catapult(), new Defender(), new Dwarf(), new Footsoldier(),
                new Golem(), new Mage(), new Mushroom(), new Orc(), new Skeleton(), new Supplycart(), new Thief(),
                new Vampire()};
        return units;
    }

    private JLabel[] getSelectedUnits(){
        selectedUnits = new JLabel[]{unit1, unit2, unit3};
        return selectedUnits;
    }
}

