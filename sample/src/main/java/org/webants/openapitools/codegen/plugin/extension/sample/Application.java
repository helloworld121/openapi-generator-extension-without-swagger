package org.webants.openapitools.codegen.plugin.extension.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

}
