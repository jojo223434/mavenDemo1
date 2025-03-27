package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements Runnable {
    private static final String DB_URL = "jdbc:sqlite:wind_turbine.db";
    private WindTurbineData data;

    public DatabaseHandler(WindTurbineData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO turbine_data (time, production, wind_speed, turbine1, turbine2, turbine3, turbine4, turbine5, turbine6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            // Sæt parametre til SQL-forespørgslen
            stmt.setString(1, data.getTime());
            stmt.setDouble(2, data.getProduction());
            stmt.setDouble(3, data.getWindSpeed());
            stmt.setDouble(4, data.getTurbine1());
            stmt.setDouble(5, data.getTurbine2());
            stmt.setDouble(6, data.getTurbine3());
            stmt.setDouble(7, data.getTurbine4());
            stmt.setDouble(8, data.getTurbine5());
            stmt.setDouble(9, data.getTurbine6());

            // Udfør forespørgslen
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             var stmt = conn.createStatement()) {
            // Opret tabel, hvis den ikke eksisterer
            stmt.execute("CREATE TABLE IF NOT EXISTS turbine_data (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "time TEXT NOT NULL," +
                    "production REAL NOT NULL," +
                    "wind_speed REAL NOT NULL," +
                    "turbine1 REAL NOT NULL," +
                    "turbine2 REAL NOT NULL," +
                    "turbine3 REAL NOT NULL," +
                    "turbine4 REAL NOT NULL," +
                    "turbine5 REAL NOT NULL," +
                    "turbine6 REAL NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
