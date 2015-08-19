package com.other.Hangman;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.JPanel;

public class WindowFrame extends JFrame {




	private JLabel wrongCounter;
	private JLabel pointCounter;
	
	private JButton next;
	private KeyboardListener kl;
	private WordPresentation wp;
	
	private Container buttons;
	private Container labels;
	
	JPanel presentation ;
	private GameLogic gl;
	private HangmanPainting hp;
	
	public WindowFrame(GameLogic g){
		gl=g;
		hp=gl.getHp();
		kl=new KeyboardListener(this);
		addKeyListener(kl);
		
		wp=new WordPresentation(gl);
		wrongCounter=new JLabel();
		pointCounter= new JLabel();

		setTitle("Hangman game - animals");
		setBounds(30, 30, 1000,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		
		initButtons();
		presentation =new JPanel(new GridLayout(1, 2));
		presentation.add(wp);
		presentation.add(hp);
		
		labels=new Container();
		labels.setLayout(new FlowLayout());
		labels.add(wrongCounter);
		labels.add(pointCounter);
		
		getContentPane().add(presentation, BorderLayout.CENTER);
		getContentPane().add(labels, BorderLayout.NORTH);
		getContentPane().add(buttons, BorderLayout.SOUTH);
		
		this.setVisible(true);

	}

	public void initButtons() {
		buttons = new Container();
		next = new JButton("next word");
		next.setFocusable(false);
		
		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(100, 50));
		
		buttons.add(next);
		
		addListeners();
		setSizeButtons();
		
	}
	public void addListeners(){ 
		//listenery
		

		next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
            	gl.randomWord();
            	wp.setWord(gl.getCurrentWord());
            	hp.setPivot(0);
            	
            	repaint();
            	
            }
            });
	}

	public void setSizeButtons() {
		next.setPreferredSize(new Dimension(100, 30));


	}

	public GameLogic getGl() {
		return gl;
	}

	public void setGl(GameLogic gl) {
		this.gl = gl;
	}

	public JLabel getWrongCounter() {
		return wrongCounter;
	}

	public void setWrongCounter(JLabel wrongCounter) {
		this.wrongCounter = wrongCounter;
	}

	public HangmanPainting getHp() {
		return hp;
	}

	public void setHp(HangmanPainting hp) {
		this.hp = hp;
	}

	public JLabel getPointCounter() {
		return pointCounter;
	}

	public void setPointCounter(JLabel pointCounter) {
		this.pointCounter = pointCounter;
	}


}
