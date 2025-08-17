package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Skeleton template for a controller test using MockMvc.
 *
 * You can use annotations from JUnit 5 such as @ParameterizedTest, @ValueSauce,
 * @CsvSource and @MethodSource for your test data.
 *
 * Example usage of mockMvc for a GET request
 * mockMvc.perform(get("/path-to-your-endpoint").param("your-query-param", param-value))
 *                 .andExpect(status().whateverStatusCodeYouExpect())
 *                 .andExpect(content().string("string-you-expect-in-response")).
 *                 .andExpect(jsonPath("$.jsonField").value("json-value-you-expect"));
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // add your test cases here
    
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
