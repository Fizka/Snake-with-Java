package com.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener{

    private JLabel titlegame;

    private int[] snakeXLenght = new int[750];
    private int[] snakeYLenght = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon snakeMouth;
    private ImageIcon snakeBodyLight;
    private ImageIcon snakeBodyDark;

    private Timer timer;
    private int delay = 100;

    public GamePanel(){

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeys(false);
        timer = new Timer(delay, this);
        timer.start();

        }

    public void paint(Graphics g){

    g.setColor(Color.WHITE);
    g.drawRect(24,10,801,55);

    //titlegame = new JLabel("Snake");

    g.setColor(Color.WHITE);
    g.drawRect(24,74,801,577);

    g.setColor(Color.black);
    g.fillRect(25,75,800,575);

    snakeMouth = new ImageIcon("headpink.png");
    snakeMouth.paintIcon(this, g, snakeXLenght[0], snakeYLenght[0]);

    g.dispose();

}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
