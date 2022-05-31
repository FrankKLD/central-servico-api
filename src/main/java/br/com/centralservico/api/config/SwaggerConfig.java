package br.com.centralservico.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/**")).build()
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Sistema Central de Serviços")
            .description("Sistema de Central de Serviços.").version("1.0.0").contact(getContactDetails())
            .license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").build();
    }

    private Contact getContactDetails() {
        return new Contact("Team CS Devs", "https://github.com/", "email@gmail.com");
    }

}