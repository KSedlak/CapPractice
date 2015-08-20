package com.capgemini.GameOfLifeInitMouse;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;


public	class BoardPresentation extends JComponent {
	
	private Board board;
	private	int sizeRect;
	private	MouseHandler mh;

		public BoardPresentation(Board g, int sizeSingleRect) {
			board = g;

			sizeRect = sizeSingleRect;
			mh = new MouseHandler(sizeRect, board, this);
			addMouseListener(mh);

		}

		public void mouseEnable() {
			board.ClearBoard();
			mh.setEnable(true);		
			repaint();

		}

		public void mouseDisable() {
			mh.setEnable(false);
			
		}
		
		public void setBoard(Board b){
			this.board=b;
			repaint();
			
		}

		public void paint(Graphics g) {

			for (int i = 0; i < board.getHeight(); i++) {
				for (int j = 0; j < board.getWidth(); j++) {
					LifeStatus cellStatus=board.getListOfCells().get(i * board.getWidth() + j).getCurrentState();
					
					if (cellStatus.equals(LifeStatus.Life)) 
						g.fillRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
					
					if (cellStatus.equals(LifeStatus.Dead)) 
						g.drawRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
					
				}
			}

		}
		

	}

