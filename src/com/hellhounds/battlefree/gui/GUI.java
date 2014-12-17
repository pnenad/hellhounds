package com.hellhounds.battlefree.gui;

import com.hellhounds.battlefree.game.units.*;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by Nenad Petkovic on 17.12.14.
 */

public class GUI extends Thread implements ActionListener{
    private JFrame mainFrame;
    private JPanel choosePanel;
    private Box chooseBox;
    private JButton play;
    private JPanel gamePanel;
    private ArrayList<JRadioButton> buttons;
    private JLabel background;
    private int counter;

    public GUI(){
        buttons = new ArrayList<>();
        counter = 0;
        makeGUI();
    }

    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();

        while(true) {
            gui.checkSelection();
        }
    }

    private void makeGUI(){
        //create main frame
        mainFrame = new JFrame("Open Warfare");
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.setResizable(false);

        //add frame listener to kill process when 'x' is pressed
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //create a new JLabel that will be used as a background element
        background = new JLabel(new ImageIcon("Artwork/map.png"));
        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        background.setOpaque(false);

        //create a new panel that will be used as a selection menu
        choosePanel = new JPanel();
        choosePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        choosePanel.setBackground(new Color(0,0,0,0));
        choosePanel.setOpaque(true);

        //create a vertical box so that the elements are sortet over each other
        chooseBox = new Box(1);
        chooseBox.createVerticalBox();
        chooseBox.setOpaque(true);
        chooseBox.setBackground(new Color(0,0,0,0));

        //create a main label (a title)
        chooseBox.add(new JLabel("Please select 3 units!"));

        //call the create buttons method
        //this method creates all the buttons from the available unit classes, populates description and
        //add action listeners for the selection menu
        createButtons();

        //create a play button
        play = new JButton();
        play.setIcon(new ImageIcon("Artwork/play.png"));
        play.setPressedIcon(new ImageIcon("Artwork/play_pressed.png"));
        play.setPreferredSize(new Dimension(190, 49));
        play.setBorder(new BorderUIResource.EmptyBorderUIResource(0,0,0,0));
        play.setBackground(new Color(0, 0, 0, 0));
        play.setActionCommand("play");
        play.addActionListener(this);

        //add a play button to vertical box
        chooseBox.add(play);

        //add a vertical box to main selection (or a start) menu
        choosePanel.add(chooseBox);

        //add the main selection menu to the background panel
        background.add(choosePanel);

        //add the background panel to the main frame
        mainFrame.add(background);

        //pack everything together and set the window size to image size
        mainFrame.pack();

        //show the main frame
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (cmd == "play") {
            if(counter != 3){
                System.out.println("You have to select 3 units");
            }
            else{
                gamePanel = new JPanel();
                gamePanel.setLayout(new FlowLayout());
                gamePanel.setBackground(new Color(0,0,0,0));

                JLabel l = new JLabel("This is the game window.");
                l.setBackground(new Color(0,0,0,0));
                gamePanel.add(l);

                JLabel back = new JLabel(new ImageIcon("Artwork/map.png"));
                back.setLayout(new FlowLayout(FlowLayout.CENTER));
                back.setOpaque(false);

                back.add(gamePanel);

                mainFrame.remove(background);
                mainFrame.add(back);
                mainFrame.pack();
                mainFrame.setVisible(true);
            }
        }
    }

    private ArrayList<JRadioButton> getSelection(){
        return buttons;
    }

    private void createButtons() {
        for(final Unit u : getAllUnits()){
            final JRadioButton button = new JRadioButton(u.getName());
            button.setText(u.getName());
            String source = "../../../../"+u.getName()+".png";
            button.setToolTipText("<html><img src=\"" + GUI.class.getResource(source) + "\" />" +
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
                        counter++;
                    } else {
                        counter--;
                    }
                }
            });
            button.setBackground(new Color(0, 0, 0, 0));
            buttons.add(button);
            chooseBox.add(button);
        }
    }

    private void checkSelection() throws InterruptedException {
        System.out.println("Selected units: " + counter);
        Thread.sleep(300);
        if (counter == 3) {
            for (final JRadioButton b : getSelection()) {
                if (!b.isSelected()) {
                    b.setEnabled(false);
                }
            }
        }
        else if(counter < 3 && counter > 0){
            for (final JRadioButton b : getSelection()) {
                if (!b.isEnabled()) {
                    b.setEnabled(true);
                }
            }
        }
    }

    private Unit[] getAllUnits(){
        Unit[] units = {new Archer(), new Barbarian(), new Catapult(), new Defender(), new Dwarf(), new Footsoldier(),
                new Golem(), new Mage(), new Mushroom(), new Orc(), new Skeleton(), new Supplycart(), new Thief(),
                new Vampire()};
        return units;
    }
}
