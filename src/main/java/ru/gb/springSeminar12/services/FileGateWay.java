package ru.gb.springSeminar12.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.logging.FileHandler;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateWay {
    public void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
