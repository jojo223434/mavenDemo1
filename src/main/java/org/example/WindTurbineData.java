package org.example;

public class WindTurbineData {
    private String time;
    private double production;
    private double windSpeed;
    private double turbine1;
    private double turbine2;
    private double turbine3;
    private double turbine4;
    private double turbine5;
    private double turbine6;

    // Constructor
    public WindTurbineData(String time, double production, double windSpeed, double turbine1, double turbine2, double turbine3, double turbine4, double turbine5, double turbine6) {
        this.time = time;
        this.production = production;
        this.windSpeed = windSpeed;
        this.turbine1 = turbine1;
        this.turbine2 = turbine2;
        this.turbine3 = turbine3;
        this.turbine4 = turbine4;
        this.turbine5 = turbine5;
        this.turbine6 = turbine6;
    }

    // Getters
    public String getTime() {
        return time;
    }

    public double getProduction() {
        return production;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getTurbine1() {
        return turbine1;
    }

    public double getTurbine2() {
        return turbine2;
    }

    public double getTurbine3() {
        return turbine3;
    }

    public double getTurbine4() {
        return turbine4;
    }

    public double getTurbine5() {
        return turbine5;
    }

    public double getTurbine6() {
        return turbine6;
    }
}

