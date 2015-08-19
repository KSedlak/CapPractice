package com.other.Hangman;


import org.junit.Test;

import junit.framework.Assert;

public class GameLogicTest {

	@Test
	public void testReplaceLetter() {
		//given
		GameLogic gl= new GameLogic();
		//when
		gl.setCurrentWord(new Word("trawa"));
		String w=gl.replaceLetterAtIndex(gl.getCurrentWord().getWord(),'x', 2);
		//then
		Assert.assertEquals("txawa", w);
		
	}
	@Test
	public void testReavealLetter() {
		//given
		GameLogic gl= new GameLogic();
		//when
		gl.setCurrentWord(new Word("trawa"));
		gl.checkLetterAndMoidifyGaps('w');
		String gaps=gl.getWordWithGaps();
		//then
		Assert.assertEquals("_ _ _ w _", gaps);
		
	}

}
