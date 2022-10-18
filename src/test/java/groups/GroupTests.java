package groups;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class GroupTests {
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

        productMap.put(new Pair<String>("x1", "x1"), "x2");
        productMap.put(new Pair<String>("x1", "x2"), "x3");
        productMap.put(new Pair<String>("x1", "x3"), "x1");
        productMap.put(new Pair<String>("x2", "x1"), "x3");
        productMap.put(new Pair<String>("x2", "x2"), "x1");
        productMap.put(new Pair<String>("x2", "x3"), "x2");
        productMap.put(new Pair<String>("x3", "x1"), "x1");
        productMap.put(new Pair<String>("x3", "x2"), "x2");
        productMap.put(new Pair<String>("x3", "x3"), "x3");

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

        productMap.put(new Pair<String>("x1", "x1"), "x1");
        productMap.put(new Pair<String>("x1", "x2"), "x2");
        productMap.put(new Pair<String>("x1", "x3"), "x3");
        productMap.put(new Pair<String>("x1", "x4"), "x4");
        productMap.put(new Pair<String>("x2", "x1"), "x2");
        productMap.put(new Pair<String>("x2", "x2"), "x3");
        productMap.put(new Pair<String>("x2", "x3"), "x4");
        productMap.put(new Pair<String>("x2", "x4"), "x1");
        productMap.put(new Pair<String>("x3", "x1"), "x3");
        productMap.put(new Pair<String>("x3", "x2"), "x4");
        productMap.put(new Pair<String>("x3", "x3"), "x1");
        productMap.put(new Pair<String>("x3", "x4"), "x2");
        productMap.put(new Pair<String>("x4", "x1"), "x4");
        productMap.put(new Pair<String>("x4", "x2"), "x1");
        productMap.put(new Pair<String>("x4", "x3"), "x2");
        productMap.put(new Pair<String>("x4", "x4"), "x3");

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

    @Test
    public void testProduct1() {
        ProbableGroup gp1 = makeGp1();
        assertEquals("x3", gp1.product("x1", "x2"));
    }

    @Test
    public void testProduct2() {
        ProbableGroup gp1 = makeGp1();
        assertEquals("x2", gp1.product("x3", "x2"));
    }

    @Test
    public void testProduct3() {
        ProbableGroup gp2 = makeGp2();
        assertEquals("b", gp2.product("a", "b"));
    }

    @Test
    public void testIdentity1() {
        ProbableGroup gp1 = makeGp1();
        assertEquals("x3", gp1.getIdentity());
    }

    @Test
    public void testIdentity2() {
        ProbableGroup gp2 = makeGp2();
        assertEquals("", gp2.getIdentity());
    }

    @Test
    public void testInverse1() {
        ProbableGroup gp2 = makeGp2();
        assertEquals("", gp2.getInverse("b"));
    }

    @Test
    public void testInverse2() {
        ProbableGroup gp3 = makeGp3();
        assertEquals("x4", gp3.getInverse("x2"));
    }

    @Test
    public void testPower1() {
        ProbableGroup gp1 = makeGp1();
        assertEquals("x2", gp1.power("x1", 5));
    }

    @Test
    public void testPower2() {
        ProbableGroup gp2 = makeGp2();
        assertEquals("a", gp2.power("b", 10));
    }

    @Test
    public void testOrder1() {
        ProbableGroup gp1 = makeGp1();
        assertEquals(1, gp1.order("x3"));
    }

    @Test
    public void testOrder2() {
        ProbableGroup gp2 = makeGp3();
        assertEquals(4, gp2.order("x2"));
    }

    @Test
    public void testIsGroup1() {
        ProbableGroup gp1 = makeGp1();
        assertTrue(gp1.isGroup());
    }

    @Test
    public void testIsGroup2() {
        ProbableGroup gp3 = makeGp3();
        assertTrue(gp3.isGroup());
    }

    @Test
    public void testIsGroup3() {
        ProbableGroup gp2 = makeGp2();
        assertFalse(gp2.isGroup());
    }

    @Test
    public void testIsCommutative1() {
        ProbableGroup gp1 = makeGp1();
        assertTrue(gp1.isCommutative());
    }

    @Test
    public void testIsCommutative2() {
        ProbableGroup gp2 = makeGp2();
        assertFalse(gp2.isCommutative());
    }
}