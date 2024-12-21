package Project5_HolidayBonus;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This project aims to create a sales report to calculate holiday bonuses using ragged arrays.
 * Due: 12/20/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: __Victoria Moody________
*/


public class HolidayBonusTestStudent {
	
	 private double[][] storeSales;

	    // Set up method to load the data before each test
	    @BeforeEach
	    public void setUp() throws FileNotFoundException {
	        // Use the data from the 'dataSet1.txt' file for testing
	        File file = new File("dataSet1.txt"); // Path to the dataset
	        storeSales = TwoDimRaggedArrayUtility.readFile(file);
	    }

	    // Test for calculateHolidayBonus using an external file (using TwoDimRaggedArrayUtility to read file)
	    @Test
	    public void testCalculateHolidayBonusFromFile() throws FileNotFoundException {
	        // Read sales data from file using TwoDimRaggedArrayUtility's readFile method
	        File file = new File("dataSet1.txt"); // Update with correct file path
	        storeSales = TwoDimRaggedArrayUtility.readFile(file);

	        // Calculate the holiday bonus for each store
	        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(storeSales);

	        // Define expected values (For example purposes)
	        double[] expectedBonuses = { 210.0, 50.0, 50.0 }; // Example expected bonuses

	        // Assert that the actual bonus values are correct
	        assertArrayEquals(expectedBonuses, actualBonuses, "Holiday bonuses should match the expected values.");
	    }

	    // Test for calculateTotalHolidayBonus using an external file (using TwoDimRaggedArrayUtility to read file)
	    @Test
	    public void testCalculateTotalHolidayBonusFromFile() throws FileNotFoundException {
	        // Path to the sample file containing sales data (dataSet2)
	        File file = new File("dataSet2.txt"); // Update with correct file path

	        // Read sales data from file using TwoDimRaggedArrayUtility's readFile method
	        storeSales = TwoDimRaggedArrayUtility.readFile(file);

	        // Calculate the total holiday bonus for all stores
	        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(storeSales);

	        // Define the expected total bonus (sum of bonuses)
	        double expectedTotalBonus = 900.0 + 400.0 + 600.0 + 300.0; // Example total bonus sum

	        // Assert that the calculated total bonus matches the expected total bonus
	        assertEquals(expectedTotalBonus, actualTotalBonus, 0.0001, "Total holiday bonus should match the expected value.");
	    }

	   

	    // Test for calculateHolidayBonus with zero sales (using TwoDimRaggedArrayUtility)
	    @Test
	    public void testCalculateHolidayBonusZeroSales() throws FileNotFoundException {
	        // Path to a file with zero sales data
	        File zeroSalesFile = new File("dataSetStudent.txt"); // All sales are 0

	        // Read sales data from file using TwoDimRaggedArrayUtility's readFile method
	        double[][] zeroSalesData = TwoDimRaggedArrayUtility.readFile(zeroSalesFile);

	        // Calculate the holiday bonuses (should be zero for all stores)
	        double[] actualZeroSalesBonuses = HolidayBonus.calculateHolidayBonus(zeroSalesData);

	        // Define the expected bonuses (all zero since there are no sales)
	        double[] expectedZeroSalesBonuses = {0.0, 0.0, 0.0};

	        // Assert that the actual bonuses match the expected bonuses (all zero)
	        assertArrayEquals(expectedZeroSalesBonuses, actualZeroSalesBonuses, "The holiday bonuses for stores with zero sales should all be 0.");
	    }

	   

	   
}
