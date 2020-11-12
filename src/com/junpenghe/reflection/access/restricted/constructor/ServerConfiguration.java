package com.junpenghe.reflection.access.restricted.constructor;

import java.net.InetSocketAddress;

/**
 * @author Junpeng He
 */
public class ServerConfiguration {
    private static ServerConfiguration serverConfiguration;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage) {
        this.serverAddress = new InetSocketAddress("localhost", port);
        this.greetingMessage = greetingMessage;

        if (serverConfiguration == null) {
            serverConfiguration = this;
        }
    }

    public static ServerConfiguration getInstance() {
        return serverConfiguration;
    }

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }
}
