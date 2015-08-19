package com.other.Hangman;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;

public	class WordPresentation extends JComponent {
	private GameLogic word;

		public WordPresentation(GameLogic w) {
		word=w;
		setFocusable(true);
		}

		public void paint(Graphics g) {
		g.setFont(new Font("Arial", 2, 40));
		g.drawString(word.getWordWithGaps(), 150, 200);

		}

		public Word getWord() {
			return word.getCurrentWord();
		}

		public void setWord(Word word) {
			this.word.setCurrentWord(word);
			repaint();
		}
		
		
	}

