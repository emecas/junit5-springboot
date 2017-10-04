package de.rpr.junit5springboot;

import de.rpr.junit5springboot.service.GreetingService;
import de.rpr.junit5springboot.service.IService;
import de.rpr.junit5springboot.web.GreetingNewController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringJUnitConfig(GreetingNewControllerTest.Config.class)
@WebMvcTest
@DisplayName("When a new/greeting is requested")
class GreetingNewControllerTest {

    @ComponentScan(basePackageClasses = GreetingNewController.class)
    static class Config {
    }

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService greetingService;
    @MockBean
    IService iService;


    @Test
    @DisplayName("for a new casual occasion a GreetingService should produce a result")
    void casual_greeting_should_invoke_greetingService() throws Exception {
    	System.out.println("mockMvc -> "+mockMvc);
        when(greetingService.accepts(any())).thenReturn(true);
        System.out.println("mockMvc -> "+mockMvc);
        MockHttpServletResponse response = mockMvc.perform(get("/new/greeting/casual")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        verify(greetingService).casualGreeting();
    }

    @Test
    @DisplayName("for a new morning greeting a GreetingService should produce a result")
    void morning_greeting_should_invoke_greetingService() throws Exception {
        when(greetingService.accepts(any())).thenReturn(true);
        MockHttpServletResponse response = mockMvc.perform(get("/new/greeting/morning")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        verify(greetingService).goodMorning();
    }

    @Test
    @DisplayName("in an new unknown way an HTTP status 404 is expected")
    void unknown_request_should_result_in_httpStatus_notFound() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/new/greeting/unknown")).andReturn().getResponse();
        assertTrue(response.getStatus() == 404);
    }
    
	@Test
	@DisplayName("for a new greeting status an OK")
	void testStatus() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/new/greeting/status")).andReturn().getResponse();
        assertTrue(response.getStatus() == 200);
        //assertTrue(response.toString().contains("OK"));
	}
    
}
