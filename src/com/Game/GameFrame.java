package com.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{

    private JButton startButton;

    private JLabel scoreLabel;

    private JTextField scoreText;

    private JPanel gamePanel;

    public GameFrame() throws HeadlessException {

        super("Snake");

        init();
        LayoutInit();

    }

    private void init(){

        startButton = new JButton();
        startButton.setBackground(Color.CYAN);
        startButton.setText("Start");
        startButton.setFont(startButton.getFont().deriveFont(16.0f));
        startButton.addActionListener(this);
        startButton.setMaximumSize(new Dimension(10,30));

        scoreLabel = new JLabel();
        scoreLabel.setText("Score: ");
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(16.0f));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        scoreText = new JTextField();
        scoreText.setEditable(false);
        scoreText.setText("00");
        scoreText.setFont(scoreText.getFont().deriveFont(16.0f));
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);
        scoreText.setMinimumSize(new Dimension(10,20));
        scoreText.setMaximumSize(new Dimension(30,30));
        scoreText.setBackground(Color.WHITE);


        gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);


    }

    private void LayoutInit(){

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreLabel)
                        .addComponent(scoreText)
                        .addComponent(startButton)
                )
                .addGap(20)
                .addComponent(gamePanel)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(scoreLabel)
                        .addComponent(scoreText)
                        .addComponent(startButton)
                )
                .addGap(20)
                .addComponent(gamePanel)
        );

        setBounds(10,10,600,600);
        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
