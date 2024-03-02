package org.jfree.data.test;
import org.jfree.data.Range;
import org.junit.*;
import org.junit.Assert;

public class RangeTest {
    private Range rangeOne;
    private Range rangeTwo;
    private Range rangeThree;
    @Before
    public void setUp() {
        rangeOne = new Range(4, 8);
        rangeTwo = new Range(2, 5);

        //expand to include
        rangeThree = new Range(2, 11);
    }

    @After
    public void tearDown() {
        rangeOne = null;
        rangeTwo = null;
        rangeThree = null;
    }

    //constrain

    //TODO fails when returning value
    @Test
    public void testConstrainLessThanLowerBoundary() {
        double expected = 2.0;
        Assert.assertEquals("The value returned should be 2.0",
                expected, rangeThree.constrain(1),0.0000001d);
    }

    @Test
    public void testConstrainEqualToLowerBoundary() {
        double expected = 2.0;
        Assert.assertEquals("The value returned should be 2.0",
                expected, rangeThree.constrain(2), 0.0000001d);
    }

    @Test
    public void testConstrainBetweenLowerAndUpperBoundary() {
        double expected = 5.0;
        Assert.assertEquals("The value returned should be 5.0",
                expected, rangeThree.constrain(5), 0.0000001d);
    }

    @Test
    public void testConstrainEqualToUpperBoundary() {
        double expected = 11.0;
        Assert.assertEquals("The value returned should be 11.0",
                expected, rangeThree.constrain(11), 0.0000001d);
    }

    @Test
    public void testConstrainHigherThanUpperBoundary() {
        double expected = 11.0;
        Assert.assertEquals("The value returned should be 11.0",
                expected, rangeThree.constrain(12), 0.0000001d);
    }


    //combine method

    @Test
    public void testCombineBothValid() {
        Range expectedRange = new Range(2, 8);
        Assert.assertEquals("The combined range should return 2 and 8",
                expectedRange, Range.combine(rangeOne, rangeTwo));
    }

    @Test
    public void testCombineRangeOneValidRangeTwoNull() {
        Range expectedRange = new Range(4, 8);
        System.out.println(expectedRange);
        Assert.assertEquals("The combined range should return 4 and 8",
                expectedRange, Range.combine(rangeOne, null));
    }

    @Test
    public void testCombineRangeOneNullRangeTwoValid() {
        Range expectedRange = new Range(2, 5);
        Assert.assertEquals("The combined range should return 2 and 5",
                expectedRange, Range.combine(null, rangeTwo));
    }

    @Test
    public void testCombineBothNull() {
        Assert.assertNull("The combined range should return null",
                Range.combine(null, null));
    }

    //expand to include method

    @Test
    public void testExpandToIncludeLessThanLowerBoundary() {
        Range expectedRange = new Range(1, 11);
        Assert.assertEquals("The expanded range should return 1 and 11",
                expectedRange, Range.expandToInclude(rangeThree,1 ));
    }

    @Test
    public void testExpandToIncludeEqualToLowerBoundary() {
        Range expectedRange = new Range(2, 11);
        Assert.assertEquals("The expanded range should return 2 and 11",
                expectedRange, Range.expandToInclude(rangeThree,2 ));
    }

    @Test
    public void testExpandToIncludeEqualToUpperBoundary() {
        Range expectedRange = new Range(2, 11);
        Assert.assertEquals("The expanded range should return 2 and 11",
                expectedRange, Range.expandToInclude(rangeThree,11 ));
    }

    @Test
    public void testExpandToIncludeHigherThanUpperBoundary() {
        Range expectedRange = new Range(1, 12);
        Assert.assertEquals("The expanded range should return 2 and 12",
                expectedRange, Range.expandToInclude(rangeThree,12 ));
    }

    @Test
    public void testExpandToIncludeRangeNull() {
        Range expectedRange = new Range(5, 5);
        Assert.assertEquals("The expanded range should return 5 and 5",
                expectedRange, Range.expandToInclude(null,5 ));
    }

    //expand
    //TODO defect in the toString response
    @Test
    public void testExpandRangeValid() {
        Range expandRange = new Range(2, 6);
        Range expectedRange = new Range(1, 8);

        Assert.assertEquals("The expanded range should return 1 and 8",
                expectedRange, Range.expand(expandRange, 0.25, 0.5));
    }

    //TODO returned IllegalArgumentException
    @Test
    public void testExpandRangeNull() {
        try{
            Range.expand(null,0.25, 0.5);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalParameterException", ex.getClass().toString());
        }
    }

    //intersects

    @Test
    public void testIntersects14_18() {
        Assert.assertFalse("The value returned should be false",
                rangeThree.intersects(14,18));
    }

    //TODO both lower and upper are higher than upper bound
    @Test
    public void testIntersects11_14() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(11,14));
    }

    //TODO upper is higher than upper bound
    @Test
    public void testIntersects8_15() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(8,15));
    }
    @Test
    public void testIntersects2_14() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(2,14));
    }

    //TODO upper is less than lower bound
    @Test
    public void testIntersects0_1() {
        Assert.assertFalse("The value returned should be false",
                rangeThree.intersects(0,1));
    }

    @Test
    public void testIntersects0_2() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(0,2));
    }

    @Test
    public void testIntersects0_6() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(0,6));
    }

    @Test
    public void testIntersects0_11() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(0,11));
    }

    @Test
    public void testIntersects0_12() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(0,12));
    }
}