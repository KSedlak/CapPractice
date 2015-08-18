package com.capgemini.pythagorean;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class PythagoreanTest {
Pythagorean p;
	@Test
	public void test() {
			//given
		p=new Pythagorean();
		//when
		p.find2(1000);
		p.find(1000);
		int a=p.a;
		int b=p.b;
		int c=p.c;
		//then
		Assert.assertEquals(200, a);
		Assert.assertEquals(375, b);
		Assert.assertEquals(425, c);
		Assert.assertEquals(1000, a+b+c);
	}

}
