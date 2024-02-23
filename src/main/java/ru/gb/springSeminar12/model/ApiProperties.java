package ru.gb.springSeminar12.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix="product.api")
@Component
public class ApiProperties {
    private String url;
}
