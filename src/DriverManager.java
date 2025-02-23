//exception that handles wrong file name errors. Prevents system from crashing
import java.io.FileNotFoundException;
//allows files to be read
import java.io.File;
//a dynamic array
import java.util.ArrayList;
//an interface used to maintain order of elements
import java.util.List;
//used to read user input
import java.util.Objects;
import java.util.Scanner;

public class DriverManager {

    private List<Driver> drivers;

    //constructor to initialize list
    public DriverManager() {
        drivers = new ArrayList<>();
    }

    //method to add driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Successfully added driver.");
    }

    //method to remove a driver by name
    public void removeDriver(String driverName) {
        //enhanced for loop to iterate through array and find name
        for (Driver driver : drivers) {
            if (Objects.equals(driver.getDriverName(), driverName)) {
                drivers.remove(driver);
                System.out.println("Successfully removed driver.");
                return;
            }
        }
        //returns if matching id isn't found
        System.out.println("Driver not found.");
    }

    //method to display all drivers
    public void displayAllDrivers() {
        //checks if array is empty
        if (drivers.isEmpty()) {
            System.out.println("No drivers available to display.");
        } else {
            //enhanced for loop to iterate through array, format information, and display back to user
            for (Driver driver : drivers) {
                System.out.println(driver.getDriverName() + "-" + driver.getDriverNumber() + "-" + driver.getCurrentTeam() + "-" + driver.getAge() + driver.getNationality() + "-" + driver.getNumberOfRaces() + "-" + driver.getNumberOfWins() + "-" + driver.getIsActiveDriver() + driver.getHeight() + "-" + driver.getCareerPoints() + "\n");
            }
        }
    }

    //method to load information from a file and add drivers to F1 DMS
    public void loadDriversFromFile(String filename) {
        try {
            //creation of scanner object to read file with given name
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                //reads next line of file
                String line = fileScanner.nextLine();
                //splits information, uses hyphen as separation checkpoints
                String[] details = line.split("-");
                //checks if line has 10 parts
                if (details.length == 10) {
                    //assigns each part to a variable
                    String driverName = details[0].trim();
                    int driverNumber = Integer.parseInt(details[1].trim());
                    String currentTeam = details[2].trim();
                    int age = Integer.parseInt(details[3].trim());
                    String nationality = details[4].trim();
                    int numberOfRaces = Integer.parseInt(details[5].trim());
                    int numberOfWins = Integer.parseInt(details[6].trim());
                    boolean isActiveDriver = Boolean.parseBoolean(details[7].trim());
                    float height = Float.parseFloat(details[8].trim());
                    double careerPoints = Double.parseDouble(details[9].trim());
                    //creates new driver, initializes attributes, and adds to list of drivers
                    addDriver(new Driver(driverName, driverNumber, currentTeam, age, nationality, numberOfRaces, numberOfWins, isActiveDriver, height, careerPoints));
                } else {
                    //error message
                    System.out.println("Invalid data format in line: " + line);
                }
            }
            //closes scanner after reading file
            fileScanner.close();
            System.out.println("Drivers successfully loaded from file.");
            //catch block that deals with file not being found
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (Exception e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }


    //method for user interaction with DMS
    public void menu() {
        //scanner to read user input
        Scanner scanner = new Scanner(System.in);
        //loop that continues until user exits program
        while (true) {
            //menu options
            System.out.println("Select a number to continue.");
            System.out.println("1. Add Driver");
            System.out.println("2. Remove Driver");
            System.out.println("3. Display All Drivers");
            System.out.println("4. Load Drivers from File");
            System.out.println("5. Exit");
            //reads users choice as int
            int choice = scanner.nextInt();
            //handles users choice
            switch (choice) {
                case 1:
                    //adds new driver
                    System.out.print("Enter Driver Name: ");
                    scanner.nextLine();
                    String driverName = scanner.nextLine();
                    System.out.print("Enter Driver Number: ");
                    int driverNumber = scanner.nextInt();
                    System.out.print("Enter Current Team: ");
                    String currentTeam = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Nationality: ");
                    String nationality = scanner.next();
                    System.out.print("Enter Number of Races: ");
                    int numberOfRaces = scanner.nextInt();
                    System.out.print("Enter Number of Wins: ");
                    int numberOfWins = scanner.nextInt();
                    System.out.print("Is the driver Active?: ");
                    boolean isActiveDriver = scanner.nextBoolean();
                    System.out.print("Enter Height: ");
                    float height = scanner.nextFloat();
                    System.out.print("Enter Career Points: ");
                    double careerPoints = scanner.nextDouble();
                    //creates new driver based on user input
                    addDriver(new Driver(driverName, driverNumber, currentTeam, age, nationality, numberOfRaces, numberOfWins, isActiveDriver, height, careerPoints));
                    break;
                case 2:
                    //removes driver
                    System.out.print("Enter driver name to remove: ");
                    driverName = scanner.next();
                    removeDriver(driverName);
                    break;
                case 3:
                    //displays all drivers
                    displayAllDrivers();
                    break;
                case 4:
                    //loads drivers from file
                    System.out.print("Enter filename to load drivers: ");
                    scanner.nextLine(); // Consume newline
                    String filename = scanner.nextLine();
                    loadDriversFromFile(filename);
                    break;
                case 5:
                    //exits program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    //handles invalid choice
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
