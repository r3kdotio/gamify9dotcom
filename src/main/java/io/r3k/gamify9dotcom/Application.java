package io.r3k.gamify9dotcom;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        if (args.length == 2) {
            String pkcs12 = args[0];
            String pkcs12Password = args[1];
            log.info("Setting up TLS via keystore " + pkcs12);
            Properties properties = System.getProperties();
            properties.put("server.port", "8443");
            properties.put("security.require-ssl", "true");
            properties.put("server.ssl.key-store", pkcs12);
            properties.put("server.ssl.keyStoreType", "pkcs12");
            properties.put("server.ssl.key-store-password", pkcs12Password);
            properties.put("server.ssl.key-password", pkcs12Password);
        } else {
            log.info("NOT Setting up TLS");
        }

        SpringApplication.run(Application.class, args);
    }

}
