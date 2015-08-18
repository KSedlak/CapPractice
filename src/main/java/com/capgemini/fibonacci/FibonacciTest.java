package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class FibonacciTest {
	Fibonacci f;
		@Test
		public void testZero() {

			//given
			f=new Fibonacci();
			//when 
			long solution = f.fib(0);
			//then
			Assert.assertEquals(0, solution);
		}
		@Test
		public void testMinus() {

			//given
			f=new Fibonacci();
			//when 
			long solution = f.fib(-1);
			//then
			Assert.assertEquals(0, solution);
		}
		@Test
		public void testFirst() {

			//given
			f=new Fibonacci();
			//when 
			long solution = f.fib(1);
			//then
			Assert.assertEquals(1, solution);
		}
		@Test
		public void testSecond() {

			//given
			f=new Fibonacci();
			//when 
			long solution = f.fib(2);
			//then
			Assert.assertEquals(1, solution);
		}
		@Test
		public void test7() {

			//given
			f=new Fibonacci();
			//when 
			long solution = f.fib(7);
			//then
			Assert.assertEquals(13, solution);
		}
}
