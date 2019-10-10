package com.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener{

    private JLabel titlegame;

    private int[] snakeXLenght = new int[750];
    private int[] snakeYLenght = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private int lenghtOfSnake = 3;
    private int score = 0;
    private ImageIcon snakeMouth;
    private ImageIcon snakeBodyLight;
    private ImageIcon snakeBodyDark;
    private ImageIcon apple;

    Random randomNumber = new Random();

    private int appleY = 75 + randomNumber.nextInt(23) * 25;
    private int appleX = 25 + randomNumber.nextInt(25) * 25;

    private int moves = 0;
    private Timer timer;
    private int delay = 100;

    public GamePanel(){

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();

        }

    public void paint(Graphics g){

    if(moves == 0)
    {
        snakeXLenght[2] = 50;
        snakeXLenght[1] = 75;
        snakeXLenght[0] = 100;

        snakeYLenght[2] = 100;
        snakeYLenght[1] = 100;
        snakeYLenght[0] = 100;

    }
    g.setColor(Color.WHITE);
    g.drawRect(24,10,801,55);
    g.setFont(new Font("arial", Font.BOLD, 16));
    g.drawString("Snake", 400, 30);

    g.setColor(Color.WHITE);
    g.drawRect(24,74,801,577);

    g.setColor(Color.black);
    g.fillRect(25,75,800,575);

    g.setColor(Color.MAGENTA);
    g.setFont(new Font("arial", Font.BOLD, 16));
    g.drawString("Scores: " + score, 600, 30);

    snakeMouth = new ImageIcon("headpinkmini.png");
    snakeMouth.paintIcon(this, g, snakeXLenght[0], snakeYLenght[0]);
    apple = new ImageIcon("applegreen.png");
    apple.paintIcon(this, g, appleX, appleY);


    for(int i = 0; i<lenghtOfSnake; i++)
    {
        if(i==0)
        {
            snakeMouth.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
        }

        if(i>0)
        {
            snakeBodyDark = new ImageIcon("bodysnakemini.png");
            snakeBodyDark.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
        }
    }

        if ( appleX != snakeXLenght[0] && appleY != snakeYLenght[0]) {
            apple.paintIcon(this, g, appleX, appleY);

        }

        for(int i = 0; i<lenghtOfSnake; i++) {

            if (appleX == snakeXLenght[i] && appleY == snakeYLenght[i]) {

                lenghtOfSnake++;
                appleY = 75 + randomNumber.nextInt(23) * 25;
                appleX = 25 + randomNumber.nextInt(25) * 25;
                score++;
            }
        }

        for(int i = 1; i<lenghtOfSnake; i++)
        {
            if (snakeXLenght[i] == snakeXLenght[0] && snakeYLenght[i] == snakeYLenght[0])
            {
            right = false;
            left = false;
            up = false;
            down = false;

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 35));
            g.drawString("space to restart", 350, 340);
            }

        }
        g.dispose();

}

    @Override
    public void actionPerformed(ActionEvent e) {

        timer.start();
        if(right)
        {
            for(int i = lenghtOfSnake-1; i>=0; i--)
            {
                snakeYLenght[i+1] = snakeYLenght[i];
            }

            for(int i = lenghtOfSnake; i>=0; i-- )
            {
                if(i==0)
                {
                    snakeXLenght[i] = snakeXLenght[i] + 25;
                }
                else
                {
                    snakeXLenght[i] = snakeXLenght[i-1];
                }
                if(snakeXLenght[i] > 800)
                {
                    snakeXLenght[i] = 25;
                }
            }

            repaint();
        }

        if(down)
        {
            for(int i = lenghtOfSnake-1; i>=0; i--)
            {
                snakeXLenght[i+1] = snakeXLenght[i];
            }

            for(int i = lenghtOfSnake; i>=0; i-- )
            {
                if(i==0)
                {
                    snakeYLenght[i] = snakeYLenght[i] + 25;
                }
                else
                {
                    snakeYLenght[i] = snakeYLenght[i-1];
                }
                if(snakeYLenght[i] > 625)
                {
                    snakeYLenght[i] = 75;
                }
            }

            repaint();
        }

        if(up)
        {
            for(int i = lenghtOfSnake-1; i>=0; i--)
            {
                snakeXLenght[i+1] = snakeXLenght[i];
            }

            for(int i = lenghtOfSnake; i>=0; i-- )
            {
                if(i==0)
                {
                    snakeYLenght[i] = snakeYLenght[i] - 25;
                }
                else
                {
                    snakeYLenght[i] = snakeYLenght[i-1];
                }
                if(snakeYLenght[i] < 75)
                {
                    snakeYLenght[i] = 625;
                }
            }

            repaint();
        }

        if(left)
        {
            for(int i = lenghtOfSnake-1; i>=0; i--)
            {
                snakeYLenght[i+1] = snakeYLenght[i];
            }

            for(int i = lenghtOfSnake; i>=0; i-- )
            {
                if(i==0)
                {
                    snakeXLenght[i] = snakeXLenght[i] - 25;
                }
                else
                {
                    snakeXLenght[i] = snakeXLenght[i-1];
                }
                if(snakeXLenght[i] < 25)
                {
                    snakeXLenght[i] = 800;
                }
            }

            repaint();
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
           moves = 0;
           score = 0;
           lenghtOfSnake = 3;
           repaint();
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            right = true;
            if(!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
            left = true;
            if(!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }


        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves++;
            up = true;
            if(!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }
            right = false;
            left = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            down = true;
            if(!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }
            right = false;
            left = false;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
