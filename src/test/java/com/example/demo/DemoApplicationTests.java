package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
		void testRemove_commonWord() throws Exception {
			mockMvc.perform(get("/remove").param("string", "Aprajita"))
					.andExpect(status().isOk())
					.andExpect(content().string("prajit"));
		}

	@Test
		void testRemove_twoCharacters() throws Exception {
			mockMvc.perform(get("/remove").param("string", "AB"))
					.andExpect(status().isOk())
					.andExpect(content().string(""));
		}

	@Test
		void testRemove_emptyString() throws Exception {
			mockMvc.perform(get("/remove").param("string", ""))
					.andExpect(status().isBadRequest());
		}

	@Test
		void testRemove_oneCharacter() throws Exception {
			mockMvc.perform(get("/remove").param("string", "A"))
					.andExpect(status().isBadRequest());
		}

	@Test
		void testRemove_threeCharacters() throws Exception {
			mockMvc.perform(get("/remove").param("string", "XYZ"))
					.andExpect(status().isOk())
					.andExpect(content().string("Y"));
		}

		// --- Strings with numbers and special characters ---
	@Test
		void testRemove_numbers() throws Exception {
			mockMvc.perform(get("/remove").param("string", "12345"))
					.andExpect(status().isOk())
					.andExpect(content().string("234"));
		}

	@Test
		void testRemove_specialCharacters() throws Exception {
			mockMvc.perform(get("/remove").param("string", "@Hello!"))
					.andExpect(status().isOk())
					.andExpect(content().string("Hell"));
		}

	@Test
		void testRemove_symbolsOnly() throws Exception {
			mockMvc.perform(get("/remove").param("string", "$%&*"))
					.andExpect(status().isOk())
					.andExpect(content().string("%&"));
		}
	}

