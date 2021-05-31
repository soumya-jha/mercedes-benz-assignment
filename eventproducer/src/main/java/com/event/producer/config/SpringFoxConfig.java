package com.event.producer.config;

import com.common.constant.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(basicAuthScheme()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                CommonConstant.EVENT_API_TITLE,
                CommonConstant.EVENT_API_DESCRIPTION,
                CommonConstant.API_VERSION,
                "",
                new Contact(CommonConstant.CONTACT_NAME, "", CommonConstant.CONTACT_EMAIL),
                "", "", Collections.emptyList());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .forPaths(PathSelectors.ant("/event/api/v1/**"))
                .build();
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference(CommonConstant.AUTH_TYPE, new AuthorizationScope[0]);
    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth(CommonConstant.AUTH_TYPE);
    }
}