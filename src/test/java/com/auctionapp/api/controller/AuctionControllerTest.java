package com.auctionapp.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.auctionapp.api.service.AuctionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { AuctionController.class })
public class AuctionControllerTest {

	@MockBean
	private AuctionService ingredientService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAuctionsNewArrivalsSuccess() throws Exception {
		mvc.perform(get("/api/auctions/new_arrivals")).andExpect(status().isOk());
	}

	@Test
	public void getAuctionsLastChanceSuccess() throws Exception {
		mvc.perform(get("/api/auctions/last_chance")).andExpect(status().isOk());
	}
}
