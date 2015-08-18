package com.GameOfLifeInitMouse;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;


public	class BoardPresentation extends JComponent {
	private Board control;
	private	CellReader cc;
	private	int sizeRect;
	private	JLabel labelForGenerationCounter;
	private	MouseHandler mh;

		public BoardPresentation(Board g, CellReader c, JLabel gen, int sizeSingleRect) {
			control = g;
			control.initMatrixRandom();
			labelForGenerationCounter = gen;
			sizeRect = sizeSingleRect;
			cc = c;
			mh = new MouseHandler(sizeRect, control, this);
			addMouseListener(mh);

		}

		public void next() {
			control.nextGeneration();
			labelForGenerationCounter.setText("Generation: " + control.getGeneration());
			repaint();
		}

		public void random() {
			control.initMatrixRandom();
			control.setGeneration(0);
			repaint();
		}

		public void mouseEnable() {
			control.initMatrixChoosenLifeStatus(LifeStatus.Dead);
			mh.setEnable(true);
			repaint();

		}

		public void mouseDisable() {
			mh.setEnable(false);
			control.generateNeighboursListForMatrix();
			control.setGeneration(0);
		}

		public void read() throws IOException {
			control.setGeneration(0);
			cc.setBoardParamteresFromFile(control);
			repaint();
		}

		public void paint(Graphics g) {

			for (int i = 0; i < control.getH(); i++) {
				for (int j = 0; j < control.getW(); j++) {
					if (control.getListOfCells().get(i * control.getW() + j).getCurrentState().equals(LifeStatus.Life)) {
						g.fillRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
					} else {
						g.drawRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
					}
				}
			}

		}

	}

