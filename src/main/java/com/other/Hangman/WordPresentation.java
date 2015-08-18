package com.other.Hangman;

import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;


public	class WordPresentation extends JComponent {
	private Word word;

		public WordPresentation(Word w) {
		word=w;
		setFocusable(true);
		}

		public void paint(Graphics g) {
		g.setFont(new Font("Arial", 2, 50));
		g.drawString(word.getWordWithGaps(), 150, 200);

		}

		public Word getWord() {
			return word;
		}

		public void setWord(Word word) {
			this.word = word;
			repaint();
		}
		
		
	}

