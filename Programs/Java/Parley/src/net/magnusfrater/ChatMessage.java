package net.magnusfrater;

import java.io.Serializable;

public class ChatMessage implements Serializable {

    static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
    private int type;
    private String message;

    ChatMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }
    int getType() {
        return type;
    }

    String getMessage() {
        return message;
    }
}