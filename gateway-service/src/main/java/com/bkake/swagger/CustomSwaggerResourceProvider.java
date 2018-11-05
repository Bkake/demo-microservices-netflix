package com.bkake.swagger;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class CustomSwaggerResourceProvider implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        return Arrays.asList(
                swaggerResource.apply("new-service", "/new-service/v2/api-docs"),
                swaggerResource.apply("author-service", "/author-service/v2/api-docs"),
                swaggerResource.apply("category-service", "/category-service/v2/api-docs"));
    }

    private BiFunction<String, String, SwaggerResource> swaggerResource = (name, location) -> {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    };
}