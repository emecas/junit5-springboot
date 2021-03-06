package net.emecas.junit5sprigboot.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import net.emecas.junit5springboot.controller.AdminController;
import net.emecas.junit5springboot.service.IService;


@SpringJUnitConfig(AdminControllerTest.Config.class)
@WebMvcTest
@RunWith(JUnitPlatform.class)
@DisplayName("When a admin is requested")
class AdminControllerTest {
	
	/*@Autowired WebApplicationContext wac;
	@Autowired MockHttpSession session;
	@Autowired MockHttpServletRequest request;
	MockMvc mockMvc;
	*/

    //@Autowired
    //private MockMvc mockMvc2;

    @MockBean
    IService iService;
	//@MockBean
    //GreetingService greetingService;

    @Autowired
    private MockMvc mockMvc;
	
    @ComponentScan(basePackageClasses = AdminController.class)
    static class Config {
    	
    }
    
    //@Disabled
	@Test
	@DisplayName("for a admin testStatus an OK")
	void testStatus() throws Exception {
		//mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	    MockHttpServletResponse response = mockMvc.perform(get("/admin/status")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
	}
	
    //@Disabled
	/*@Test
	@DisplayName("for for a greeting status testStatus2 an OK")
	void testStatus2() throws Exception {
		//mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("mockMvc2 -> "+mockMvc2);
        MockHttpServletResponse response = mockMvc2.perform(get("/greeting/status")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        //assertTrue(response.toString().contains("OK"));
	}*/

}
