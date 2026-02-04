package Observer_Weather_Station_Simulator.model;

import java.util.Random;

public class WeatherStation extends Thread {
    private WeatherData data;
    private final int MIN_TEMP = -15;
    private final int MAX_TEMP = 40;
    private Random random = new Random();

    public WeatherStation(WeatherData data){
        this.data = data;
        // Initialize random temperature in WeatherData
        data.setTemperature(random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP);
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        int newTemp = data.getTemperature() + change;

        if (newTemp > MAX_TEMP) newTemp = MAX_TEMP;
        if (newTemp < MIN_TEMP) newTemp = MIN_TEMP;

        data.setTemperature(newTemp); // notify observers automatically
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateTemperature();
        }
    }
}
