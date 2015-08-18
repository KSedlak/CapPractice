package com.other.ArmstrongNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ArmstrongNumbersTest {

	@Test
	public void testArmstrong() {
		
		//given
		ArmstrongNumbers an=new ArmstrongNumbers();
		//when
		boolean res = an.isArmstrong(153);
		//then
		Assert.assertEquals(true, res);
	
	}

	@Test
	public void testArmstrong2() {
		
		//given
		ArmstrongNumbers an=new ArmstrongNumbers();
		//when
		boolean res = an.isArmstrong(407);
		//then
		Assert.assertEquals(true, res);
	
	}

	@Test
	public void testArmstrong3() {
		
		//given
		ArmstrongNumbers an=new ArmstrongNumbers();
		//when
		boolean res = an.isArmstrong(400);
		//then
		Assert.assertEquals(false, res);
	
	}

}
