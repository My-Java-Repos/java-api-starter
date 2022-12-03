package com.org.link.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.org.link.base.exception.exceptions.RemoteServiceCallFailedException;

@Configuration
public class RestConfig {
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(httpClientHttpRequestFactory());
	}

	@Value("${restTemplateConnectTimeout}")
	private Integer restTemplateConnectTimeout;

	@Value("${restTemplateReadTimeout}")
	private Integer restTemplateReadTimeout;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestConfig.class);

	@Bean
	public ClientHttpRequestFactory httpClientHttpRequestFactory() {

		CloseableHttpClient httpClient = null;
		HttpComponentsClientHttpRequestFactory httpClientHttpRequestFactory = null;

		try {
			httpClient = HttpClientBuilder.create().disableCookieManagement().build();
			httpClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			httpClientHttpRequestFactory.setConnectTimeout(restTemplateConnectTimeout);
			httpClientHttpRequestFactory.setReadTimeout(restTemplateReadTimeout);
		} catch (HttpServerErrorException e) {
			LOGGER.error("Exception orrcured when making a rest template call", e);
			throw new RemoteServiceCallFailedException("An error occured making rest template call", e.getStatusCode(),
					e.getStatusText(), e);

		}
		return httpClientHttpRequestFactory;
	}

}
