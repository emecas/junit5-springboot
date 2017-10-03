package de.rpr.junit5springboot;



import de.rpr.junit5springboot.web.AdminController;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

@SpringJUnitConfig(AdminControllerTest.Config.class)
@WebMvcTest
@DisplayName("When a admin is requested")
class AdminControllerTest {
	
	@Autowired WebApplicationContext wac;
	@Autowired MockHttpSession session;
	@Autowired MockHttpServletRequest request;
	
	static MockMvc mockMvc;
	
    @ComponentScan(basePackageClasses = AdminController.class)
    static class Config {
    	
    }
    
	@Test
	@DisplayName("for a admin testStatus an OK")
	void testStatus() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	    MockHttpServletResponse response = mockMvc.perform(get("/admin/status")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
	}
	
	@Test
	@DisplayName("for for a greeting status testStatus2 an OK")
	void testStatus2() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("mockMvc -> "+mockMvc);
        MockHttpServletResponse response = mockMvc.perform(get("/greeting/status")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        //assertTrue(response.toString().contains("OK"));
	}

}
