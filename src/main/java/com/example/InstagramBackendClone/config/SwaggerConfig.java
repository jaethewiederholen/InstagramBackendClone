package com.example.InstagramBackendClone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    private String version;
    private String title;

    @Bean
    public Docket apiV1() {
        version = "V1";
        title = "Instagram Backend Clone API" + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.InstagramBackendClone.api"))
                .paths(PathSelectors.ant("/v1/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Instagram Backend Clone API Doc",
                version,
                "www.example.com",
                new Contact("Contact Me", "www.example.com", "foo@example.com"),
                "Licenses",

                "www.example.com",

                new ArrayList<>());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

}
