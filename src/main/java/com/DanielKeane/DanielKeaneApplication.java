package com.DanielKeane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DanielKeaneApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(DanielKeaneApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(DanielKeaneApplication.class);
  }
}
