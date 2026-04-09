package Bridge;

import Bridge.device.Device;
import Bridge.device.SmartTv;
import Bridge.remote.SmartRemote;

public class Main {
    public static void main(String[] args) {
        Device smartTV = new SmartTv();
        SmartRemote remote = new SmartRemote(smartTV);

        remote.power();
        remote.volumeUp();

        smartTV.printStatus();
        ((SmartTv) smartTV).browseInternet("youtube.com");
        remote.voiceControl("Play music");
    }
}