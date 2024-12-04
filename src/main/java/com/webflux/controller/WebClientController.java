package com.webflux.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webflux.dto.ResponseJsonPlaceholderDTO;
import com.webflux.service.WebClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class WebClientController {
	private final WebClientService webClientService;

	public WebClientController(WebClientService webClientService) {
		this.webClientService = webClientService;
	}

	@GetMapping("/get")
	public Object index() {
		Mono<String> stringMono = webClientService.webfluxService();
		ObjectMapper om = new ObjectMapper();
		// Transform Mono String ke Mono DTO
		Mono<ResponseJsonPlaceholderDTO> monoDTO = stringMono.map(string -> {
			try {
				return om.readValue(string, ResponseJsonPlaceholderDTO.class);
			} catch (Exception e) {
				throw new RuntimeException("Error parsing JSON", e);
			}
		});

		// Log hasil saat nilai sudah tersedia
		monoDTO.subscribe(dto -> log.info("Response: {}", dto));

		return monoDTO;
	}
}
