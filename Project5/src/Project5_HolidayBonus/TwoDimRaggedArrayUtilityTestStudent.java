package Project5_HolidayBonus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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



public class TwoDimRaggedArrayUtilityTestStudent {
	
	 private double[][] data;

	    // File path to the test data
	    private String filePath;

	    // Set up method to load the appropriate dataset before each test
	    @BeforeEach
	    public void setUp() throws IOException {
	        // Use the different data files for each test
	        // For the purpose of this test, you can update this to switch datasets
	        filePath = "dataSet1.txt";  // Change this to test different datasets like dataSet2.txt, dataSet3.txt, etc.
	        data = TwoDimRaggedArrayUtility.readFile(new File(filePath));
	    }

	    @Test
	    public void testGetTotal() {
	        // The total should be the sum of all elements in the dataset
	        // For dataSet1.txt (1 2 3, 4 5, 6 7 8)
	        double expectedTotal = 1.0 + 2.0 + 3.0 + 4.0 + 5.0 + 6.0 + 7.0 + 8.0;
	        double actualTotal = TwoDimRaggedArrayUtility.getTotal(data);
	        assertEquals(expectedTotal, actualTotal, "The total should match the sum of all elements.");
	    }

	    @Test
	    public void testGetAverage() {
	        // For dataSet1.txt, sum is 36.0, and the number of elements is 8, so the average should be 36 / 8
	        double expectedAverage = 36.0 / 8;
	        double actualAverage = TwoDimRaggedArrayUtility.getAverage(data);
	        assertEquals(expectedAverage, actualAverage, 0.0001, "The average should match the expected value.");
	    }

	    @Test
	    public void testGetRowTotal() {
	        // For dataSet1.txt, row 1 (index 0) contains [1.0, 2.0, 3.0], so the total should be 6.0
	        double expectedRowTotal = 6.0;
	        double actualRowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
	        assertEquals(expectedRowTotal, actualRowTotal, "Row total should match the expected sum.");
	    }

	    @Test
	    public void testGetColumnTotal() {
	        // For dataSet1.txt, column 1 (index 0) contains [1.0, 4.0, 6.0], so the total should be 11.0
	        double expectedColumnTotal = 1.0 + 4.0 + 6.0;
	        double actualColumnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
	        assertEquals(expectedColumnTotal, actualColumnTotal, "Column total should match the expected sum.");
	    }

	    @Test
	    public void testGetHighestInArray() {
	        // For dataSet1.txt, the highest value in the entire array is 8.0
	        double expectedHighest = 8.0;
	        double actualHighest = TwoDimRaggedArrayUtility.getHighestInArray(data);
	        assertEquals(expectedHighest, actualHighest, "The highest value in the array should be 8.0.");
	    }

	    @Test
	    public void testGetHighestInRow() {
	        // For dataSet1.txt, row 3 (index 2) contains [6.0, 7.0, 8.0], and the highest value is 8.0
	        double expectedHighestInRow = 8.0;
	        double actualHighestInRow = TwoDimRaggedArrayUtility.getHighestInRow(data, 2);
	        assertEquals(expectedHighestInRow, actualHighestInRow, "The highest value in row 3 should be 8.0.");
	    }

	    @Test
	    public void testGetHighestInRowIndex() {
	        // For dataSet1.txt, the highest value in row 3 (index 2) is 8.0, which is at index 2
	        int expectedIndex = 2;
	        int actualIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2);
	        assertEquals(expectedIndex, actualIndex, "The index of the highest value in row 3 should be 2.");
	    }

	    @Test
	    public void testGetLowestInArray() {
	        // For dataSet1.txt, the lowest value in the entire array is 1.0
	        double expectedLowest = 1.0;
	        double actualLowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
	        assertEquals(expectedLowest, actualLowest, "The lowest value in the array should be 1.0.");
	    }

	    @Test
	    public void testGetLowestInRow() {
	        // For dataSet1.txt, the lowest value in row 1 (index 0) is 1.0
	        double expectedLowestInRow = 1.0;
	        double actualLowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(data, 0);
	        assertEquals(expectedLowestInRow, actualLowestInRow, "The lowest value in row 1 should be 1.0.");
	    }

	    @Test
	    public void testGetLowestInRowIndex() {
	        // For dataSet1.txt, the lowest value in row 2 (index 1) is 4.0, which is at index 0
	        int expectedIndex = 0;
	        int actualIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
	        assertEquals(expectedIndex, actualIndex, "The index of the lowest value in row 2 should be 0.");
	    }

	    @Test
	    public void testGetLowestInColumn() {
	        // For dataSet1.txt, the lowest value in column 1 (index 0) is 1.0
	        double expectedLowestInColumn = 1.0;
	        double actualLowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);
	        assertEquals(expectedLowestInColumn, actualLowestInColumn, "The lowest value in column 1 should be 1.0.");
	    }

	    @Test
	    public void testGetLowestInColumnIndex() {
	        // For dataSet1.txt, the lowest value in column 1 (index 0) is 1.0, which is at index 0
	        int expectedIndex = 0;
	        int actualIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0);
	        assertEquals(expectedIndex, actualIndex, "The index of the lowest value in column 1 should be 0.");
	    }

	    @Test
	    public void testReadFile() throws FileNotFoundException {
	        // Test reading from an actual file
	        File file = new File(filePath);
	        double[][] readData = TwoDimRaggedArrayUtility.readFile(file);
	        
	        // Validate that the data was read correctly from the file
	        assertNotNull(readData, "The data read from the file should not be null.");
	        assertEquals(3, readData.length, "The data should have 3 rows.");
	        assertEquals(3, readData[0].length, "Row 1 should have 3 elements.");
	        assertEquals(2, readData[1].length, "Row 2 should have 2 elements.");
	        assertEquals(4, readData[2].length, "Row 3 should have 4 elements.");
	    }

	    @Test
	    public void testWriteToFile() throws FileNotFoundException {
	        // Test writing to a file
	        File outputFile = new File("output_data.txt");
	        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);
	        assertTrue(outputFile.exists(), "The output file should be created.");
	        
	       
	    }
}
