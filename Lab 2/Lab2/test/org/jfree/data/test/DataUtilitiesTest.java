package org.jfree.data.test;
import org.jfree.data.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
    private Values2D values2D;
    private Values2D values2DNull;
    @Before
    public void setUp()
    {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        values2D = testValues;
        testValues.addValue(-6, 0, 0);
        testValues.addValue(13, 0, 1);
        testValues.addValue(42, 0, 2);
        testValues.addValue(72, 0, 3);
        testValues.addValue(0, 1, 0);
        testValues.addValue(-66, 1, 1);
        testValues.addValue(56, 1, 2);
        testValues.addValue(1024, 1, 3);

        DefaultKeyedValues2D testValues2 = new DefaultKeyedValues2D();
        values2DNull=null;

    }

    @After
    public void tearDown()
    {
        values2D = null;
    }


    //Tests for calculateRowTotal

    @Test
    public void testCalculateColumnTotalValidDataNegativeColumn()
    {
        try{
            DataUtilities.calculateColumnTotal(values2D, -66);
        } catch (Exception ex) {
            Assert.assertEquals("Index -66 out of bounds for length 4", ex.getMessage());
        }
    }

    @Test
    public void testCalculateColumnTotalBothValid()
    {
        Assert.assertEquals("calculateColumnTotal: Did not return expected output - 53",
                -53, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
    }

    @Test
    public void testCalculateColumnTotalValidDataInvalidColumn()
    {
        //out of bounds
        try{
           DataUtilities.calculateColumnTotal(values2D, 4);
        } catch (Exception ex) {
            Assert.assertEquals("Index 4 out of bounds for length 4", ex.getMessage());
        }
    }

    @Test
    public void testCalculateColumnTotalNullDataNegativeColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, -1);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateColumnTotalNullDataValidColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 0);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateColumnTotalNullDataInvalidColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 5);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }



    //Tests for calculateRowTotal
    @Test
    public void testCalculateRowTotalValidDataNegativeColumn()
    {
        try{
            DataUtilities.calculateRowTotal(values2D, -66);
        } catch (Exception ex) {
            Assert.assertEquals("Index -66 out of bounds for length 2", ex.getMessage());
        }
    }

    //TODO failing test for Sure
    @Test
    public void testCalculateRowTotalBothValid()
    {
        Assert.assertEquals("calculateRowTotal: Did not return expected output - 1014",
                1014, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
    }

    @Test
    public void testCalculateRowTotalValidDataInvalidColumn()
    {
        //out of bounds
        try{
            DataUtilities.calculateRowTotal(values2D, 4);
        } catch (Exception ex) {
            Assert.assertEquals("Index 4 out of bounds for length 2", ex.getMessage());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataNegativeColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateRowTotal(values2DNull, -1);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataValidColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateRowTotal(values2DNull, 0);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataInvalidColumn()
    {
        try {
            values2DNull = null;
            DataUtilities.calculateRowTotal(values2DNull, 5);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

   //createNumberArray

    //TODO failing test
   @Test
   public void testCreateNumberArrayValidData()
   {
       double[] validDoubleArray = {1.0, 4.0, 5.0, 6.0};
       Number[] numberArray = {1.0, 4.0, 5.0, 6.0};

       Assert.assertEquals("calculateNumberArray: Did not return expected output - {1.0, 4.0, 5.0, 6.0}",
               numberArray, DataUtilities.createNumberArray(validDoubleArray));
   }


    @Test
    public void testCreateNumberArrayNullValue()
    {
        try{
            double[] nullDoubleArray = null;
            DataUtilities.createNumberArray(nullDoubleArray);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }


    //createNumberArray2D
//TODO failing test
    @Test
    public void testCreateNumberArray2DValidData()
    {
        double[][] validDoubleArray2D = {{1.0, 4.0, 5.0, 6.0}, {7.0, 8.0, 9.0, 2.0}};
        Number[][] numberArray2D = {{1.0, 4.0, 5.0, 6.0}, {7.0, 8.0, 9.0, 2.0}};

        Assert.assertEquals("calculateNumberArray2D: Did not return expected output - {{1.0, 4.0, 5.0, 6.0}, {7.0, 8.0, 9.0, 2.0}}",
                numberArray2D, DataUtilities.createNumberArray2D(validDoubleArray2D));
    }


    @Test
    public void testCreateNumberArray2DNullValue()
    {
        try{
            double[] nullDoubleArray = null;
            DataUtilities.createNumberArray(nullDoubleArray);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    //getCumulativePercentages
//TODO failing test
    @Test
    public void testGetCumulativePercentagesValidData()
    {
        DefaultKeyedValues testValues = new DefaultKeyedValues();
        testValues.addValue("0", 5);
        testValues.addValue("1", 9);
        testValues.addValue("2", 2);

        DefaultKeyedValues expectedValues = new DefaultKeyedValues();
        expectedValues.addValue("0", 0.3125);
        expectedValues.addValue("1", 0.875);
        expectedValues.addValue("2", 1.0);

        Assert.assertEquals("getCumulativePercentages: Did not return expected output - {{1.0, 4.0, 5.0, 6.0}, {7.0, 8.0, 9.0, 2.0}}",
                expectedValues.getValue("0"), DataUtilities.getCumulativePercentages(testValues).getValue("0"));
    }

    @Test
    public void testGetCumulativePercentagesNullValue()
    {
        try{
            DefaultKeyedValues nullValues = new DefaultKeyedValues();
            nullValues=null;
            DataUtilities.getCumulativePercentages(nullValues);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }


}