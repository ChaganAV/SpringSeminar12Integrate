package ru.gb.springSeminar12.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.util.Map;

@Configuration
public class IntegrationConfig {
    @Bean
    public MessageChannel textInputChanel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChanel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer(){
        return text -> {
            // какая-то логика
            return text;
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler(){
        String dir = System.getProperty("user.dir");
        //String dir2 = "D:\\Code\\Java\\Spring\\SpringSeminar12\\SpringSeminar12Integrate\\files";
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(dir,"files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
