package com.Game;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame newFrame = new JFrame();
        GamePanel gamePanel = new GamePanel();

        newFrame.setBounds(10,10,855,700);
        newFrame.setBackground(Color.lightGray);
        newFrame.setResizable(false);
        newFrame.setVisible(true);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.add(gamePanel);

	//GameFrame newGame = new GameFrame();


    }
}
