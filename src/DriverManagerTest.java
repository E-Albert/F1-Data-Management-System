import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DriverManagerTest {

    //creating object to be tested
    Driver driver;
    DriverManager manager;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Initialize DriverManager before each test
        manager = new DriverManager();
        //supplying test data to driver
        driver = new Driver("Emerson Albert", 8, "Mercedes", 27, "American", 100, 96,  true, 189, 2343.5);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Add driver test")
    void addDriver() {
        // Add driver to the manager
        boolean result = manager.addDriver(driver);

        // Test that the result is true (driver was successfully added)
        assertTrue(result);

        // Check if the driver is indeed in the list by using displayAllDrivers
        manager.displayAllDrivers();
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Remove driver test")
    void removeDriver() {
        // Add driver first
        manager.addDriver(driver);

        // Remove the driver
        boolean result = manager.removeDriver("Emerson Albert");

        // Test that the result is true (driver was successfully removed)
        assertTrue(result);

        // Try to remove a non-existing driver and check if it returns false
        result = manager.removeDriver("Non Existing Driver");
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Display all drivers test")
    void displayAllDrivers() {
        // Add driver to the manager
        manager.addDriver(driver);

        // Display all drivers and check if the expected driver is displayed
        boolean result = manager.displayAllDrivers();

        // Test that there is at least one driver in the list
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Load drivers from file test")
    void loadDriversFromFile() {
        // Define the file path
        String filePath = "/Users/emersonalbert/Desktop/SD1/F1testdata.txt";

        // Check if the file exists before proceeding with the test
        File file = new File(filePath);
        assertTrue(file.exists(), "Test data file does not exist!");

        // Try to load drivers from the file
        boolean result = manager.loadDriversFromFile(filePath);

        // Verify that the loadDriversFromFile method returns true if file is successfully read
        assertTrue(result, "Drivers should be loaded successfully from the file");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Update driver test")
    void updateDriver() {
        DriverManager manager = new DriverManager();

        // Create and add an initial driver
        Driver driver = new Driver(
                "Emerson Albert", 12345, "Ferrari", 30, "American", 150, 80, true, 1.80f, 300);
        manager.addDriver(driver);

        // Create an updated driver object with the new details
        Driver updatedDriver = new Driver(
                "Emerson Albert", 12345, "Ferrari", 31, "American", 155, 85, true, 1.80f, 290);

        // Attempt to update the driver
        boolean result = manager.updateDriver("Emerson Albert", updatedDriver);

        // Assert that the update was successful
        assertTrue(result);

        // Try updating a driver that doesn't exist
        boolean nonExistingUpdate = manager.updateDriver("Non Existing Driver", updatedDriver);
        assertFalse(nonExistingUpdate, "Updating a non-existing driver should return false");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Calculate win ratio test")
    void calculateWinRatio() {
        // Add driver first
        manager.addDriver(driver);

        // Calculate win ratio
        boolean result = manager.calculateWinRatio("Emerson Albert");

        // Test that the result is true (win ratio was calculated)
        assertTrue(result);

        // Try calculating win ratio for a driver that doesn't exist
        result = manager.calculateWinRatio("Non Existing Driver");
        assertFalse(result);
    }
}