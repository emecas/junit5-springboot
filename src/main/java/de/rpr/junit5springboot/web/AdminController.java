package de.rpr.junit5springboot.web;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import de.rpr.junit5springboot.service.IService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final List<IService> iServices;
	
    public AdminController(final List<IService> iServices) {
        this.iServices = iServices;
    }

	
	@GetMapping("/status")
    String status() {
		Double a = Math.random();
		Double b = Math.random();
        return "{\"msn\"=\"OK "+a+"+"+b+"="+iServices.get(0).calcule(a, b)+ "\"}";
    }

}
