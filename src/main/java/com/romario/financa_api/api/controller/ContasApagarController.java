package com.romario.financa_api.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romario.financa_api.domain.repository.ContasApagarRepository;
import com.romario.financa_api.domain.service.CadastroContasApagarService;

@RestController
@RequestMapping("/contas")
public class ContasApagarController {
	
	@Autowired
	private ContasApagarRepository contasApagarRepository;
	
	@Autowired
	private CadastroContasApagarService contasApagarService;
	
	
	
	
	
}
