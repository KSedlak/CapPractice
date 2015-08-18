package com.capgemini.placeToSplit;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class PlaceToSplitTest {
	PlaceToSplit pts;

	@Test
	public void test() {
		// given
		pts = new PlaceToSplit();
		// when
		int[] t = { 1, 1, 1, 2, 1 };
		boolean split = pts.canBalance(t);
		// then
		Assert.assertEquals(true, split);
	}

	@Test
	public void testNotEqual() {
		// given
		pts = new PlaceToSplit();
		// when
		int[] t = { 2, 1, 1, 2, 1 };
		boolean split = pts.canBalance(t);
		// then
		Assert.assertEquals(false, split);
	}

	@Test
	public void testEqualValues() {
		// given
		pts = new PlaceToSplit();
		// when
		int[] t = { 10, 10 };
		boolean split = pts.canBalance(t);
		// then
		Assert.assertEquals(true, split);
	}

	@Test
	public void testOneBigValueNotEqual() {
		// given
		pts = new PlaceToSplit();
		// when
		int[] t = { 1, 1, 1, 1, 1, 4 };
		boolean split = pts.canBalance(t);
		// then
		Assert.assertEquals(false, split);
	}

	@Test
	public void testOneBigEqual() {
		// given
		pts = new PlaceToSplit();
		// when
		int[] t = { 1, 1, 1, 1, 1, 5 };
		boolean split = pts.canBalance(t);
		// then
		Assert.assertEquals(true, split);
	}
}
