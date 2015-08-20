package com.capgemini.Euler298;

import org.junit.Assert;
import org.junit.Test;

public class EulerTest {
	
										///EXAMPLE FROM https://projecteuler.net/problem=298
	@Test
	public void testLarryPoints() {
		//given
		EulerMachine em=new EulerMachine();
		Player p1 = new Larry();
		Player p2 =new Robin();
		//when
		em.addObserver(p1);
		em.addObserver(p2);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(6);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(8);
		em.callSpecifiedNumber(10);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(1);
		int l=p1.getPoints();		
		//then
		Assert.assertEquals(2, l);

	}
	
	@Test
	public void testLarryFirstObjectInMemory() {
		//given
		EulerMachine em=new EulerMachine();
		Player p1 = new Larry();
		Player p2 =new Robin();
		//when
		em.addObserver(p1);
		em.addObserver(p2);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(6);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(8);
		em.callSpecifiedNumber(10);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		int l=p1.getMemory().get(0);		
		//then
		Assert.assertEquals(1, l);

	}
	
	@Test
	public void testRobinFirstObjectInMemory() {
		//given
		EulerMachine em=new EulerMachine();
		Player p1 = new Larry();
		Player p2 =new Robin();
		//when
		em.addObserver(p1);
		em.addObserver(p2);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(6);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(8);
		em.callSpecifiedNumber(10);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		int l=p2.getMemory().get(0);		
		//then
		Assert.assertEquals(2, l);

	}
	
	@Test
	public void testRobinScore() {
		//given
		EulerMachine em=new EulerMachine();
		Player p1 = new Larry();
		Player p2 =new Robin();
		//when
		em.addObserver(p1);
		em.addObserver(p2);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(6);
		em.callSpecifiedNumber(1);
		em.callSpecifiedNumber(8);
		em.callSpecifiedNumber(10);
		em.callSpecifiedNumber(2);
		em.callSpecifiedNumber(4);
		em.callSpecifiedNumber(1);
		int l=p2.getPoints();		
		//then
		Assert.assertEquals(3, l);

	}

}
