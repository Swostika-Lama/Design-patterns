package Observer_Weather_Station_Simulator.model;

import Observer_Weather_Station_Simulator.View.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {
    private int temperature;
    private List<WeatherObserver> observers = new ArrayList<>();

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    //Add the observer
    public void registerObserver(WeatherObserver observer){
        observers.add(observer);
    }

    //remove observer
    public void removeObserver(WeatherObserver observer){
        observers.remove(observer);

    }

    //Notify all the observers
    public void notifyObservers(){
        for (WeatherObserver observer : observers){
            observer.updateTemperature(temperature);
        }

    }
}
