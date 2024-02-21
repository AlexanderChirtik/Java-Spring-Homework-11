package com.example.listWorkers.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Интерфейст для записи данных о новом работнике в отдельный файл с помощью интергации Spring.
 * Входным каналом для интерфейса является метод textInputChanel() из файла конфигурации.
 */
@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {

    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
