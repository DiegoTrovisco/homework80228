/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diego
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ErrorCity {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testInternalServerError() throws Exception {
		//mvc.perform(get("/"))
		//		.andExpect(status().isInternalServerError());
            mvc.perform(get("/")).param(nome do @RequestParam, "FailTest")).andExpect("Cidade incorreta")
	}
}