package net.emecas.junit5springboot.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionService implements IService {

	@Override
	public Double calcule(Double term1, Double term2) {
		return term1+term2;
	}

}
