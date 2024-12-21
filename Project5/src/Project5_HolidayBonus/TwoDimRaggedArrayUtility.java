package Project5_HolidayBonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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

public final class TwoDimRaggedArrayUtility {

	 // Constructor
    public TwoDimRaggedArrayUtility() {}

    // Method to get the total of all elements in the array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    // Method to get the average of all elements in the array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count += data[i].length;
        }
        return count == 0 ? 0 : total / count;
    }

    // Method to get the total of a particular row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        if (row >= 0 && row < data.length) {
            for (int i = 0; i < data[row].length; i++) {
                total += data[row][i];
            }
        }
        return total;
    }

    // Method to get the total of a particular column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                total += data[i][col];
            }
        }
        return total;
    }

    // Method to get the highest value in the array
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }
        return highest;
    }

    // Method to get the highest value in a particular row
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length) return Double.NEGATIVE_INFINITY;

        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
            }
        }
        return highest;
    }

    // Method to get the index of the highest value in a particular row
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length) return -1;

        int index = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Method to get the highest value in a particular column
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
            }
        }
        return highest;
    }

    // Method to get the index of the highest value in a particular column
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Method to get the lowest value in the array
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        return lowest;
    }

    // Method to get the lowest value in a particular row
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length) return Double.POSITIVE_INFINITY;

        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
            }
        }
        return lowest;
    }

    // Method to get the index of the lowest value in a particular row
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length) return -1;

        int index = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Method to get the lowest value in a particular column
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
            }
        }
        return lowest;
    }

    // Method to get the index of the lowest value in a particular column
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Method to read the sales data from a file into a ragged array
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double[][] data = new double[10][];
        int row = 0;

        while (scanner.hasNextLine() && row < 10) {
            String[] line = scanner.nextLine().split(" ");
            data[row] = new double[line.length];
            for (int col = 0; col < line.length; col++) {
                data[row][col] = Double.parseDouble(line[col]);
            }
            row++;
        }
        scanner.close();
        // Create a new array of the correct size based on the rows used
        double[][] validData = new double[row][];
        System.arraycopy(data, 0, validData, 0, row);
        return validData;
    }

    // Method to write the sales data from a ragged array to a file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j] + " ");
            }
            writer.println();
        }
        writer.close();
    }
}
