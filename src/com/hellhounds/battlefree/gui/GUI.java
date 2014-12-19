package com.hellhounds.battlefree.gui;

import com.hellhounds.battlefree.game.units.*;

import javax.swing.*;
import javax.swing.border.*;
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
    private ArrayList<JButton> buttons;
    private JLabel background;
    private int counter;
    private boolean selected;

    public GUI(){
        selected = false;
        buttons = new ArrayList<>();
        counter = 0;
        makeGUI();
    }

    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();

        while(!gui.selected) {
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
        //background.setOpaque(false);

        //create a new panel that will be used as a selection menu
        Border line = BorderFactory.createLineBorder(new Color(85,50,10,255));
        TitledBorder title = BorderFactory.createTitledBorder(line, "Please select 3 units.");
        choosePanel = new JPanel();
        choosePanel.setBorder(title);
        choosePanel.setBackground(new Color(0, 0, 0, 0));

        //create a vertical box so that the elements are sorted over each other
        chooseBox = new Box(1);
        chooseBox.createVerticalBox();
        chooseBox.setBackground(new Color(0, 0, 0, 0));

        //call the create buttons method
        //this method creates all the buttons from the available unit classes, populates description and
        //add action listeners for the selection menu
        createButtons();

        //create a play button
        play = new JButton();
        play.setIcon(new ImageIcon("Artwork/play.png"));
        play.setPressedIcon(new ImageIcon("Artwork/play_pressed.png"));
        play.setPreferredSize(new Dimension(190, 45));
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
                selected = true;

                gamePanel = new JPanel();
                gamePanel.setLayout(new FlowLayout());
                gamePanel.setBackground(new Color(0,0,0,0));

                JLabel l = new JLabel("This is the game window.");
                l.setBackground(new Color(0, 0, 0, 0));
                gamePanel.add(l);

                JLabel back = new JLabel(new ImageIcon("Artwork/map.png"));
                back.setLayout(new FlowLayout(FlowLayout.CENTER));

                back.add(gamePanel);

                mainFrame.remove(background);
                //remove background panel with all subelements from cache
                background = null;
                mainFrame.add(back);
                mainFrame.pack();
                mainFrame.setVisible(true);
            }
        }
    }

    //GUI.class.getResource(source)
    private ArrayList<JButton> getSelection(){
        return buttons;
    }

    private void createButtons() {
        for(final Unit u : getAllUnits()){
            final JButton button = new JButton();
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.CENTER);
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            button.setIcon(new ImageIcon("Artwork/button.png"));
            button.setPressedIcon(new ImageIcon("Artwork/button_pressed.png"));
            button.setDisabledIcon(new ImageIcon("Artwork/button_disabled.png"));
            button.setText(u.getName());
            String source = "../../../../"+u.getName()+".png";
            button.setToolTipText("<html><div style='background:#96734b;'<img src=\"" + GUI.class.getResource(source) + "\" />" +
                    "<br/>" +
                    "<p><b>This is the " +
                    u.getName() + "</b><br/>Ability: " +
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
                    if (!button.isSelected()) {
                        button.setSelected(true);
                        button.setIcon(new ImageIcon("Artwork/button_pressed.png"));
                        counter++;
                    } else {
                        button.setSelected(false);
                        button.setIcon(new ImageIcon("Artwork/button.png"));
                        counter--;
                    }
                }
            });
            button.setSize(130, 29);
            buttons.add(button);
            chooseBox.add(button);
        }
    }

    private void checkSelection() throws InterruptedException {
        if (counter == 3) {
            for (final JButton b : getSelection()) {
                if (!b.isSelected()) {
                    b.setEnabled(false);
                }
            }
        }
        else if(counter < 3 && counter > 0){
            for (final JButton b : getSelection()) {
                if (!b.isEnabled()) {
                    b.setEnabled(true);
                }
            }
        }
        else{
            Thread.sleep(200);
        }
    }

    private Unit[] getAllUnits(){
        Unit[] units = {new Archer(), new Barbarian(), new Catapult(), new Defender(), new Dwarf(), new Footsoldier(),
                new Golem(), new Mage(), new Mushroom(), new Orc(), new Skeleton(), new Supplycart(), new Thief(),
                new Vampire()};
        return units;
    }
}
