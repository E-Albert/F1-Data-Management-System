package com.f1data.management;

public class Driver {
    //driver attributes
    private String driverName;
    private int driverNumber;
    private String currentTeam;
    private int age;
    private String nationality;
    private int numberOfRaces;
    private int numberOfWins;
    private boolean isActiveDriver;
    private float height;
    private double careerPoints;

    //constructor to initializes driver attributes
    public Driver(String driverName, int driverNumber, String currentTeam, int age,
                  String nationality, int numberOfRaces, int numberOfWins, boolean isActiveDriver, float height, double careerPoints) {
        this.driverName = driverName;
        this.driverNumber = driverNumber;
        this.currentTeam = currentTeam;
        this.age = age;
        this.nationality = nationality;
        this.numberOfRaces = numberOfRaces;
        this.numberOfWins = numberOfWins;
        this.isActiveDriver = isActiveDriver;
        this.height = height;
        this.careerPoints = careerPoints;
    }

    //getter methods
    public String getDriverName() {
        return driverName;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public boolean getIsActiveDriver() {
        return isActiveDriver;
    }

    public float getHeight() {
        return height;
    }

    public double getCareerPoints() {
        return careerPoints;
    }

    //setters
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public void setIsActiveDriver(boolean isActiveDriver) {
        this.isActiveDriver = isActiveDriver;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setCareerPoints(double careerPoints) {
        this.careerPoints = careerPoints;
    }
}

