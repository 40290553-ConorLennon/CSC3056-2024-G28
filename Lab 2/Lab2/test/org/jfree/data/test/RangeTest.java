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
        rangeThree = new Range(2, 11);
    }

    @After
    public void tearDown() {
        rangeOne = null;
        rangeTwo = null;
        rangeThree = null;
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
    public void testExpandToIncludeMiddleBoundary() {
        Range expectedRange = new Range(2, 11);
        Assert.assertEquals("The expanded range should return 2 and 11",
                expectedRange, Range.expandToInclude(null,6 ));
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
    public void testExpandToIncludeRangeNullLessThanLowerBoundary() {
        Range expectedRange = new Range(1, 1);
        Assert.assertEquals("The expanded range should return 1 and 1",
                expectedRange, Range.expandToInclude(null,1 ));
    }

    @Test
    public void testExpandToIncludeRangeNullEqualToLowerBoundary() {
        Range expectedRange = new Range(2, 2);
        Assert.assertEquals("The expanded range should return 2 and 2",
                expectedRange, Range.expandToInclude(null,2 ));
    }

    @Test
    public void testExpandToIncludeRangeNullMiddleBoundary() {
        Range expectedRange = new Range(6, 6);
        Assert.assertEquals("The expanded range should return 6 and 6",
                expectedRange, Range.expandToInclude(null,6 ));
    }

    @Test
    public void testExpandToIncludeRangeNullEqualToUpperBoundary() {
        Range expectedRange = new Range(11, 11);
        Assert.assertEquals("The expanded range should return 11 and 11",
                expectedRange, Range.expandToInclude(null,11 ));
    }

    @Test
    public void testExpandToIncludeRangeNullHigherThanUpperBoundary() {
        Range expectedRange = new Range(12, 12);
        Assert.assertEquals("The expanded range should return 12 and 12",
                expectedRange, Range.expandToInclude(null,12 ));
    }

    //expand
    @Test
    public void testExpandRangeValid() {
        Range expandRange = new Range(2, 6);
        Range expectedRange = new Range(1, 8);

        Assert.assertEquals("The expanded range should return 1 and 8",
                expectedRange, Range.expand(expandRange, 0.25, 0.5));
    }

    @Test
    public void testExpandRangeNull() {
        try{
            Range.expand(null,0.25, 0.5);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalParameterException", ex.getClass().toString());
        }
    }

    //constrain
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
    public void testConstrainMiddleBoundary() {
        double expected = 6.0;
        Assert.assertEquals("The value returned should be 6.0",
                expected, rangeThree.constrain(6), 0.0000001d);
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

    //intersects
    @Test
    public void testIntersectsLowerGreaterThanUpper_UpperGreaterThanUpper() {
        Assert.assertFalse("The value returned should be false",
                rangeThree.intersects(12,13));
    }

    @Test
    public void testIntersectsLowerEqualToUpper_UpperGreaterThanUpper() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(11,12));
    }

    @Test
    public void testIntersectsLowerMiddle_UpperGreaterThanUpper() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(6,12));
    }
    @Test
    public void testIntersectsLowerEqualToLower_UpperGreaterThanUpper() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(2,12));
    }

    @Test
    public void testIntersectsLowerLessThanLower_UpperLessThanLower() {
        Assert.assertFalse("The value returned should be false",
                rangeThree.intersects(0,1));
    }

    @Test
    public void testIntersectsLowerLessThanLower_UpperEqualToLower() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(1,2));
    }

    @Test
    public void testIntersectsLowerLessThanLower_UpperMiddle() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(1,6));
    }

    @Test
    public void testIntersectsLowerLessThanLower_UpperEqualToUpper() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(1,11));
    }

    @Test
    public void testIntersectsLowerLessThanLower_UpperGreaterThanUpper() {
        Assert.assertTrue("The value returned should be true",
                rangeThree.intersects(1,12));
    }
}