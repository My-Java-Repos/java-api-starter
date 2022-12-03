package com.org.link.config;

import static com.google.common.base.Predicates.not;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.org.link.base.swagger.LinkSwaggerConfig;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

	@Bean
	public Docket SkeletonApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("java-skeleton-idx-VALUE_TO_CHANGE")
				.apiInfo(skeletonApiInfo()).select().paths(skeletonApiPaths()).build();
	}

	private ApiInfo skeletonApiInfo() {
		return new ApiInfoBuilder().title("Skeleton API VALUE_TO_CHANGE")
				.description("API used by JAVA SKELETION VALUE_TO_CHANGE.").build();
	}

	private Predicate<String> skeletonApiPaths() {
		return not(LinkSwaggerConfig.springBootApiPaths());
	}
}
