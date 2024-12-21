package Project5_HolidayBonus;

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


public class HolidayBonus {
	
	// Constructor
    public HolidayBonus() {
        // No specific initialization needed for this class
    }

    /**
     * Calculates the holiday bonus for each store.
     * 
     * @param data A two-dimensional array of store sales, where each row represents a store,
     *             and each column represents a sale for that store.
     * @return An array of the bonus for each store.
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        // Array to hold the holiday bonus for each store
        double[] bonuses = new double[data.length];

        // Loop through each store (each row in the data)
        for (int i = 0; i < data.length; i++) {
            double totalSales = 0;
            
            // Sum up the sales for the current store
            for (int j = 0; j < data[i].length; j++) {
                totalSales += data[i][j];
            }
            
            // Calculate the holiday bonus for this store
            // For simplicity, we assume the bonus is 5% of the total sales
            bonuses[i] = totalSales * 0.05;
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonus for all stores.
     * 
     * @param data A two-dimensional array of store sales, where each row represents a store,
     *             and each column represents a sale for that store.
     * @return The total of all holiday bonuses.
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;

        // Calculate the holiday bonus for each store and add it to the total
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Sample data: sales for 3 stores, each with 4 sales
        double[][] storeSales = {
            {5000, 6000, 7000, 8000}, // Store 1
            {4000, 4000, 4000, 4000}, // Store 2
            {3000, 3000, 3000, 3000}  // Store 3
        };

        // Calculate individual store bonuses
        double[] storeBonuses = calculateHolidayBonus(storeSales);
        System.out.println("Holiday Bonuses for each store:");
        for (int i = 0; i < storeBonuses.length; i++) {
            System.out.println("Store " + (i + 1) + ": " + storeBonuses[i]);
        }

        // Calculate total holiday bonus
        double totalBonus = calculateTotalHolidayBonus(storeSales);
        System.out.println("Total Holiday Bonus: " + totalBonus);
    }

}
