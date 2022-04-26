package com.bithumb.msacommunity.router;

import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public GroupedOpenApi replyApi() {
        return GroupedOpenApi.builder()
                .group("Reply")
                .pathsToMatch("/community/reply/**")
                //.addOpenApiCustomiser(getOpenApiCustomiser())
                .build();
    }

    @Bean
    public GroupedOpenApi boardApi() {
        return GroupedOpenApi.builder()
                .group("Board")
                .pathsToMatch("/community/write")
                //.addOpenApiCustomiser(getOpenApiCustomiser())
                .build();
    }

    @Bean
    public GroupedOpenApi boardListApi() {
        return GroupedOpenApi.builder()
                .group("BoardList")
                .pathsToMatch("/community/list")
                //.addOpenApiCustomiser(getOpenApiCustomiser())
                .build();
    }

    @Bean
    public GroupedOpenApi hideApi() {
        return GroupedOpenApi.builder()
                .group("hide")
                .pathsToMatch("/community/admin/**/hide")
//                .addOpenApiCustomiser(tokenUseCustom())
                .build();
    }

    //Token Use
    public OpenApiCustomiser tokenUseCustom() {

        return openAPI -> openAPI.getPaths().values().stream().flatMap(pathItem ->
                        pathItem.readOperations().stream())
                .forEach(operation -> {
                    operation.addParametersItem(new Parameter().name("Authorization").in("header").
                            schema(new StringSchema().example("token")).required(true));

                });
    }


}