package tests;

import junit.framework.TestCase;
import main.Valores;

public class TestValores extends TestCase {
	private Valores val;

	protected void setUp() throws Exception {
		super.setUp();
		val = new Valores();
		val.ins(5);
		val.ins(12);
		val.ins(1);
		val.ins(30);
		val.ins(152);
		val.ins(6);
	}

	public void testIns() {
		assertEquals(false, val.ins(-10));
		assertEquals(false, val.ins(0));
		val.ins(2);
		assertEquals(7, val.size());
		val.ins(3);
		assertEquals(8, val.size());
		val.ins(4);
		assertEquals(9, val.size());
		val.ins(5);
		assertEquals(10, val.size());
		assertEquals(false, val.ins(11));
	}

	public void testDel() {
		assertEquals(5, val.del(0));
		assertEquals(152, val.del(4));
		assertEquals(-1, val.del(4));
		assertEquals(-1, val.del(0));
		val.del(1);
		val.del(2);
		val.del(3);
		val.del(5);
		assertEquals(-1, val.del(0));
	}

	public void testGreater() {
		assertEquals(152, val.greater());
		val.del(4);
		assertEquals(30, val.greater());
		val.del(3);
		assertEquals(12, val.greater());
		val.del(1);
		assertEquals(6, val.greater());
		val.del(5);
		assertEquals(5, val.greater());
		val.del(0);
		assertEquals(1, val.greater());
		val.del(2);
		assertEquals(-1, val.greater());	
	}
	
	public void testMean() {
		assertEquals(20.6, val.mean());
		val.del(0);
		val.del(1);
		val.del(2);
		val.del(3);
		val.del(4);
		val.del(5);
		assertEquals(-1.0, val.mean());
	}

	public void testLower() {
		assertEquals(1, val.lower());
		val.del(0);
		val.del(1);
		val.del(2);
		val.del(3);
		val.del(4);
		val.del(5);
		assertEquals(-1, val.lower());	
	}
}
