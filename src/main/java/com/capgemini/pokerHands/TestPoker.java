package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.Test;

import com.capgemini.pokerHands.Rank;
import com.capgemini.pokerHands.Suit;

import junit.framework.Assert;

public class TestPoker {
	Poker p;

	@Test
	public void testReadFile() {
		// given
		try {
			p = new Poker();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.playAllMatchesAndCountPlayer1Winnings();
		int p1Wins = p.getP1Wins();
		// then
		Assert.assertEquals(376, p1Wins);
	}

	@Test
	public void testAddSameColorToHand() {
		// given
		Hand h = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.FIVE, Suit.CLUBS));
		h.addToHand(new Card(Rank.THREE, Suit.CLUBS));
		boolean same = h.isSameColor();
		// then
		Assert.assertEquals(true, same);
	}

	@Test
	public void testAddConToHand() {
		// given
		Hand h = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		boolean con = h.isConsecutive();
		// then
		Assert.assertEquals(true, con);
	}
	@Test
	public void tesRoyalToStraighFlush() {
		// given
		Hand h = new Hand();
		Hand h2 = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		
		
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h2.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h2.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		h2.addToHand(new Card(Rank.NINE, Suit.CLUBS));
		int res = h.compareTo(h2);
		// then
		Assert.assertEquals(-1, res);
	}
	
	@Test
	public void tesRoyalToFourOfKind() {
		// given
		Hand h = new Hand();
		Hand h2 = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		
		
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.NINE, Suit.CLUBS));
		int res = h2.compareTo(h);
		// then
		Assert.assertEquals(1, res);
	}
	@Test
	public void tesPairToPair() {
		// given
		Hand h = new Hand();
		Hand h2 = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		
		
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.EIGHT, Suit.CLUBS));
		h2.addToHand(new Card(Rank.THREE, Suit.CLUBS));
		h2.addToHand(new Card(Rank.NINE, Suit.CLUBS));
		int res = h.compareTo(h2);
		// then
		Assert.assertEquals(-1, res);
	}
	@Test
	public void tesNothingToNothing() {
		// given
		Hand h = new Hand();
		Hand h2 = new Hand();
		// when
		h.addToHand(new Card(Rank.ACE, Suit.CLUBS));
		h.addToHand(new Card(Rank.FIVE, Suit.CLUBS));
		h.addToHand(new Card(Rank.QUEEN, Suit.CLUBS));
		h.addToHand(new Card(Rank.JACK, Suit.CLUBS));
		h.addToHand(new Card(Rank.TEN, Suit.CLUBS));
		
		
		h2.addToHand(new Card(Rank.KING, Suit.CLUBS));
		h2.addToHand(new Card(Rank.FOUR, Suit.CLUBS));
		h2.addToHand(new Card(Rank.EIGHT, Suit.CLUBS));
		h2.addToHand(new Card(Rank.THREE, Suit.CLUBS));
		h2.addToHand(new Card(Rank.NINE, Suit.CLUBS));
		int res = h.compareTo(h2);
		// then
		Assert.assertEquals(-1, res);
	}


}
