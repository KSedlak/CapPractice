package com.StringSequence;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class StringSubseqentTest {

	@Test
	public void oneInSecond() {
		//given
		StringSubseqent sq =new StringSubseqent();
		//when
		String largest=sq.getLargestSubsequent2("raz","razdwatrzy");
		//then
		Assert.assertEquals("raz", largest);
	}
	
	@Test
	public void fragmentOneInSecond() {
		//given
		StringSubseqent sq =new StringSubseqent();
		//when
		String largest=sq.getLargestSubsequent2("raztrzy","razdwatrzy");
		//then
		Assert.assertEquals("trzy", largest);
	}
	@Test
	public void fragment() {
		//given
		StringSubseqent sq =new StringSubseqent();
		//when
		String largest=sq.getLargestSubsequent2("krolik raz","razkrolikibyly");
		//then
		Assert.assertEquals("krolik", largest);
	}
}
