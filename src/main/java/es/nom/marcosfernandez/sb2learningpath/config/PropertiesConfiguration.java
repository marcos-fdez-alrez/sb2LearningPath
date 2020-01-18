package es.nom.marcosfernandez.sb2learningpath.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("config")
public class PropertiesConfiguration {

    private String firstProperty;

    private String secondProperty;

    private Integer thirdProperty;

    private String fourthProperty;

}
