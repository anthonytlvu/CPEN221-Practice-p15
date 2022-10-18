package groups;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class GradingTests {

	/*
	 * This method creates a group with the following product table.
	 *         x1 	 x2	   x3
	 *       -----------------
	 *    x1 | x2    x3    x1
	 *       |    
	 *    x2 | x3    x1    x2
	 *       | 
	 *    x3 | x1    x2    x3
	 * */
	private ProbableGroup makeGp1() {
		Set<String> elts = new HashSet<String>();
		elts.add("x1");
		elts.add("x2");
		elts.add("x3");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("x1",  "x1"), "x2");
		productMap.put(new Pair<String>("x1",  "x2"), "x3");
		productMap.put(new Pair<String>("x1",  "x3"), "x1");
		productMap.put(new Pair<String>("x2",  "x1"), "x3");
		productMap.put(new Pair<String>("x2",  "x2"), "x1");
		productMap.put(new Pair<String>("x2",  "x3"), "x2");
		productMap.put(new Pair<String>("x3",  "x1"), "x1");
		productMap.put(new Pair<String>("x3",  "x2"), "x2");
		productMap.put(new Pair<String>("x3",  "x3"), "x3");
		
		ProbableGroup gp1 = new ProbableGroup(elts, productMap); 
		return gp1;
	}
    
	/*
	 * This method creates a group with the following product table.
	 * 	 
	 *        a	  b
	 *       -------
	 *    a | a   b   
	 *      |    
	 *    b | a   a   
	 * */
	private ProbableGroup makeGp2() {
		
		Set<String> elts = new HashSet<String>();
		elts.add("a");
		elts.add("b");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("a", "a"), "a");
		productMap.put(new Pair<String>("a", "b"), "b");
		productMap.put(new Pair<String>("b", "a"), "a");
		productMap.put(new Pair<String>("b", "b"), "a");
		
		ProbableGroup gp2 = new ProbableGroup(elts, productMap); 
		return gp2;
	}
	
	/*
	 * This method creates a group with the following product table.
	 *         x1	 x2	   x3    x4
 	 *       -----------------------
	 *    x1 | x1    x2    x3    x4
	 *       |    
	 *    x2 | x2    x3    x4    x1
	 *       | 
	 *    x3 | x3    x4    x1    x2
	 *       |
	 *    x4 | x4    x1    x2    x3
	 * */
	private ProbableGroup makeGp3() {
		
		Set<String> elts = new HashSet<String>();
		elts.add("x1");
		elts.add("x2");
		elts.add("x3");
		elts.add("x4");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("x1",  "x1"), "x1");
		productMap.put(new Pair<String>("x1",  "x2"), "x2");
		productMap.put(new Pair<String>("x1",  "x3"), "x3");
		productMap.put(new Pair<String>("x1",  "x4"), "x4");
		productMap.put(new Pair<String>("x2",  "x1"), "x2");
		productMap.put(new Pair<String>("x2",  "x2"), "x3");
		productMap.put(new Pair<String>("x2",  "x3"), "x4");
		productMap.put(new Pair<String>("x2",  "x4"), "x1");
		productMap.put(new Pair<String>("x3",  "x1"), "x3");
		productMap.put(new Pair<String>("x3",  "x2"), "x4");
		productMap.put(new Pair<String>("x3",  "x3"), "x1");
		productMap.put(new Pair<String>("x3",  "x4"), "x2");
		productMap.put(new Pair<String>("x4",  "x1"), "x4");
		productMap.put(new Pair<String>("x4",  "x2"), "x1");
		productMap.put(new Pair<String>("x4",  "x3"), "x2");
		productMap.put(new Pair<String>("x4",  "x4"), "x3");
		
		ProbableGroup gp3 = new ProbableGroup(elts, productMap); 
		return gp3;
	}
	
	/*
	 * This method creates a group with the following product table.
	 * 	 
	 *        a	  b
	 *       -------
	 *    a | a   b   
	 *      |    
	 *    b | b   b   
	 * */
	private ProbableGroup makeGp4() {
		
		Set<String> elts = new HashSet<String>();
		elts.add("a");
		elts.add("b");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("a", "a"), "a");
		productMap.put(new Pair<String>("a", "b"), "b");
		productMap.put(new Pair<String>("b", "a"), "b");
		productMap.put(new Pair<String>("b", "b"), "b");
		
		ProbableGroup gp4 = new ProbableGroup(elts, productMap); 
		return gp4;
	}
	/*
     Element	|	()			(1, 2)		(2, 3)		(1, 3)		(1, 2, 3)	(1, 3, 2)
     ---------------------------------------------------------------------------------
     ()			|	()	    	(1, 2)		(2, 3)		(1, 3)		(1, 2, 3)	(1, 3, 2)
     (1, 2)	    |	(1, 2)		()			(1, 2, 3)	(1, 3, 2)	(2, 3)		(1, 3)
     (2, 3)	    |	(2, 3)		(1, 3, 2)	()			(1, 2, 3)	(1, 3)		(1, 2)
     (1, 3)	    |	(1, 3)		(1, 2, 3)	(1, 3, 2)	()			(1, 2)		(2, 3)
     (1, 2, 3)	|	(1, 2, 3)	(1, 3)		(1, 2)		(2, 3)		(1, 3, 2)	()
     (1, 3, 2)	|	(1, 3, 2)	(2, 3)		(1, 3)		(1, 2)		()			(1, 2, 3)
     */
	private ProbableGroup makeGp5() {
		
		Set<String> elts = new HashSet<String>();
		elts.add("()");
		elts.add("(1,2)");
		elts.add("(2,3)");
		elts.add("(1,3)");
		elts.add("(1,2,3)");
		elts.add("(1,3,2)");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("()", "()"), "()");
		productMap.put(new Pair<String>("()", "(1,2)"), "(1,2)");
		productMap.put(new Pair<String>("()", "(2,3)"), "(2,3)");
		productMap.put(new Pair<String>("()", "(1,3)"), "(1,3)");
		productMap.put(new Pair<String>("()", "(1,2,3)"), "(1,2,3)");
		productMap.put(new Pair<String>("()", "(1,3,2)"), "(1,3,2)");
		
		productMap.put(new Pair<String>("(1,2)", "()"), "(1,2)");
		productMap.put(new Pair<String>("(1,2)", "(1,2)"), "()");
		productMap.put(new Pair<String>("(1,2)", "(2,3)"), "(1,2,3)");
		productMap.put(new Pair<String>("(1,2)", "(1,3)"), "(1,3,2)");
		productMap.put(new Pair<String>("(1,2)", "(1,2,3)"), "(2,3)");
		productMap.put(new Pair<String>("(1,2)", "(1,3,2)"), "(1,3)");
		
		productMap.put(new Pair<String>("(2,3)", "()"), "(2,3)");
		productMap.put(new Pair<String>("(2,3)", "(1,2)"), "(1,3,2)");
		productMap.put(new Pair<String>("(2,3)", "(2,3)"), "()");
		productMap.put(new Pair<String>("(2,3)", "(1,3)"), "(1,2,3)");
		productMap.put(new Pair<String>("(2,3)", "(1,2,3)"), "(1,3)");
		productMap.put(new Pair<String>("(2,3)", "(1,3,2)"), "(1,2)");
		
		productMap.put(new Pair<String>("(1,3)", "()"), "(1,3)");
		productMap.put(new Pair<String>("(1,3)", "(1,2)"), "(1,2,3)");
		productMap.put(new Pair<String>("(1,3)", "(2,3)"), "(1,3,2)");
		productMap.put(new Pair<String>("(1,3)", "(1,3)"), "()");
		productMap.put(new Pair<String>("(1,3)", "(1,2,3)"), "(1,2)");
		productMap.put(new Pair<String>("(1,3)", "(1,3,2)"), "(2,3)");
		
		productMap.put(new Pair<String>("(1,2,3)", "()"), "(1,2,3)");
		productMap.put(new Pair<String>("(1,2,3)", "(1,2)"), "(1,3)");
		productMap.put(new Pair<String>("(1,2,3)", "(2,3)"), "(1,2)");
		productMap.put(new Pair<String>("(1,2,3)", "(1,3)"), "(2,3)");
		productMap.put(new Pair<String>("(1,2,3)", "(1,2,3)"), "(1,3,2)");
		productMap.put(new Pair<String>("(1,2,3)", "(1,3,2)"), "()");
		
		productMap.put(new Pair<String>("(1,3,2)", "()"), "(1,3,2)");
		productMap.put(new Pair<String>("(1,3,2)", "(1,2)"), "(2,3)");
		productMap.put(new Pair<String>("(1,3,2)", "(2,3)"), "(1,3)");
		productMap.put(new Pair<String>("(1,3,2)", "(1,3)"), "(1,2)");
		productMap.put(new Pair<String>("(1,3,2)", "(1,2,3)"), "()");
		productMap.put(new Pair<String>("(1,3,2)", "(1,3,2)"), "(1,2,3)");
		
		ProbableGroup gp5 = new ProbableGroup(elts, productMap); 
		return gp5;
	}

	public void testProduct1() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x3", gp1.product("x1", "x2"));
	}

	public void testProduct2() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x2", gp1.product("x3", "x2"));
	}

	public void testProduct3() {
		ProbableGroup gp2 = makeGp2();
		assertEquals("b", gp2.product("a", "b"));
	}

	public void testProduct4() {
		ProbableGroup gp2 = makeGp2();
		assertEquals("a", gp2.product("b", "a"));
	}

	public void testIdentity1() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x3", gp1.getIdentity());
	}

	public void testIdentity2() {
		ProbableGroup gp2 = makeGp2();
		assertEquals("", gp2.getIdentity());
	}

	public void testIdentity3() {
		ProbableGroup gp3 = makeGp3();
		assertEquals("x1", gp3.getIdentity());
	}

	public void testInverse1() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x1", gp1.getInverse("x2"));
	}

	public void testInverse2() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x3", gp1.getInverse("x3"));
	}

	public void testInverse3() {
		ProbableGroup gp2 = makeGp2();
		assertEquals("", gp2.getInverse("b"));
	}

	public void testInverse4() {
		ProbableGroup gp3 = makeGp3();
		assertEquals("x4", gp3.getInverse("x2"));
	}

	public void testPower1() {
		ProbableGroup gp1 = makeGp1();
		assertEquals("x2", gp1.power("x1", 5));
	}

	public void testPower2() {
		ProbableGroup gp2 = makeGp2();
		assertEquals("a", gp2.power("b", 10));
	}

	public void testPower3() {
		ProbableGroup gp3 = makeGp3();
		assertEquals("x1", gp3.power("x3", 6));
	}

	public void testOrder1() {
		ProbableGroup gp1 = makeGp1();
		assertEquals(1, gp1.order("x3"));
	}

	public void testOrder2() {
		ProbableGroup gp3 = makeGp3();
		assertEquals(4, gp3.order("x2"));
	}

	public void testOrder3() {
		ProbableGroup gp3 = makeGp3();
		assertEquals(2, gp3.order("x3"));
	}

	public void testIsGroup1() {
		ProbableGroup gp1 = makeGp1();
		assertTrue(gp1.isGroup());
	}

	public void testIsGroup2() {
		ProbableGroup gp3 = makeGp3();
		assertTrue(gp3.isGroup());
	}

	public void testIsGroup3() {
		ProbableGroup gp2 = makeGp2();
		assertFalse(gp2.isGroup());
	}

	public void testIsGroup4() {
		ProbableGroup gp4 = makeGp4();
		assertFalse(gp4.isGroup());
	}

	public void testIsCommutative1() {
		ProbableGroup gp1 = makeGp1();
		assertTrue(gp1.isCommutative());
	}

	public void testIsCommutative2() {
		ProbableGroup gp2 = makeGp2();
		assertFalse(gp2.isCommutative());
	}

	public void testIsCommutative3() {
		ProbableGroup gp3 = makeGp3();
		assertTrue(gp3.isCommutative());
	}

	public void testIsCommutative4() {
		ProbableGroup gp5 = makeGp5();
		assertFalse(gp5.isCommutative());
	}

	public void testIsSubgroup1() {
		ProbableGroup gp1 = makeGp1();
		Set<String> h = new HashSet<String>();
		
		h.add("x3");
		assertTrue(gp1.isSubgroup(h));
	}

	public void testIsSubgroup2() {
		ProbableGroup gp1 = makeGp1();
		Set<String> h = new HashSet<String>();
		h.add("x1");
		h.add("x2");
		h.add("x3");
		assertTrue(gp1.isSubgroup(h));
	}

	public void testIsSubgroup3() {
		ProbableGroup gp3 = makeGp3();
		Set<String> h = new HashSet<String>();
		h.add("x1");
		h.add("x2");
		h.add("x3");
		assertFalse(gp3.isSubgroup(h));
	}

	public void testIsSubgroup4() {
		ProbableGroup gp3 = makeGp3();
		Set<String> h = new HashSet<String>();
		h.add("x2");
		h.add("x3");
		assertFalse(gp3.isSubgroup(h));
	}

	public void testIsSubgroup5() {
		ProbableGroup gp5 = makeGp5();
		Set<String> h = new HashSet<String>();
		h.add("()");
		h.add("(1,2,3)");
		h.add("(1,3,2)");
		assertTrue(gp5.isSubgroup(h));
	}

	public void testImmutability1() {
		Set<String> elts = new HashSet<String>();
		elts.add("a");
		elts.add("b");
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("a", "a"), "a");
		productMap.put(new Pair<String>("a", "b"), "b");
		productMap.put(new Pair<String>("b", "a"), "a");
		productMap.put(new Pair<String>("b", "b"), "a");
		
		ProbableGroup gp1 = new ProbableGroup(elts, productMap); 
		
		productMap.put(new Pair<String>("b", "b"), "b");
		assertEquals("a", gp1.product("b", "b"));
	}

	public void testImmutability2() {
		Set<String> elts = new HashSet<String>();
		elts.add("a");
		elts.add("b");
		
		Set<String> copyElts = new HashSet<String>(elts);
		
		Map<Pair<String>, String> productMap = new HashMap<Pair<String>, String>();
		
		productMap.put(new Pair<String>("a", "a"), "a");
		productMap.put(new Pair<String>("a", "b"), "b");
		productMap.put(new Pair<String>("b", "a"), "a");
		productMap.put(new Pair<String>("b", "b"), "a");
		
		ProbableGroup gp1 = new ProbableGroup(elts, productMap); 
		
		assertEquals(copyElts, gp1.getElements());
	}

	public void testImmutability3() {
		ProbableGroup gp3 = makeGp3();
		
		Set<String> elts = gp3.getElements();
		Set<String> copyElts = new HashSet<String>(elts);

		elts.add("x");
		assertEquals(copyElts, gp3.getElements());
	}

	public void testImmutability4() {
		ProbableGroup gp3 = makeGp3();
		
		Map<Pair<String>, String> productTable = gp3.getOpTable();
		Map<Pair<String>, String> copyPT = new HashMap<Pair<String>, String>(productTable);

		productTable.put(new Pair("AA", "BB"), "CC");
		assertEquals(copyPT, gp3.getOpTable());
	}
	
	
	

}
