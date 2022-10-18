package groups;

import org.junit.Test;

public class Level3Test {

    private GradingTests tester = new GradingTests();

    @Test
    public void testCommutative1() {
        tester.testIsCommutative1();
    }

    @Test
    public void testCommutative2() {
        tester.testIsCommutative2();
    }

    @Test
    public void testCommutative3() {
        tester.testIsCommutative3();
    }

    @Test
    public void testCommutative4() {
        tester.testIsCommutative4();
    }

    @Test
    public void testSubGroup1() {
        tester.testIsSubgroup1();
    }

    @Test
    public void testSubGroup2() {
        tester.testIsSubgroup2();
    }

    @Test
    public void testSubGroup3() {
        tester.testIsSubgroup3();
    }

    @Test
    public void testSubGroup4() {
        tester.testIsSubgroup4();
    }

    @Test
    public void testImmutable1() {
        tester.testImmutability1();
    }

    @Test
    public void testImmutable2() {
        tester.testImmutability2();
    }

    @Test
    public void testImmutable3() {
        tester.testImmutability3();
    }

    @Test
    public void testImmutable4() {
        tester.testImmutability4();
    }

}
