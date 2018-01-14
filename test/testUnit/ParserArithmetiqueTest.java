package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import interpretation.ParserArithmetique;

public class ParserArithmetiqueTest {
	
	ParserArithmetique pa = new ParserArithmetique();

	@Test
	public void notNegativeTest() {
		String s = pa.notNegative("[-8]");
		assertEquals("-8",s);
	}
	
	@Test
	public void isAloneTest() {
		String s = "[-895]";
		String s2 = "965-8";
		String s3 = "[-7894+698]";
		String s4 = "45";
		assertFalse(pa.isAlone(s2));
		assertTrue(pa.isAlone(s));
		assertTrue(pa.isAlone(s4));
		assertFalse(pa.isAlone(s3));	
	}
	
	@Test
	public void getRidOfParTest() {
		String s1 = "(28+9)+(52-4)";
		String s2 = "(8-9)";
		assertEquals("37+48", pa.getRidOfPar(s1));
		assertEquals("[-1]", pa.getRidOfPar(s2));
	}
	
	@Test
	public void morePartest() {
		String s1 = "(55-69)";
		String s2 = "854";
		assertTrue(ParserArithmetique.morePar(s1));
		assertFalse(ParserArithmetique.morePar(s2));
	}
	
	@Test
	public void doCalculTest() {
		String s1 = "5+8-2";
		assertEquals("11", pa.doCalcul(s1));
	}
	
	@Test
	public void doMathTest() {
		String s = pa.doMath("[-16]", "[-8]", "/");
		String s1 = pa.doMath("50", "[-8]", "+");
		assertEquals("2", s);
		assertEquals("42", s1);
	}

}
