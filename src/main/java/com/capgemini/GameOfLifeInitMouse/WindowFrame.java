package com.capgemini.GameOfLifeInitMouse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowFrame extends JFrame {


	private int sizeSingleRectangle;
	private BoardPresentation p;
	private	CellReader creator;
	private Board board;
	private GameLogic gol;
	private JLabel generationCounter;

	private JButton next;
	private JButton random;
	private JButton mouseStart;
	private JButton file;
	private JButton mouseEnd;

	private Container buttons;

	public WindowFrame(GameLogic gl, CellReader cc, int rectSize) {
		
		sizeSingleRectangle=rectSize;
		creator = cc;
		gol = gl;
		generationCounter = new JLabel("Generation: 0");
		p=new BoardPresentation(gol.getBoard(), generationCounter, sizeSingleRectangle);
		
		initButtons();
	
		setBounds(30, 30, gol.getBoard().getWidth()* sizeSingleRectangle + 90, gol.getBoard().getHeight() * sizeSingleRectangle + 130);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(buttons, BorderLayout.SOUTH);
		getContentPane().add(p, BorderLayout.CENTER);
		getContentPane().add(generationCounter, BorderLayout.NORTH);
		
		this.setVisible(true);
		mouseEnd.setVisible(false);

	}

	public void initButtons() {
		buttons = new Container();
		next = new JButton("next");
		random = new JButton("Random");
		mouseStart = new JButton("MouseInit");
		file = new JButton("Read from file");
		mouseEnd = new JButton("End");

		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(100, 50));
		buttons.add(random);
		buttons.add(file);
		buttons.add(next);
		buttons.add(mouseStart);
		buttons.add(mouseEnd);
		
		addListeners();
		setSizeButtons();
		
	}
	public void addListeners(){ 
		//listenery
		file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
            try {
				creator.setBoardParamteresFromFile(gol);
				p=new BoardPresentation(gol.getBoard(), generationCounter, sizeSingleRectangle);
				repaint();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
            });
		random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            gol.randomBoard();
        	p=new BoardPresentation(gol.getBoard(), generationCounter, sizeSingleRectangle);
        	p.repaint();
            }
            });
			next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	gol.nextGeneration();
            	repaint();

            }
            });
			mouseStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
            p.mouseEnable();
            mouseEnd.setVisible(true);
            }
            });
			mouseEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
            p.mouseDisable();
            mouseEnd.setVisible(false);
            }
            });
	}

	public void setSizeButtons() {
		next.setPreferredSize(new Dimension(70, 30));
		random.setPreferredSize(new Dimension(100, 30));
		file.setPreferredSize(new Dimension(150, 30));
		mouseStart.setPreferredSize(new Dimension(100, 30));
		mouseEnd.setPreferredSize(new Dimension(100, 30));
	}


}
