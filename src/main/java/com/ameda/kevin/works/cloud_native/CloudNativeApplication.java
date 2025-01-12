package com.ameda.kevin.works.cloud_native;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ConfigurationPropertiesScan()
public class CloudNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeApplication.class, args);
	}


	@ConfigurationProperties(prefix = "demo")
	record DemoProperties( String message ){}

	@RestController
	class DemoController{

		private final DemoProperties properties;

        DemoController(DemoProperties properties) {
            this.properties = properties;
        }

        @GetMapping("/")
		public Mono<String> getMessage(){
			return Mono.just(properties.message());
		}

	}

}
