package net.emecas.junit5springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(JUnitPlatform.class)
class AdditionServiceTest {
	
    @Autowired
    private AdditionService target;
    
    @BeforeEach
    public void init() {
    		target = new AdditionService();
    }

	@Test
	void testAdditionCalcule() {
		System.out.println("target -> "+target);
		Double result = target.calcule(1D, 2D);
		assertEquals(3d,result.doubleValue());
	}

}
