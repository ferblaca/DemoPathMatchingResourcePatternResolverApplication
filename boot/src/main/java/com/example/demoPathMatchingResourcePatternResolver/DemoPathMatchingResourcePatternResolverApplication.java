package com.example.demoPathMatchingResourcePatternResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Arrays;

@SpringBootApplication
public class DemoPathMatchingResourcePatternResolverApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DemoPathMatchingResourcePatternResolverApplication.class);

    private final PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    public static void main(String[] args) {
        SpringApplication.run(DemoPathMatchingResourcePatternResolverApplication.class, args);
    }

    @Value("${demo.regex}")
    public String regexPath;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Resource[] resources = this.resourceResolver.getResources(regexPath);
            Arrays.stream(resources).forEach(resource -> LOG.info("Resource: {}", resource));
        };
    }

}