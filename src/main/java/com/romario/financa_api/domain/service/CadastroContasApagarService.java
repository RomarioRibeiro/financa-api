package com.romario.financa_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.financa_api.domain.repository.ContasApagarRepository;

@Service
public class CadastroContasApagarService {

	@Autowired
	private ContasApagarRepository contasApagarRepository;
	
}
