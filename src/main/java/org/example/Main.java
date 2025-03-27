package org.example;

public class Main {
    public static void main(String[] args) {
        // Initialiser databasen
        DatabaseHandler.initializeDatabase();

        // Opret en instans af WindTurbineApp og start den
        WindTurbineApp app = new WindTurbineApp();
        app.start();
    }
}

