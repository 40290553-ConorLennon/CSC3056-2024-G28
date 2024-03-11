package org.jfree.data;
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
        testValues.addValue(15, 2, 0);
        testValues.addValue(19, 2, 1);
        testValues.addValue(5, 2, 2);
        testValues.addValue(22, 2, 3);

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
            DataUtilities.calculateColumnTotal(values2D, -1);
        } catch (Exception ex) {
            Assert.assertEquals("Index -1 out of bounds for length 4", ex.getMessage());
        }
    }

    @Test
    public void testCalculateColumnTotalBothValidMinimum()
    {
        Assert.assertEquals("calculateColumnTotal: Did not return expected output - 9",
                9, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }

    @Test
    public void testCalculateColumnTotalBothValidMiddle()
    {
        Assert.assertEquals("calculateColumnTotal: Did not return expected output - -34",
                -34, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
    }

    @Test
    public void testCalculateColumnTotalBothValidMaximum()
    {
        Assert.assertEquals("calculateColumnTotal: Did not return expected output - 1118",
                1118, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
    }

    @Test
    public void testCalculateColumnTotalValidDataInvalidColumn()
    {
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
    public void testCalculateColumnTotalNullDataValidColumnMinimum()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 0);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateColumnTotalNullDataValidColumnMiddle()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 1);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateColumnTotalNullDataValidColumnMaximum()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 3);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }
    @Test
    public void testCalculateColumnTotalNullDataInvalidColumn()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateColumnTotal(values2DNull, 4);
        }  catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }



    //Tests for calculateRowTotal
    @Test
    public void testCalculateRowTotalValidDataNegativeColumn()
    {
        try{
            DataUtilities.calculateRowTotal(values2D, -1);
        } catch (Exception ex) {
            Assert.assertEquals("Index -1 out of bounds for length 3", ex.getMessage());
        }
    }

    @Test
    public void testCalculateRowTotalBothValidMinimum()
    {
        Assert.assertEquals("calculateRowTotal: Did not return expected output - 121",
                121, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

    @Test
    public void testCalculateRowTotalBothValidMiddle()
    {
        Assert.assertEquals("calculateRowTotal: Did not return expected output - 1014",
                1014, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
    }

    @Test
    public void testCalculateRowTotalBothValidMaximum()
    {
        Assert.assertEquals("calculateRowTotal: Did not return expected output - 61",
                61, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
    }

    @Test
    public void testCalculateRowTotalValidDataInvalidColumn()
    {
        try{
            DataUtilities.calculateRowTotal(values2D, 3);
        } catch (Exception ex) {
            Assert.assertEquals("Index 3 out of bounds for length 3", ex.getMessage());
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
    public void testCalculateRowTotalNullDataValidColumnMinimum()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateRowTotal(values2DNull, 0);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataValidColumnMiddle()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateRowTotal(values2DNull, 1);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataValidColumnMaximum()
    {
        try{
            values2DNull=null;
            DataUtilities.calculateRowTotal(values2DNull, 2);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }

    @Test
    public void testCalculateRowTotalNullDataInvalidColumn()
    {
        try {
            values2DNull = null;
            DataUtilities.calculateRowTotal(values2DNull, 3);
        } catch (Exception ex) {
            Assert.assertEquals("class java.lang.IllegalArgumentException", ex.getClass().toString());
        }
    }



   //createNumberArray
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
    @Test
    public void testGetCumulativePercentagesValidData()
    {
        DefaultKeyedValues testValues = new DefaultKeyedValues();
        testValues.addValue("0", 5);
        testValues.addValue("1", 9);
        testValues.addValue("2", 2);

        Number[] expected = {0.3125, 0.875, 1.0};

        Number[] result = new Number[3];
        result[0] =  DataUtilities.getCumulativePercentages(testValues).getValue("0");
        result[1] =  DataUtilities.getCumulativePercentages(testValues).getValue("1");
        result[2] =  DataUtilities.getCumulativePercentages(testValues).getValue("2");


        Assert.assertEquals("getCumulativePercentages: Did not return expected output - {0.3125, 0.875, 1.0}",
                expected, result);
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