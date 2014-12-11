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
        centerLabel = new JLabel("Center Panel\n");
        rightLabel = new JLabel("Right Panel\n");

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

        //create vertical box
        leftBox = new Box(1);
        leftBox.createVerticalBox();
        leftBox.add(leftLabel);

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
            String source = "../../../../"+u.getName()+".gif";
            button.setToolTipText("<html><img src=\"" + GuiTest.class.getResource(source) + "\" />" +
                    "<br/>" +
                    "<p>This is the " +
                    u.getName() + "<br/>Ability: " +
                    u.getAbility().getName() +
                    "<br/>Primary effect: " +
                    u.getAbility().getPrimary().getType() +
                    "<br/>Value : " +
                    u.getAbility().getPrimary().getNumericalValue());
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
        rightPanel.add(new JButton("Play"));
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

