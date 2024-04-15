package com.Swino.TrainingJava;

public class Thermometre {

    //Attribut
    private double temperatureKelvin;

    //Contructeur
    public Thermometre(double temperatureKelvin) {
        this.temperatureKelvin = temperatureKelvin;
    }

    //Getter Setter
    public void setTemperatureKelvin(double temperatureKelvin) {
        this.temperatureKelvin = temperatureKelvin;
    }
    public double getTemperatureKelvin() {
        return this.temperatureKelvin;
    }

    //Methode pour convertir l'attribut
    public void conversion(UniteTemperature unite){
        switch(unite){
            case KELVIN:
                this.setTemperatureKelvin(this.temperatureKelvin);
                break;
            case FAHRENHEIT:
                this.setTemperatureKelvin(((this.temperatureKelvin-273.15)*1.8)+32);
                break;
            case CELSIUS:
                this.setTemperatureKelvin(this.temperatureKelvin-273.15);
                break;
        }
    }
}
