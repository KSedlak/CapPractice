package com.capgemini.coins;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TestCoins {
Coins c;
	@Test
	public void testSimpleExample() {

		//given
		c=new Coins();
		//when 
		List list = new ArrayList<Integer>();
		c.stringToList(list,"1101110011");
		int solution = c.solution(list); 
		//then
		Assert.assertEquals(6, solution);
	}

	@Test
	public void testTwoSides() {

		//given
		c=new Coins();
		//when 
		List list = new ArrayList<Integer>();
		c.stringToList(list,"111111001111");
		int solution = c.solution(list); 
		//then
		Assert.assertEquals(7, solution);
	}
	@Test
	public void testFlipFirst() {

		//given
		c=new Coins();
		//when 
		List list = new ArrayList<Integer>();
		c.stringToList(list,"0111100101001");
		int solution = c.solution(list); 
		//then
		Assert.assertEquals(5, solution);
	}
	
	@Test
	public void testFlipLast() {

		//given
		c=new Coins();
		//when 
		List list = new ArrayList<Integer>();
		c.stringToList(list,"0111100111110");
		int solution = c.solution(list); 
		//then
		Assert.assertEquals(6, solution);
	}
	@Test
	public void testFlipMandatory() {

		//given
		c=new Coins();
		//when 
		List list = new ArrayList<Integer>();
		c.stringToList(list,"11111");
		int solution = c.solution(list); 
		//then
		Assert.assertEquals(4, solution);
	}

}
