package com.other.Hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class HangmanPainting extends JComponent {
	private int pivot;
	private HangmanDraw hg;
	private GameResult gr;	
	
	public HangmanPainting() {
	pivot=0;
	hg=new HangmanDraw();
	gr=null;
	}

	public void paint(Graphics g) {
		FigureCoordinates temp;
		if(gr!=null){
			g.setColor(gr.getColor());
			g.setFont(new Font("Arial", 2, 50));
			g.drawString(gr.getMessage(), 20, 50);
		}
		for (int i = 0; i < pivot; i++) {
			temp = hg.getLinesOfHangMan().get(i);
		if(temp.isOval()){
			g.drawOval(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2());
		}else{
			g.drawLine(temp.getX1(), temp.getY1(), temp.getX2(), temp.getY2());
		}
			
		}

	}

	public void setGr(GameResult gr) {
		this.gr = gr;
		repaint();
	}

	public int getPivot() {
		return pivot;
	}

	public void setPivot(int pivot) {
		this.pivot = pivot;
		repaint();
	}
	public void increasePivot() {
		pivot++;
		repaint();
	}

	public HangmanDraw getHg() {
		return hg;
	}

	public void setHg(HangmanDraw hg) {
		this.hg = hg;
	}
	



}
