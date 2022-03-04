package com.conselhosdokanyerest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.conselhosdokanyerest.entities.Conselho;

@FeignClient(name = "api.kanye", url = "https://api.kanye.rest/")
public interface IConselhoService {

	@GetMapping("/{quote}/")
	Conselho consultarPorId(@PathVariable("quote") String quote);

}
