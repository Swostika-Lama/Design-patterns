package Bridge.remote;

//package refactoring_guru.bridge.example.remotes;
//Got this code from https://refactoring.guru/design-patterns/bridge/java/example

public interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}
