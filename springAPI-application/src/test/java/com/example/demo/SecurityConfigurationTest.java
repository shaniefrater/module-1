package com.example.demo;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

    /**
     * JUnit to test the Hello World logic
     */
    @RunWith(SpringRunner.class)
    @SpringBootTest
    @AutoConfigureMockMvc
    @ActiveProfiles("test")
    public class SecurityConfigurationTest {
        private static final ObjectMapper om = new ObjectMapper();
        @Autowired
        private MockMvc mockMvc;
        @Before
        public void init() {
        }

        @Test
        public void errorMessage() throws Exception {
            mockMvc.perform(get("/airports").header(HttpHeaders.AUTHORIZATION,
                    "Basic " + Base64Utils.encodeToString("admin:nimda".getBytes())))
                    .andExpect(status().isUnauthorized())
                    .andExpect(status().is4xxClientError());
        }
}
