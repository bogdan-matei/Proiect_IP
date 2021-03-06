package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.ModelAndViewAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.usermanagement.DTO.NotificationDto;
import com.usermanagement.controllers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({/* include live config here
    e.g. "file:web/WEB-INF/application-context.xml",
    "file:web/WEB-INF/dispatcher-servlet.xml" */})
public class TriggeredNotificationsGetTest {
	private MockMvc mockMvc;
    private UsersRestController controllers= new UsersRestController();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	this.mockMvc = MockMvcBuilders.standaloneSetup(controllers).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() throws Exception {
		NotificationDto response = null;
	this.mockMvc.perform(get("/v1/users/2/notifications/triggered-notifications").contentType(MediaType.APPLICATION_JSON_UTF8).content("{"
				+ "\"method\":\"getTriggeredNotifications\","
				+ "\"userId\":2"
				+ "}"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.notifications[0].period", is("none")))
	            .andExpect(jsonPath("$.notifications[0].text", is("Trezirea de dimineata")))
	            .andExpect(jsonPath("$.notifications[0].day_timestamp", is(2315)))
	            .andExpect(jsonPath("$.notifications[1].period", is("daily")))
	            .andExpect(jsonPath("$.notifications[1].text", is("Alarma de la 9:15")))
	            .andExpect(jsonPath("$.notifications[1].day_timestamp", is(2315)));
	
	}
}
