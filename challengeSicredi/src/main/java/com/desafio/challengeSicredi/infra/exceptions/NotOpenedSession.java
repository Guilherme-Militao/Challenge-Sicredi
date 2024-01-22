package com.desafio.challengeSicredi.infra.exceptions;

public class NotOpenedSession extends Exception{

    public NotOpenedSession(String message) {
        super(message);
    }
}
