package com.sexypairs;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class sexyPairsTest {

	@Test
	public void testFirst() {
		//given
		SexyPairs sp = new SexyPairs();
		//when
		sp.calculatePairs(20);
		Pair p = sp.getPairsList().get(0);
		sp.print();
		//then
		Assert.assertEquals(5,p.getFirst() );
		Assert.assertEquals(11,p.getSecond() );
	}


	@Test
	public void testLast() {
		//given
		SexyPairs sp = new SexyPairs();
		//when
		sp.calculatePairsFermat(20);
		Pair p = sp.getPairsList().get(sp.getPairsList().size()-1);
		sp.print();
		//then
		Assert.assertEquals(13,p.getFirst() );
		Assert.assertEquals(19,p.getSecond() );
	}
}
