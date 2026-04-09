package Bridge.remote;

import Bridge.device.Device;

public class SmartRemote implements Remote {
    protected Device device;

    public SmartRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }


    public void voiceControl(String command) {
        System.out.println("Command received: " + command);

        if (command.equalsIgnoreCase("open browser")) {
            System.out.println("Opening browser...");
        }
        else if (command.equalsIgnoreCase("play music")) {
            System.out.println("Playing music...");
        }
        else if (command.equalsIgnoreCase("shutdown")) {
            System.out.println("Shutting down...");
        }
        else {
            System.out.println("Unknown command");
        }
    }

}
