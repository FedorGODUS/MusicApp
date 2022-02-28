package Andersen.SeqDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class SeqDemoApplication {
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.parse("8MB"));
		factory.setMaxRequestSize(DataSize.parse("8MB"));
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) {

		SpringApplication.run(SeqDemoApplication.class, args);
	}

}
