package br.com.itau.notificacao.limite.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmailWebClientConfig {

	@Bean
	public WebClient emailWebClient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8181")
				.build();
	}
}
