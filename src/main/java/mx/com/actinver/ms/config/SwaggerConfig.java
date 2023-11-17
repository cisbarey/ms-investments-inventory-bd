package mx.com.actinver.ms.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {

    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

    @Bean
    public GroupedOpenApi publicApi(@Value(value = "${spring.application.version}") String version){
        String[] packages = { "mx.com.actinver.ms.controllers" };
        String[] paths = { "/investments/inventory/instruments/**" };
        return GroupedOpenApi.builder()
                .group("InvestmentsInventoryBd")
                .addOpenApiCustomiser(openApi -> {
                    openApi.info(new Info().title("InvestmentsInventoryBd API").version(version));
                })
                .packagesToScan(packages)
                .pathsToMatch(paths)
                .build();
    }

}