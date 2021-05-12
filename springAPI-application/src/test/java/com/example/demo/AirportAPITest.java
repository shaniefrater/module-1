package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * JUnit to test the Hello World logic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AirportAPITest {
	private static final ObjectMapper om = new ObjectMapper();
	@Autowired
	private MockMvc mockMvc;
	@Before
	public void init() {
	}
	@Test
	public void siteHome() throws Exception {
		mockMvc.perform(get("/").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("admin:nimda".getBytes())))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("message", is("Welcome to the Global Airports System")));
	}

	@Test
	public void getAirports() throws Exception {
		mockMvc.perform(get("/airports").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("admin:nimda".getBytes())))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("message", is("View all airports data")));
	}

	@Test
	public void getAirport() throws Exception {
		mockMvc.perform(get("/airports/{id}").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("admin:nimda".getBytes())))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("message", is("You are now viewing {id}")));
	}

	@Test
	public void addAirport() throws Exception {
		mockMvc.perform(post("/airports").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("admin:nimda".getBytes())))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("message", is("Please select which airport to add to the system")));
	}

	 /** private static void printJSON(Object object) {
		String result;
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	} */
}