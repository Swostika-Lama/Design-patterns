//package refactoring_guru.bridge.example.devices;
//Got this code from https://refactoring.guru/design-patterns/bridge/java/example
package Bridge.device;

public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}