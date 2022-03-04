package com.conselhosdokanyerest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conselho {

	@Id
	private String quote;

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}
