package com.example.SingerService;

import com.example.SingerService.controller.SingerController;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class SingerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingerServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return new RestTemplate(requestFactory);
	}

	@Bean
	public List<Docket> api(){
		Docket singerDocket = new Docket(DocumentationType.SWAGGER_2).groupName(SingerController.BASE_PATH)
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/"+SingerController.BASE_PATH+".*"))
				.build();
		List<Docket> docketList = new ArrayList<>();
		docketList.add(singerDocket);
		return docketList;
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Spring REST sample with Swager")
				.description("Spring REST sample with Swager")
				.contact("Platov Pavel Vladimirovich")
				.version("1.0")
				.build();
	}
}

