package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WindTurbineApp {
    private DefaultTableModel tableModel;
    private JProgressBar windSpeedBar;

    public void start() {
        // Opret hovedvindue
        JFrame frame = new JFrame("Vindtved Møllerne - Realtidsdata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);

        // Opret tabel til data
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Tid");
        tableModel.addColumn("Produktion (kW)");
        tableModel.addColumn("Vindhastighed (m/s)");
        tableModel.addColumn("Mølle 1 (kW)");
        tableModel.addColumn("Mølle 2 (kW)");
        tableModel.addColumn("Mølle 3 (kW)");
        tableModel.addColumn("Mølle 4 (kW)");
        tableModel.addColumn("Mølle 5 (kW)");
        tableModel.addColumn("Mølle 6 (kW)");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Opret en simpel grafisk repræsentation af vindhastighed med JProgressBar
        windSpeedBar = new JProgressBar(0, 20);
        windSpeedBar.setStringPainted(true);
        windSpeedBar.setBorder(BorderFactory.createTitledBorder("Vindhastighed (m/s)"));

        // Layout
        JPanel gaugePanel = new JPanel();
        gaugePanel.add(windSpeedBar);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(gaugePanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        // Opdater data automatisk hver 10. sekund
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateData();
            }
        }, 0, 10000);
    }

    private void updateData() {
        // Simuler data
        Random random = new Random();
        double production = 1000 + random.nextDouble() * 500; // Produktion mellem 1000 og 1500 kW
        int windSpeed = 5 + random.nextInt(6); // Vindhastighed mellem 5 og 10 m/s

        // Simuler produktion for hver mølle
        double turbine1 = 200 + random.nextDouble() * 100;
        double turbine2 = 200 + random.nextDouble() * 100;
        double turbine3 = 200 + random.nextDouble() * 100;
        double turbine4 = 200 + random.nextDouble() * 100;
        double turbine5 = 200 + random.nextDouble() * 100;
        double turbine6 = 200 + random.nextDouble() * 100;

        // Tilføj data til tabellen og opdater UI
        SwingUtilities.invokeLater(() -> {
            tableModel.addRow(new Object[]{
                    "Tid: " + (tableModel.getRowCount() * 10) + " min",
                    production,
                    windSpeed,
                    turbine1,
                    turbine2,
                    turbine3,
                    turbine4,
                    turbine5,
                    turbine6
            });

            windSpeedBar.setValue(windSpeed);
            windSpeedBar.setString(windSpeed + " m/s");
        });

        // Simuler lagring i en database i en separat tråd
        new Thread(() -> saveToDatabase(production, windSpeed, turbine1, turbine2, turbine3, turbine4, turbine5, turbine6)).start();
    }

    private void saveToDatabase(double production, double windSpeed, double... turbines) {
        // Simulerer databasehåndtering
        System.out.println("Gemmer data i databasen...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WindTurbineApp().start());
    }
}
