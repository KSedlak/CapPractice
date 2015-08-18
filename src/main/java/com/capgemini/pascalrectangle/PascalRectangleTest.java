package com.capgemini.pascalrectangle;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class PascalRectangleTest {
PascalRectangle pr;
	@Test
	public void test36() {
			//given
			pr=new PascalRectangle();
			//when
			long result=pr.pascal(3, 6, false);
			//then
			Assert.assertEquals(15, result);
	}
	@Test
	public void test22() {
			//given
			pr=new PascalRectangle();
			//when
			long result=pr.pascal(2, 2, false);
			//then
			Assert.assertEquals(2, result);
	}
	
	@Test
	public void testColumnGraterThanRow() {
			//given
			pr=new PascalRectangle();
			//when
			long result=pr.pascal(4, 2, false);
			//then
			Assert.assertEquals(0, result);
	}
	@Test
	public void test4_10() {
			//given
			pr=new PascalRectangle();
			//when
			long result=pr.pascal(4, 10, false);
			//then
			Assert.assertEquals(120, result);
	}

}
